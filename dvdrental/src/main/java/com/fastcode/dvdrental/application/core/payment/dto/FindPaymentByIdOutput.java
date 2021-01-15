package com.fastcode.dvdrental.application.core.payment.dto;

import java.time.*;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;

@Getter @Setter
public class FindPaymentByIdOutput {

  	private BigDecimal amount;
  	private LocalDate paymentDate;
  	private Integer paymentId;
  	private Integer customerId;
  	private String customerDescriptiveField;
  	private Integer rentalId;
  	private Integer rentalDescriptiveField;
  	private Integer staffId;
  	private String staffDescriptiveField;
	private Long versiono;
 
}

