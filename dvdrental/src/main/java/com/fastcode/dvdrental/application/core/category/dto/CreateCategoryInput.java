package com.fastcode.dvdrental.application.core.category.dto;

import java.time.*;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CreateCategoryInput {

  	@NotNull(message = "name Should not be null")
  	@Length(max = 25, message = "name must be less than 25 characters")
  	private String name;
  

}

