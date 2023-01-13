package com.example.domain.category;

import java.util.UUID;

import lombok.RequiredArgsConstructor;
import lombok.Value;

@Value
@RequiredArgsConstructor
public class CategoryId {
	
	
	private final String value;
	
	
	public CategoryId() {
		this.value = UUID.randomUUID().toString();
	}
	
	
}
