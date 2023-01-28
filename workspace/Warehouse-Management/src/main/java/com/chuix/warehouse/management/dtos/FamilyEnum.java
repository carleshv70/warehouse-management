package com.chuix.warehouse.management.dtos;


public enum FamilyEnum {
	
	EST("EST"),
	ROB("ROB");

	private String value;
	
	FamilyEnum(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return this.value;
	}
	
	public FamilyEnum getFromValue(String value) {

		for (FamilyEnum familyEnum : FamilyEnum.values()) {
			if (familyEnum.getValue().equals(value)) {
				return familyEnum;
			}
		}
		return null;
	}

	

}
