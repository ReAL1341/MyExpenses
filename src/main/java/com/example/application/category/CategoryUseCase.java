package com.example.application.category;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.DomainException;
import com.example.domain.category.Category;
import com.example.domain.category.CategoryId;
import com.example.domain.category.CategoryList;
import com.example.domain.category.CategoryRepository;
import com.example.domain.user.UserId;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryUseCase {
	
	
	private final CategoryRepository categoryRepository;
	
	
	@Transactional
	public void createNewCategory(CategoryParam param) throws DomainException {
		UserId userId = new UserId(param.getUserId());
		CategoryList categoryList = this.categoryRepository.findByUserId(userId);
		CategoryId categoryId = new CategoryId();
		categoryList.register(categoryId, param.getCategoryName());
		this.categoryRepository.save(categoryList);
	}
	
	
	public List<CategoryDto> fetchCategories(CategoryParam param) {
		// RepositoryからCategoryListを取得
		UserId userId = new UserId(param.getUserId());
		CategoryList categoryList = this.categoryRepository.findByUserId(userId);
		
		// EntityからDTOへの詰め替え
		List<CategoryDto> categories = new ArrayList<>();
		for(Category category: categoryList.all()) {
			CategoryDto categoryDto = CategoryDto.of(category);
			categories.add(categoryDto);
		}
		
		return categories;
	}
	
	
}
