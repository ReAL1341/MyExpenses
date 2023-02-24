package com.example.application.dto;

import com.example.domain.category.Category;
import com.example.domain.item.Item;

import lombok.Getter;

@Getter
public class ItemDto {
	
	
	private String itemId;
	private String itemName;
	private String paymentBalance;
	private String paymentAmount;
	private String categoryName;
	
	
	private ItemDto() {}
	
	
	public static ItemDto of(Item item, Category category) {
		ItemDto itemDto = new ItemDto();
		itemDto.itemId = item.getItemId().getValue();
		itemDto.itemName = item.getItemName();
		itemDto.paymentBalance = item.getPayment().getBalance().toString();
		itemDto.paymentAmount = item.getPayment().getMoneyFormat();
		itemDto.categoryName = category.getCategoryName();
		return itemDto;
	}
	
	
}
