package com.example.domain.item;

import com.example.domain.category.CategoryId;

public class CategoryItems extends Items {
	
	
	private final CategoryId categoryId;
	
	
	public CategoryItems(CategoryId categoryId) {
		super();
		this.categoryId = categoryId;
	}
	
	
	@Override
	public void add(Item item) {
		if(!item.comparesCategory(this.categoryId)) {
			throw new IllegalArgumentException("異なるカテゴリーの項目が追加されました");
		}
		this.items.add(item);
	}
	
	
}
