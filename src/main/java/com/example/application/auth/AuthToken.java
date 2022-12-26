package com.example.application.auth;

import org.apache.commons.codec.digest.DigestUtils;

import lombok.Value;

@Value
public class AuthToken {
	
	
	private final String value;
	
	
	public AuthToken(String email, String password) {
		StringBuilder builder = new StringBuilder();
		builder.append(DigestUtils.sha3_256Hex(email));
		builder.append(DigestUtils.sha3_256Hex(password));
		this.value = builder.toString();
	}
	
	
	
}
