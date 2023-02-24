package com.example.infrastructure.datasource.mysql;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.category.Category;
import com.example.domain.category.CategoryId;
import com.example.domain.category.CategoryList;
import com.example.domain.category.CategoryRepository;
import com.example.domain.user.UserId;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class CategoryMysqlDataSource implements CategoryRepository {
	
	
	private final JdbcTemplate jdbcTemplate;
	
	
	@Transactional
	@Override
	public void save(CategoryList categoryList) {
		String deleteCategoriesQuery = "DELETE FROM myexpenses_categories WHERE user_id = ?";
		String insertCategoryQuery = "INSERT INTO myexpenses_categories"
				+ "(category_id, category_name, user_id) VALUES(?, ?, ?)";
		
		String userId = categoryList.getUserId().getValue();
		this.jdbcTemplate.update(deleteCategoriesQuery, userId);
		for(Category category: categoryList.all()) {
			String categoryId = category.getCategoryId().getValue();
			String categoryName = category.getCategoryName();
			this.jdbcTemplate.update(insertCategoryQuery, categoryId, categoryName, userId);
		}
	}
	
	
	@Override
	public CategoryList findByUserId(UserId userId) {
		CategoryList categoryList = new CategoryList(userId);
		String selectCategoriesQuery = "SELECT myexpenses_categories.category_name FROM myexpenses_categories"
				+ " WHERE myexpenses_categories.user_id = ?";
		List<Map<String, Object>> records = this.jdbcTemplate.queryForList(selectCategoriesQuery, userId.getValue());
		
		if(records.size() > 0) {
			Comparator<Map<String, Object>> comparator = new Comparator<>() {
				public int compare(Map<String, Object> record1, Map<String, Object> record2) {
					String categoryName1 = (String) record1.get("category_name");
					String categoryName2 = (String) record2.get("category_name");
					return categoryName1.compareTo(categoryName2);
				}
			};
			Collections.sort(records, comparator);
			
			for(Map<String, Object> record: records) {
				CategoryId categoryId = new CategoryId((String) record.get("category_id"));
				String categoryName = (String) record.get("category_name");
				categoryList.add(categoryId, categoryName);
			}	
		}
		
		return categoryList;
	}
	
	
}
