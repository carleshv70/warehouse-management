package com.chuix.warehouse.management.controller;

import static com.chuix.warehouse.management.config.Constants.ITEM_ISNT_EXIST;
import static com.chuix.warehouse.management.config.Constants.PATH_CREATE_ACTION;
import static com.chuix.warehouse.management.config.Constants.PATH_DELETE_ACTION;
import static com.chuix.warehouse.management.config.Constants.PATH_GETALL_ACTION;
import static com.chuix.warehouse.management.config.Constants.PATH_GET_ACTION;
import static com.chuix.warehouse.management.config.Constants.PATH_UPDATE_ACTION;
import static com.chuix.warehouse.management.config.Constants.PATH_WAREHOUSE_BASE;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chuix.warehouse.management.Services.WarehouseService;
import com.chuix.warehouse.management.dtos.WarehouseDto;
import com.chuix.warehouse.management.mapper.WarehouseMapper;


@Controller
@RequestMapping(PATH_WAREHOUSE_BASE)
@CrossOrigin(origins = { "http://localhost:4200"}, allowedHeaders = {"**"}) 
public class WarehouseController {
	
	private final WarehouseService service;
	private final WarehouseMapper warehouseMapper;
	
	public WarehouseController(WarehouseService service, WarehouseMapper warehouseMapper) {
		this.service = service;
		this.warehouseMapper = warehouseMapper;
	}

	@GetMapping(PATH_GETALL_ACTION)
	public ResponseEntity<?>  index() {
		List<WarehouseDto> response = new ArrayList<>();
		response = this.service.findAll().stream()
				.map(warehouseMapper::mapToDto).collect(Collectors.toList());
		return new ResponseEntity<List<WarehouseDto>>(response, HttpStatus.OK); 
	}
	
	@GetMapping(PATH_GET_ACTION)
	public ResponseEntity<?> get(@PathVariable Integer id) {
		
		Map<String,Object> response = new HashMap<>();
		WarehouseDto warehouseDto;
		
		try {
			warehouseDto = this.warehouseMapper.mapToDto(this.service.getWarehouse(id));
		}
		catch (DataAccessException e) {
			response.put("message", "Error querying database");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		if(warehouseDto == null) {
			response.put("message", "warehouse ID: ".concat(id.toString().concat(ITEM_ISNT_EXIST)));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<WarehouseDto>(warehouseDto, HttpStatus.OK);
	}	
	
	
	@PostMapping(PATH_CREATE_ACTION )
	public ResponseEntity<?> createWarehouse(@Valid @RequestBody WarehouseDto itemDto, BindingResult result) {
		
		Map<String,Object> response = new HashMap<>();
		
		if(result.hasErrors()) {
			return prepareValidErrorResponse(result, response);
		}

		try {
			response.put("warehouse", 
					this.warehouseMapper.mapToDto(
						this.service.create( this.warehouseMapper.mapToEntity(itemDto) )));
		}
		catch (IllegalArgumentException ex) {
			response.put("Error", ex.getMessage());
			return ResponseEntity.badRequest().body(response);
		}
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	
	@PutMapping(PATH_UPDATE_ACTION)
	public ResponseEntity<?> updateWarehouse(@PathVariable Integer id, 
											@Valid @RequestBody WarehouseDto itemDto, 
											BindingResult result) {
		
		Map<String,Object> response = new HashMap<>();
		
		if(result.hasErrors()) {
			return prepareValidErrorResponse(result, response);
		}
		
		try {
			response.put("warehouse", 
					this.warehouseMapper.mapToDto(
						this.service.update(id, this.warehouseMapper.mapToEntity(itemDto) )));
		}
		catch (IllegalArgumentException ex) {
			response.put("Error", ex.getMessage());
			return ResponseEntity.badRequest().body(response);
		}
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	@DeleteMapping(	PATH_DELETE_ACTION)
	public ResponseEntity<?> delete(@PathVariable Integer id) {
		
		Map<String,Object> response = new HashMap<>();
		
		try {
			this.service.delete(id);
		}
		catch (IllegalArgumentException ex) {
			response.put("Error", ex.getMessage());
			return ResponseEntity.badRequest().body(response);
		}
		response.put("message", "The warehouse has been deleted correctly");
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
		
	}
	
	// Prepare response when DTO is not valid
	private ResponseEntity<?> prepareValidErrorResponse(BindingResult result, Map<String,Object> response) {
		List<String> errors = result.getFieldErrors()
				.stream()
				.map(err -> "Field '" + err.getField() +"' "+ err.getDefaultMessage())
				.collect(Collectors.toList());
		
		response.put("errors", errors);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
	}
	
	

}
