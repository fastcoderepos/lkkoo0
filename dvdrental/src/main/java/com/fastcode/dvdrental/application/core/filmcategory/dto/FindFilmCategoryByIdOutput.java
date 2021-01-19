package com.fastcode.dvdrental.application.core.filmcategory.dto;

import java.time.*;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class FindFilmCategoryByIdOutput {

  	private Integer categoryId;
  	private Integer filmId;
  	private Integer categoryDescriptiveField;
  	private Integer filmDescriptiveField;
	private Long versiono;
 
}

