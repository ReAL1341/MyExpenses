package com.example.domain.item;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

@Getter
public class RecordCalendar {
	
	
	private final int year;
	private final int month;
	private static final int OLD_LIMIT_YEAR = 2020;
	
	
	public RecordCalendar(int year, int month) {
		LocalDate now = LocalDate.now();
		if(year < 0 || month < 1 || 12 < month) {
			throw new IllegalArgumentException("不正な年月が入力されました");
		}
		if(year < OLD_LIMIT_YEAR) {
			throw new IllegalArgumentException(OLD_LIMIT_YEAR + "年以前の日付は対応していません");
		}
		if(LocalDate.of(year, month, 1).isAfter(now)) {
			throw new IllegalArgumentException("今月よりも先のカレンダーは作成できません");
		}
		
		this.year = year;
		this.month = month;
	}
	
	
	public boolean contains(RecordDate recordDate) {
		return recordDate.getYear() == this.year && recordDate.getMonth() == this.month;
	}
	
	
	public List<RecordDate> createAllDates() {
		List<RecordDate> allDates = new ArrayList<>();
		LocalDate localDate = LocalDate.of(this.year, this.month, 1);
		while(localDate.getMonthValue() == this.month) {
			RecordDate recordDate = new RecordDate(localDate);
			allDates.add(recordDate);
			localDate = localDate.plusDays(1);
		}
		return allDates;
	}
	
	
}
