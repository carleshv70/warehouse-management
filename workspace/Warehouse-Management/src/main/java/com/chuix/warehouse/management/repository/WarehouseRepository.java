package com.chuix.warehouse.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chuix.warehouse.management.model.Warehouse;

public interface WarehouseRepository extends JpaRepository<Warehouse, Integer> {

}
