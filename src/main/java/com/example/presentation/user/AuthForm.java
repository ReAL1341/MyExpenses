package com.example.presentation.user;

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
	
	
}
