package com.chuix.warehouse.management.config;

public class Constants {

	//Routers 
	public static final String PATH_WAREHOUSE_BASE = "/warehouses";
	public static final String PATH_CREATE_ACTION = "/add";
	public static final String PATH_UPDATE_ACTION = "/{id}";
	public static final String PATH_DELETE_ACTION = "/{id}";
	public static final String PATH_GET_ACTION = "/{id}";
	public static final String PATH_GETALL_ACTION = "/";
	
	
	// Validations messages 
	public static final String FIELD_CANNOT_BE_NULL = "This field cannot be null";
	
	
	// Errors messages
	public static final String DATA_ISNT_VALID  = "Data is not valid";
	public static final String ITEM_ISNT_EXIST  = "Item is not exist";
	
	
}
