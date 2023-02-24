package com.example.domain.item;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PaymentTest {
	
	
	private static final String INCOME = PaymentBalance.INCOME.toString();
	private static final String EXPENDITURE = PaymentBalance.EXPENDITURE.toString();
	
	
	@Test
	@DisplayName("amountが0のPaymentを生成するテスト")
	void createZeroPaymentTest() {
		// 準備
		Payment expectedPayment = new Payment(INCOME, 0);
		
		// 処理
		Payment actualPayment = new Payment();
		
		// 検証
		assertThat(actualPayment, is(expectedPayment));
	}
	
	
	@Test
	@DisplayName("income + incomeのテスト")
	void incomePlusIncomeTest() {
		for(int i = 0; i < 10; i++) {
			// 準備
			Random random = new Random();
			int value1 = Math.abs(Math.round(random.nextInt() / 3));
			int value2 = Math.abs(Math.round(random.nextInt() / 3));
			Payment expectedPayment = new Payment(INCOME, value1 + value2);
			
			// 処理
			Payment actualPayment = new Payment();
			actualPayment = actualPayment.plus(new Payment(INCOME, value1));
			actualPayment = actualPayment.plus(new Payment(INCOME, value2));
			
			// 検証
			assertThat(actualPayment, is(expectedPayment));
		}
	}
	
	
	@Test
	@DisplayName("expenditure + expenditureのテスト")
	void expenditurePlusExpenditureTest() {
		for(int i = 0; i < 10; i++) {
			// 準備
			Random random = new Random();
			int value1 = Math.abs(Math.round(random.nextInt() / 3));
			int value2 = Math.abs(Math.round(random.nextInt() / 3));
			Payment expectedPayment = new Payment(EXPENDITURE, value1 + value2);
			
			// 処理
			Payment actualPayment = new Payment();
			actualPayment = actualPayment.plus(new Payment(EXPENDITURE, value1));
			actualPayment = actualPayment.plus(new Payment(EXPENDITURE, value2));
			
			// 検証
			assertThat(actualPayment, is(expectedPayment));
		}
	}
	
	
	@Test
	@DisplayName("income + expenditure(income <= expenditure)のテスト")
	void incomePlusBigExpenditureTest() {
		for(int i = 0; i < 10; i++) {
			// 準備
			Random random = new Random();
			int value1 = Math.abs(Math.round(random.nextInt() / 3));
			int value2 = Math.abs(Math.round(random.nextInt() / 3));
			Payment expectedPayment = new Payment(EXPENDITURE, Math.abs(value1 - value2));
			
			// 処理
			Payment actualPayment = new Payment();
			actualPayment = actualPayment.plus(new Payment(INCOME, Math.min(value1,value2)));
			actualPayment = actualPayment.plus(new Payment(EXPENDITURE, Math.max(value1, value2)));
			
			// 検証
			assertThat(actualPayment, is(expectedPayment));
		}
	}
	
	
	@Test
	@DisplayName("income + expenditure(expenditure <= income)のテスト")
	void incomePlusSmallExpenditureTest() {
		for(int i = 0; i < 10; i++) {
			// 準備
			Random random = new Random();
			int value1 = Math.abs(Math.round(random.nextInt() / 3));
			int value2 = Math.abs(Math.round(random.nextInt() / 3));
			Payment expectedPayment = new Payment(INCOME, Math.abs(value1 - value2));
			
			// 処理
			Payment actualPayment = new Payment();
			actualPayment = actualPayment.plus(new Payment(INCOME, Math.max(value1,value2)));
			actualPayment = actualPayment.plus(new Payment(EXPENDITURE, Math.min(value1, value2)));
			
			// 検証
			assertThat(actualPayment, is(expectedPayment));
		}
	}
	
	
	@Test
	@DisplayName("amountが負の整数のとき例外を発生させるテスト")
	void createNegativePaymentAmountTest() {
		// 処理・検証
		assertThrows(IllegalArgumentException.class, () -> new Payment(INCOME, -1));
	}
	
	
	@Test
	@DisplayName("balanceがincomeとexpenditure以外のとき例外を発生させるテスト")
	void createIncorrectPaymentBalanceTest() {
		// 処理・検証
		assertThrows(IllegalArgumentException.class, () -> new Payment("imcome", 500));
		assertThrows(IllegalArgumentException.class, () -> new Payment("", 0));
	}
	
	
}
