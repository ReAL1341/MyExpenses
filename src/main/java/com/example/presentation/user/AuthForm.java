package com.example.presentation.user;

import com.example.application.user.AuthToken;

import jakarta.servlet.http.HttpServletRequest;
import lombok.Getter;

@Getter
public class AuthForm {
	
	
	private String email;
	private String password;
	
	
	public AuthForm(HttpServletRequest request) {
		this.email = request.getParameter("email");
		this.password = request.getParameter("password");
	}
	
	
	public AuthToken createToken() {
		return new AuthToken(this.email, this.password);
	}
	
	
}
