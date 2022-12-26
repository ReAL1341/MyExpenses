package com.example.domain.user;

import java.util.UUID;

import lombok.RequiredArgsConstructor;
import lombok.Value;

@Value
@RequiredArgsConstructor
public class UserId {
	
	
	private final String value;
	
	
	public UserId() {
		this.value = UUID.randomUUID().toString();
	}
	
	
}
