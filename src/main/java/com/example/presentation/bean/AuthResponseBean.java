package com.example.presentation.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthResponseBean implements Serializable {
	
	
	private String userId;
	private List<String> messages;
	
	
	public AuthResponseBean() {
		this.messages = new ArrayList<>();
	}
	
	
	public void addMessage(String message) {
		this.messages.add(message);
	}
	
	
}
