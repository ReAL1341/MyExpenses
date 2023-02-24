package com.example.presentation.form;

import java.io.Serializable;

import com.example.application.param.FetchDailyItemsParam;

import lombok.Data;

@Data
public class FetchDailyItemsForm implements Serializable {
	
	
	private int year;
	private int month;
	
	
	public FetchDailyItemsParam createParam(String userId) {
		return new FetchDailyItemsParam(userId, this.year, this.month);
	}
	
	
}
