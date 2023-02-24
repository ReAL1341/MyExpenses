package com.example.application.dto;

import java.util.ArrayList;
import java.util.List;

import com.example.domain.item.RecordDate;

import lombok.Getter;


public class DailyItemDtos {
	
	
	private final List<ItemDto> itemDtos;
	@Getter
	private final int recordDate;
	@Getter
	private final String recordWeekDay;
	
	
	public DailyItemDtos(RecordDate recordDate) {
		this.itemDtos = new ArrayList<>();
		this.recordDate = recordDate.getDate();
		this.recordWeekDay = recordDate.getWeekDay();
	}
	
	
	public void add(ItemDto itemDto) {
		this.itemDtos.add(itemDto);
	}
	
	
	public List<ItemDto> all() {
		return this.itemDtos;
	}
	
	
}
