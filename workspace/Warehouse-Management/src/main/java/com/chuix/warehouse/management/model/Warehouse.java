package com.chuix.warehouse.management.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "WAREHOUSES")
@Data()
public class Warehouse implements Serializable  {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	@Column(name = "ID")
	private Integer id;
	
	@Column(unique = true, nullable = false, name = "UUID", length = 36)
	private String uuid; 

	@Column(nullable = false, name ="CLIENT", length = 50)
	private String client; 

	@Column(nullable = false, name ="FAMILY", length = 3)
	private String family; 
	
	@Column(nullable = false, name ="SIZE", length = 2)
	private Integer size; 
	
	@Setter(AccessLevel.NONE)
	@Getter(AccessLevel.NONE)
	private static final long serialVersionUID = -883114158959139379L;
}
