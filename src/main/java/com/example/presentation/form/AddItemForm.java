package com.example.presentation.form;

import java.io.Serializable;
import java.time.LocalDate;

import com.example.application.param.AddItemParam;

import lombok.Data;

@Data
public class AddItemForm implements Serializable {
	
	
	private String recordDate;
	private String itemName;
	private String paymentBalance;
	private int paymentAmount;
	private String categoryId;
	
	
	public AddItemParam createParam(String userId) {
		return new AddItemParam(
				userId,
				LocalDate.parse(this.recordDate),
				this.itemName,
				this.paymentBalance,
				this.paymentAmount,
				this.categoryId);
	}
	
	
}
