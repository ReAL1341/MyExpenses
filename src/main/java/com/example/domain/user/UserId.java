package com.example.domain.user;

import java.util.UUID;

import lombok.Value;

@Value
public class UserId {
	
	
	private final String value;
	
	
	public static UserId issue() {
		String newUserId = UUID.randomUUID().toString();
		return new UserId(newUserId);
	}
	
	
}
