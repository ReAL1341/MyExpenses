package com.example.domain.item;

import java.time.LocalDate;

import com.example.domain.category.CategoryId;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Item {
	
	
	private final ItemId itemId;
	private LocalDate recordDate;
	private String itemName;
	private int payment;
	private CategoryId categoryId;
	
	
}