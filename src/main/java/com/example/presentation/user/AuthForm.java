package com.example.presentation.user;

import com.example.application.user.AuthToken;

import lombok.Data;

@Data
public class AuthForm {
	
	
	private final String email;
	private final String password;
	
	
	public AuthToken createToken() {
		return new AuthToken(this.email, this.password);
	}
	
	
}
