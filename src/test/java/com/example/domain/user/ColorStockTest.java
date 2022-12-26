package com.example.domain.user;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ColorStockTest {
	
	
	private ColorStock colorStock;
	
	
	@BeforeEach
	void setUp() {
		this.colorStock = new ColorStock();
	}
	
	
	@Test
	void popTest() {
		String colorCode1 = colorStock.pop();
		assertThat(colorCode1, is("#FF0000"));
		String colorCode2 = colorStock.pop();
		assertThat(colorCode2, is("#FFFF00"));
		String colorCode3 = colorStock.pop();
		assertThat(colorCode3, is("#0000FF"));
		String colorCode4 = colorStock.pop();
		assertThat(colorCode4, is("#008000"));
		String colorCode5 = colorStock.pop();
		assertThat(colorCode5, is("#FF00FF"));
		String colorCode6 = colorStock.pop();
		assertThat(colorCode6, is("#FFD700"));
		String colorCode7 = colorStock.pop();
		assertThat(colorCode7, is("#00FFFF"));
		String colorCode8 = colorStock.pop();
		assertThat(colorCode8, is("#00FF00"));
		String colorCode9 = colorStock.pop();
		assertThat(colorCode9, is("#800080"));
		String colorCode10 = colorStock.pop();
		assertThat(colorCode10, is("#A52A2A"));
	}
	
	
	@Test
	void popOverTest() {
		int limit = 20;
		for(int i = 0; i < limit; i++) {
			assertDoesNotThrow(() -> this.colorStock.pop());
		}
		assertThrows(IllegalStateException.class, () -> this.colorStock.pop());
	}
	
	
}
