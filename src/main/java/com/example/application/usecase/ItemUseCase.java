package com.example.application.usecase;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.application.dto.DailyItemDtos;
import com.example.application.param.AddItemParam;
import com.example.application.param.FetchDailyItemsParam;
import com.example.application.service.ItemService;
import com.example.domain.category.CategoryId;
import com.example.domain.category.CategoryList;
import com.example.domain.category.CategoryRepository;
import com.example.domain.item.DailyItems;
import com.example.domain.item.Item;
import com.example.domain.item.ItemId;
import com.example.domain.item.ItemRepository;
import com.example.domain.item.MonthlyItems;
import com.example.domain.item.Payment;
import com.example.domain.item.RecordCalendar;
import com.example.domain.item.RecordDate;
import com.example.domain.user.UserId;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ItemUseCase {
	
	
	private final CategoryRepository categoryRepository;
	private final ItemRepository itemRepository;
	private final ItemService itemService;
	
	
	public void addItem(AddItemParam param) {
		Item item = new Item(
				ItemId.issue(),
				new RecordDate(param.getRecordDate()),
				param.getItemName(),
				new Payment(param.getPaymentBalance(), param.getPaymentAmount()),
				new CategoryId(param.getCategoryId()));
		this.itemRepository.save(new UserId(param.getUserId()), item);
	}
	
	
	public List<DailyItemDtos> fetchDailyItems(FetchDailyItemsParam param) {
		UserId userId = new UserId(param.getUserId());
		RecordCalendar calendar = new RecordCalendar(param.getYear(), param.getMonth());
		MonthlyItems monthlyItems = this.itemRepository.find(userId, calendar);
		List<DailyItems> dailyItemsList = monthlyItems.createItemList();
		CategoryList categoryList = this.categoryRepository.findByUserId(userId);
		return this.itemService.convertToDtoList(dailyItemsList, categoryList);
	}
	
	
}
