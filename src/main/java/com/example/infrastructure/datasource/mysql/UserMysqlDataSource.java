package com.example.infrastructure.datasource.mysql;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.user.Category;
import com.example.domain.user.User;
import com.example.domain.user.UserId;
import com.example.domain.user.UserRepository;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class UserMysqlDataSource implements UserRepository {
	
	
	private final JdbcTemplate jdbcTemplate;
	
	
	@Transactional
	public void save(User user) {
		String deleteCategoriesQuery = "DELETE FROM myexpenses_categories WHERE user_id = ?";
		String insertCategoryQuery = "INSERT INTO myexpenses_categories"
				+ "(category_id, category_name, user_id) VALUES(0, ?, ?)";
		
		this.jdbcTemplate.update(deleteCategoriesQuery, user.getUserId().getValue());
		for(Category category: user.getCategories()) {
			this.jdbcTemplate.update(insertCategoryQuery, category.getCategoryName(), user.getUserId().getValue());
		}
	}
	
	
	public User findByUserId(UserId userId) {
		User user = new User(userId);
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
				user.add((String) record.get("category_name"));
			}
			
			return user;
		}else {
			return null;
		}
	}
	
	
}
