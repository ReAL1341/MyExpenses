package com.example.domain.user;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.domain.DomainException;
import com.example.domain.category.User;
import com.example.domain.category.UserId;

class UserTest {
	
	
	private User user;
	
	
	@BeforeEach
	void setUp() {
		this.user = new User(new UserId());
	}
	
	
	@Test
	void addTest() {
		this.user.add("食費");
		this.user.add("娯楽費");
		this.user.add("交通費");
		
		assertThat(user.getCategories().get(0).getCategoryName(), is("食費"));
		assertThat(user.getCategories().get(0).getColorCode(), is("#FF0000"));
		assertThat(user.getCategories().get(1).getCategoryName(), is("娯楽費"));
		assertThat(user.getCategories().get(1).getColorCode(), is("#FFFF00"));
		assertThat(user.getCategories().get(2).getCategoryName(), is("交通費"));
		assertThat(user.getCategories().get(2).getColorCode(), is("#0000FF"));
	}
	
	
	@Test
	void addNewCategoryTest() throws Exception {
		this.user.addNewCategory("食費");
		this.user.addNewCategory("娯楽費");
		this.user.addNewCategory("交通費");
		
		assertThat(user.getCategories().get(0).getCategoryName(), is("食費"));
		assertThat(user.getCategories().get(0).getColorCode(), is("#FF0000"));
		assertThat(user.getCategories().get(1).getCategoryName(), is("娯楽費"));
		assertThat(user.getCategories().get(1).getColorCode(), is("#FFFF00"));
		assertThat(user.getCategories().get(2).getCategoryName(), is("交通費"));
		assertThat(user.getCategories().get(2).getColorCode(), is("#0000FF"));
	}
	
	
	@Test
	void addDuplicatedCategoryTest() {
		this.user.add("娯楽費");
		
		assertThrows(DomainException.class, () -> this.user.addNewCategory("娯楽費"));
	}
	
	
	@Test
	void limitOverTest() {
		int limit = 20;
		for(int i = 0; i < limit; i++) {
			String category = "category" + i;
			assertDoesNotThrow(() -> this.user.addNewCategory(category));
		}
		assertThrows(DomainException.class, () -> this.user.addNewCategory("category"));
	}
	
	
}
