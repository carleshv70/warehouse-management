package com.chuix.warehouse.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chuix.warehouse.management.model.Rack;

public interface RackRepository extends JpaRepository<Rack, Integer> {

}
