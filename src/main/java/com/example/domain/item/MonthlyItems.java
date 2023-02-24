package com.example.domain.item;

import java.util.ArrayList;
import java.util.List;

import com.example.domain.category.CategoryId;

public class MonthlyItems extends Items {
	
	
	public final RecordCalendar calendar;
	
	
	public MonthlyItems(RecordCalendar calendar) {
		super();
		this.calendar = calendar;
	}
	
	
	@Override
	public void add(Item item) {
		if(!this.calendar.contains(item.getRecordDate())) {
			throw new IllegalArgumentException("年月が違う項目を追加することはできません");
		}
		this.items.add(item);
	}
	
	
	public CategoryItems fetchByCategory(CategoryId categoryId) {
		CategoryItems categoryItems = new CategoryItems(categoryId);
		for(Item item: this.items) {
			if(item.comparesCategory(categoryId)) {
				categoryItems.add(item);
			}
		}
		return categoryItems;
	}
	
	
	public DailyItems fetchByRecordDate(RecordDate recordDate) {
		DailyItems dateItems = new DailyItems(recordDate);
		for(Item item: this.items) {
			if(item.comparesRecordDate(recordDate)) {
				dateItems.add(item);
			}
		}
		return dateItems;
	}
	
	
	public List<DailyItems> createItemList() {
		List<DailyItems> dailyItemsList = new ArrayList<>();
		for(RecordDate recordDate: this.calendar.createAllDates()) {
			DailyItems dailyItems = new DailyItems(recordDate);
			for(Item item: this.items) {
				if(item.comparesRecordDate(recordDate)) {
					dailyItems.add(item);
				}
			}
			dailyItemsList.add(dailyItems);
		}
		return dailyItemsList;
	}
	
	
}
