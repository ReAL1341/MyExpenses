package com.example.domain.category;

import java.util.ArrayList;
import java.util.List;

import com.example.domain.DomainException;
import com.example.domain.user.UserId;

import lombok.Getter;

public class CategoryList {
	
	@Getter
	private final UserId userId;
	private final List<Category> categories;
	private final ColorStock colorStock;
	
	
	public CategoryList(UserId userId) {
		this.userId = userId;
		this.categories = new ArrayList<>();
		this.colorStock = new ColorStock();
	}
	
	
	public List<Category> all() {
		return this.categories;
	}
	
	
	/**
	 * バリデーションなしでカテゴリーを一覧に追加する。
	 * 初期カテゴリーの追加やRepositoryでの再構成に使用する。
	 */
	public void add(CategoryId categoryId, String categoryName) {
		Category category = new Category(categoryId, categoryName, this.colorStock.pop());
		this.categories.add(category);
	}
	
	
	/**
	 * 新規のカテゴリーを登録する。
	 * カテゴリー名の重複禁止や個数制限のバリデーションをかける。
	 * @throws DomainException 既存のカテゴリーを追加しようとした場合、
	 * カテゴリーの個数制限を超過した場合
	 */
	public void register(CategoryId categoryId, String categoryName) throws DomainException {
		for(Category category: this.categories) {
			if(categoryName == category.getCategoryName()) {
				throw new DomainException("このカテゴリーはすでに存在しています");
			}
		}
		if(this.colorStock.getSize() == 0) {
			throw new DomainException("これ以上カテゴリーを追加できません");
		}
		
		Category category = new Category(categoryId, categoryName, this.colorStock.pop());
		this.categories.add(category);
	}
	
	
	public Category findByCategoryId(CategoryId categoryId) {}
	
	
}
