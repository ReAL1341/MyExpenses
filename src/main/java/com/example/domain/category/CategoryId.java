package com.example.domain.category;

import java.util.UUID;

import lombok.Getter;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Getter
public class CategoryId {
	
	
	private final String value;
	
	
	public static CategoryId issue() {
		String newItemId = UUID.randomUUID().toString();
		return new CategoryId(newItemId);
	}
	
	
}
