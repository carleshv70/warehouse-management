package com.chuix.warehouse.management.dtos;

import static com.chuix.warehouse.management.config.Constants.FIELD_CANNOT_BE_NULL;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Component
@Data
public class WarehouseDto implements Serializable {

	@NotNull(message = FIELD_CANNOT_BE_NULL)
	private Integer id;
	
	@NotNull(message = FIELD_CANNOT_BE_NULL)
	@Size(max = 36)
	private String uuid; 

	@NotNull(message = FIELD_CANNOT_BE_NULL)
	@Size(max = 50)
	private String client; 

	@NotNull(message = FIELD_CANNOT_BE_NULL)
	@Size(max = 3)
	private String family; 
	
	@NotNull(message = FIELD_CANNOT_BE_NULL)
	private Integer size; 

	@Setter(AccessLevel.NONE)
	@Getter(AccessLevel.NONE)
	private static final long serialVersionUID = 6116202366261065539L;
}
