package com.example.domain.item;

import java.util.UUID;

import lombok.Getter;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Getter
public class ItemId {
	
	
	private final String value;
	
	
	public static ItemId issue() {
		String newItemId = UUID.randomUUID().toString();
		return new ItemId(newItemId);
	}
	
	
}
