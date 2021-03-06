package com.fastcode.dvdrental.application.core.address.dto;

import java.time.*;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CreateAddressInput {

  	@NotNull(message = "address Should not be null")
  	@Length(max = 50, message = "address must be less than 50 characters")
  	private String address;
  
  	@Length(max = 50, message = "address2 must be less than 50 characters")
  	private String address2;
  
  	@NotNull(message = "district Should not be null")
  	@Length(max = 20, message = "district must be less than 20 characters")
  	private String district;
  
  	@NotNull(message = "phone Should not be null")
  	@Length(max = 20, message = "phone must be less than 20 characters")
  	private String phone;
  
  	@Length(max = 10, message = "postalCode must be less than 10 characters")
  	private String postalCode;
  
  	private Integer cityId;

}

