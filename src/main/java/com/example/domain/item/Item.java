package com.example.domain.item;

import com.example.domain.category.CategoryId;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Getter
@EqualsAndHashCode
public class Item {
	
	
	private final ItemId itemId;
	private final RecordDate recordDate;
	private final String itemName;
	private final Payment payment;
	private final CategoryId categoryId;
	
	
	public boolean comparesCategory(CategoryId categoryId) {
		return this.categoryId == categoryId;
	}
	
	
	public boolean comparesRecordDate(RecordDate date) {
		return this.recordDate.equals(date);
	}
	
	
}