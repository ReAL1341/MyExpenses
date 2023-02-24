package com.example.domain.item;

public enum PaymentBalance {
	
	
	INCOME("income"),
	EXPENDITURE("expenditure");
	
	
	private final String balance;
	
	
	private PaymentBalance(String balance) {
		this.balance = balance;
	}
	
	
	public String toString() {
		return this.balance;
	}
	
	
}
