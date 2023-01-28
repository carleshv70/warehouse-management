package com.chuix.warehouse.management.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Data;

@Entity
@Table(name = "RACKS")
@EntityListeners(AuditingEntityListener.class)
@Data
public class Rack {

	@Id
	@GeneratedValue
	@Column(name = "ID")
	private Integer id;
	
	@Column(unique = true, nullable = false, name = "WAREHOUSE_ID")
	private Warehouse warehouseId;

	@Column(unique = true, nullable = false, name = "UUID")
	@Size(max = 36)
	private String uuid;
	
	@Column(unique = true, nullable = false, name = "TYPE")
	@Size(max = 1)
	private String type;
	
    @CreatedDate
    private Timestamp createdDate;

    @CreatedBy
    private String createdBy;
}
