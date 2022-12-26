package com.example.presentation.user;

import java.util.ArrayList;
import java.util.List;

import com.example.application.user.CategoryDto;

public class DtosConverter {
	
	
	public static List<CategoryJsonBean> toJsonBeans(List<CategoryDto> categoryDtos) {
		List<CategoryJsonBean> jsonBeans = new ArrayList<>();
		for(CategoryDto categoryDto: categoryDtos) {
			CategoryJsonBean jsonBean = new CategoryJsonBean();
			jsonBean.setCategoryName(categoryDto.getCategoryName());
			jsonBean.setColorCode(categoryDto.getColorCode());
			jsonBeans.add(jsonBean);
		}
		return jsonBeans;
	}
	
	
}
