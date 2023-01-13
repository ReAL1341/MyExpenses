package com.example.infrastructure.datasource.test;

import java.util.HashMap;
import java.util.Map;

import com.example.domain.category.CategoryList;
import com.example.domain.category.CategoryRepository;
import com.example.domain.user.UserId;

public class CategoryTestDataSource implements CategoryRepository {
	
	
	private Map<UserId, CategoryList> dataSource;
	
	
	public CategoryTestDataSource() {
		this.dataSource = new HashMap<>();
	}
	
	
	public void save(CategoryList categoryList) {
		this.dataSource.put(categoryList.getUserId(), categoryList);
	}
	
	
	public CategoryList findByUserId(UserId userId) {
		if(dataSource.containsKey(userId)) {
			return this.dataSource.get(userId);
		}else {
			return null;
		}
	}
	
	
}
