package com.chuix.technnicalTest.Mecalux.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;
import lombok.Data;

@Entity(name = "RACKS")
@Data
public class Rack {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
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
}
