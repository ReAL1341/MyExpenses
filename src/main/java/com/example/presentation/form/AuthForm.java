package com.example.presentation.form;

import com.example.application.user.AuthToken;

import lombok.Data;

@Data
public class AuthForm {
	
	
	private String email;
	private String password;
	
	
	public AuthToken createToken() {
		return new AuthToken(this.email, this.password);
	}
	
	
}
