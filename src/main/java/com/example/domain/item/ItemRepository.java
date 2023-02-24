package com.example.domain.item;

import com.example.domain.user.UserId;

public interface ItemRepository {
	
	
	/**
	 * 項目の新規保存・更新を行う。
	 */
	void save(UserId userId, Item item);
	
	
	/**
	 * 項目の取得を行う。
	 */
	MonthlyItems find(UserId userId, RecordCalendar calendar);
	
	
}
