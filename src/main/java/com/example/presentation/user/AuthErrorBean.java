package com.example.presentation.user;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class AuthErrorBean implements Serializable {
	
	
	private List<String> messages = new ArrayList<>();
	
	
	public void addMessage(String message) {
		this.messages.add(message);
	}
	
	
}
