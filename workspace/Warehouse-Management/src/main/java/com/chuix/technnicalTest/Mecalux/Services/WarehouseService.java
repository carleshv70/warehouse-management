package com.chuix.technnicalTest.Mecalux.Services;

import java.util.List;

import com.chuix.technnicalTest.Mecalux.model.Warehouse;

public interface WarehouseService {

	Warehouse create(Warehouse item) throws IllegalArgumentException; 
	Warehouse update(Integer id, Warehouse item) throws IllegalArgumentException;
	void delete(Integer id) throws IllegalArgumentException;
	Warehouse getWarehouse(Integer id); 
	List<Warehouse> findAll();
}
