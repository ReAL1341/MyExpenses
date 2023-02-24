package com.example.application.param;

import java.time.LocalDate;

import lombok.Data;

@Data
public class AddItemParam {
	
	
	private final String userId;
	private final LocalDate recordDate;
	private final String itemName;
	private final String paymentBalance;
	private final int paymentAmount;
	private final String categoryId;
	
	
}
