package com.example.application.user;

import com.example.domain.user.Category;

import lombok.Getter;

@Getter
public class CategoryDto {
	
	
	private String categoryName;
	private String colorCode;
	
	
	private CategoryDto() {}
	
	
	public static CategoryDto of(Category category) {
		CategoryDto categoryDto = new CategoryDto();
		categoryDto.setCategoryName(category.getCategoryName());
		categoryDto.setColorCode(category.getColorCode());
		return categoryDto;
	}
	
	
	private void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
	
	private void setColorCode(String colorCode) {
		this.colorCode = colorCode;
	}
	
	
}
