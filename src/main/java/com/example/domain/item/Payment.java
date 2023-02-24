package com.example.domain.item;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
public class Payment {
	
	
	private final PaymentBalance balance;
	private final int amount;
	
	
	public Payment() {
		this.balance = PaymentBalance.INCOME;
		this.amount = 0;
	}
	
	
	public Payment(String balance, int amount) {
		if(amount < 0) {
			throw new IllegalArgumentException("amountは非負整数を入力してください");
		}
		this.amount = amount;
		
		if(balance.equals(PaymentBalance.INCOME.toString())) {
			this.balance = PaymentBalance.INCOME;
		}else if(balance.equals(PaymentBalance.EXPENDITURE.toString())) {
			this.balance = PaymentBalance.EXPENDITURE;
		}else {
			throw new IllegalArgumentException("balanceが不正な値です");
		}
	}
	
	/**
	 * Paymentの加算を行う。
	 * @return Payment
	 */
	public Payment plus(Payment payment) {
		int newAmount = this.calcSignedAmount() + payment.calcSignedAmount();
		if(0 <= newAmount) {
			String newBalance = PaymentBalance.INCOME.toString();
			return new Payment(newBalance, newAmount);
		}else {
			String newBalance = PaymentBalance.EXPENDITURE.toString();
			return new Payment(newBalance, -1 * newAmount);
		}
	}
	
	
	public String getMoneyFormat() {
		return String.format("%,3d", this.amount);
	}
	
	
	private int calcSignedAmount() {
		if(this.balance == PaymentBalance.INCOME) {
			return this.amount;
		}else {
			return -1 * this.amount;
		}
	}
	
	
}
