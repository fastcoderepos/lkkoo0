package com.fastcode.dvdrental.application.core.rental.dto;

import java.time.*;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CreateRentalOutput {

    private LocalDate rentalDate;
    private Integer rentalId;
    private LocalDate returnDate;
	private Integer customerId;
	private String customerDescriptiveField;
	private Integer inventoryId;
	private Short inventoryDescriptiveField;
	private Integer staffId;
	private String staffDescriptiveField;

}

