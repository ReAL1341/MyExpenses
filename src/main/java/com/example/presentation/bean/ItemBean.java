package com.example.presentation.bean;

import java.io.Serializable;

import lombok.Data;

@Data
public class ItemBean implements Serializable {
	
	
	private String itemId;
	private String itemName;
	private String paymentBalance;
	private String paymentAmount;
	private String categoryName;
	
	
}
