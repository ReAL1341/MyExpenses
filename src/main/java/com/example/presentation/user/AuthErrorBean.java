package com.example.presentation.user;

import java.io.Serializable;

import lombok.Data;

@Data
public class AuthErrorBean implements Serializable {
	
	
	private String email;
	private String message;
	
	
}
