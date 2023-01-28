package com.chuix.warehouse.management.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import com.chuix.warehouse.management.dtos.WarehouseDto;
import com.chuix.warehouse.management.model.Warehouse;

@Mapper(
		componentModel = "spring",
		unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface WarehouseMapper {

	WarehouseMapper INSTANCE = Mappers.getMapper(WarehouseMapper.class);
	WarehouseDto mapToDto(Warehouse entity);
	Warehouse  mapToEntity(WarehouseDto dto);
	
	void update(@MappingTarget Warehouse targetEntity, Warehouse sourceEntity);

			
}
