package com.chuix.technnicalTest.Mecalux.Services;

import static com.chuix.technnicalTest.Mecalux.config.Constants.DATA_ISNT_VALID;
import static com.chuix.technnicalTest.Mecalux.config.Constants.ITEM_ISNT_EXIST;
import com.chuix.technnicalTest.Mecalux.mapper.WarehouseMapper;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chuix.technnicalTest.Mecalux.model.Warehouse;
import com.chuix.technnicalTest.Mecalux.repository.RackRepository;
import com.chuix.technnicalTest.Mecalux.repository.WarehouseRepository;

@Service
public class WarehouseServiceImpl implements WarehouseService {
	
	@Autowired
	private RackRepository rackRepository;
	
	@Autowired
	private WarehouseRepository warehouseRepository;
	
	@Autowired
	private WarehouseMapper wareHouseMapper;

	@Override
	@Transactional(readOnly = false)
	public Warehouse create(Warehouse item) throws IllegalArgumentException {
		
		if(null == item) {
			throw new IllegalArgumentException(DATA_ISNT_VALID);
		}
		return this.warehouseRepository.save(item);
	}

	@Override
	@Transactional(readOnly = false)
	public Warehouse update(Integer id, Warehouse item) throws IllegalArgumentException {
		
		Optional<Warehouse> optItem = this.warehouseRepository.findById(id);
		
		if(!optItem.isPresent()) {
			throw new IllegalArgumentException(ITEM_ISNT_EXIST);
		}
		
		Warehouse itemDB = optItem.get();
		this.wareHouseMapper.update(item,itemDB);
		return this.warehouseRepository.save(itemDB);
	}

	@Override
	@Transactional(readOnly = false)
	public void delete(Integer id) throws IllegalArgumentException {
		
		Optional<Warehouse> optItem = this.warehouseRepository.findById(id);
		
		if(!optItem.isPresent()) {
			throw new IllegalArgumentException(ITEM_ISNT_EXIST);
		}
		
		this.warehouseRepository.deleteById(optItem.get().getId());
	}

	@Override
	@Transactional(readOnly = true)
	public Warehouse getWarehouse(Integer id) {
		return this.warehouseRepository.findById(id).orElse(null);
	}

	@Override
	public List<Warehouse> findAll() {
		return this.warehouseRepository.findAll();
	}
}
