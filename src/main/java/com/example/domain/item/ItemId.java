package com.example.domain.item;

import java.util.UUID;

import lombok.RequiredArgsConstructor;
import lombok.Value;

@Value
@RequiredArgsConstructor
public class ItemId {
	
	
	private final String value;
	
	
	public ItemId() {
		this.value = UUID.randomUUID().toString();
	}
	
	
}
