package com.example.domain.item;

import lombok.Value;

@Value
public class Payment {
	
	
	private final PaymentBalance balance;
	private final int amount;
	
	
	public Payment(String balance, int amount) {
		if(amount < 0) {
			throw new IllegalArgumentException();
		}
		switch (balance) {
		case "income":
			this.balance = PaymentBalance.INCOME;
			break;
		case "expenditure":
			this.balance = PaymentBalance.EXPENDITURE;
			break;
		default:
			throw new IllegalArgumentException();
		}
		this.amount = amount;
	}
	
	
	public Payment plus(Payment payment) {
		int newAmount = payment.amount;
		if(payment.balance == PaymentBalance.EXPENDITURE) {
			newAmount *= -1;
		}
		int sum = this.amount + newAmount;
		
		if(0 <= sum) {
			return new Payment("income", sum);
		}else {
			return new Payment("expenditure", sum * -1);
		}
	}
	
	
}
