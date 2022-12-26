package com.example.application.user;

import java.util.ArrayList;
import java.util.List;

import com.example.domain.user.Category;
import com.example.domain.user.User;

import lombok.Getter;

@Getter
public class UserDto {
	
	
	// 項目のリストも持たせたい
	private String userId;
	private List<CategoryDto> categories;
	
	
	private UserDto() {
		this.categories = new ArrayList<>();
	}
	
	
	public static UserDto of(User user) {
		UserDto userDto = new UserDto();
		userDto.setUserId(user.getUserId().getValue());
		for(Category category: user.getCategories()) {
			CategoryDto categoryDto = CategoryDto.of(category);
			userDto.addCategory(categoryDto);
		}
		return userDto;
	}
	
	
	private void setUserId(String userId) {
		this.userId = userId;
	}
	
	
	private void addCategory(CategoryDto category) {
		this.categories.add(category);
	}
	
	
}
