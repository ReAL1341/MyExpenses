package com.example.application.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.application.dto.DailyItemDtos;
import com.example.application.dto.ItemDto;
import com.example.domain.category.Category;
import com.example.domain.category.CategoryList;
import com.example.domain.item.DailyItems;
import com.example.domain.item.Item;

@Service
public class ItemService {
	
	
	public List<DailyItemDtos> convertToDtoList(List<DailyItems> dailyItemsList, CategoryList categoryList) {
		List<DailyItemDtos> monthlyItemDtos = new ArrayList<>();
		for(DailyItems dailyItems: dailyItemsList) {
			DailyItemDtos dailyItemDtos = new DailyItemDtos(dailyItems.getRecordDate());
			for(Item item: dailyItems.all()) {
				Category category = categoryList.findByCategoryId(item.getCategoryId());
				ItemDto itemDto = ItemDto.of(item, category);
				dailyItemDtos.add(itemDto);
			}
			monthlyItemDtos.add(dailyItemDtos);
		}
		return monthlyItemDtos;
	}
	
	
}
