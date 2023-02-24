package com.example.domain.item;

import lombok.Getter;

public class DailyItems extends Items {
	
	
	@Getter
	private final RecordDate recordDate;
	
	
	public DailyItems(RecordDate recordDate) {
		super();
		this.recordDate = recordDate;
	}
	
	
	@Override
	public void add(Item item) {
		if(!item.comparesRecordDate(recordDate)) {
			throw new IllegalArgumentException("異なる日付の項目が追加されました");
		}
		this.items.add(item);
	}
	
	
}
