package com.chuix.technnicalTest.Mecalux.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import com.chuix.technnicalTest.Mecalux.dtos.WarehouseDto;
import com.chuix.technnicalTest.Mecalux.model.Warehouse;

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
