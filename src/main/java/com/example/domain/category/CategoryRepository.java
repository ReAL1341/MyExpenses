package com.example.domain.category;

import com.example.domain.user.UserId;

public interface CategoryRepository {
	
	
	/**
	 * カテゴリーの新規保存・更新を行う。
	 */
	void save(CategoryList categoryList);
	
	
	/**
	 * カテゴリーの取得を行う。
	 */
	CategoryList findByUserId(UserId userId);
	
	
}
