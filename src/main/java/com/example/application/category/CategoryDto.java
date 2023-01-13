package com.example.application.category;

import com.example.domain.category.Category;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryDto {
	
	
	private String categoryId;
	private String categoryName;
	private String colorCode;
	
	
	private CategoryDto() {}
	
	
	public static CategoryDto of(Category category) {
		CategoryDto categoryDto = new CategoryDto();
		categoryDto.setCategoryId(category.getCategoryId().getValue());
		categoryDto.setCategoryName(category.getCategoryName());
		categoryDto.setColorCode(category.getColorCode());
		return categoryDto;
	}
	
	
}
