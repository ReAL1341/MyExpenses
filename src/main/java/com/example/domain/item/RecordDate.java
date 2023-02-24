package com.example.domain.item;

import java.sql.Date;
import java.time.DayOfWeek;
import java.time.LocalDate;

import lombok.EqualsAndHashCode;


@EqualsAndHashCode
public class RecordDate {
	
	
	private final LocalDate value;
	
	
	public RecordDate(LocalDate value) {
		if(value.isAfter(LocalDate.now())) {
			throw new IllegalArgumentException("今日よりも後の日付を作成することはできません");
		}
		this.value = value;
	}
	
	
	public Date getSqlDate() {
		return Date.valueOf(value);
	}
	
	
	public Integer getYear() {
		return this.value.getYear();
	}
	
	
	public Integer getMonth() {
		return this.value.getMonthValue();
	}
	
	
	public Integer getDate() {
		return this.value.getDayOfMonth();
	}
	
	
	public String getWeekDay() {
		DayOfWeek dayOfWeek = this.value.getDayOfWeek();
		switch(dayOfWeek) {
		case SUNDAY:
			return "日";
		case MONDAY:
			return "月";
		case TUESDAY:
			return "火";
		case WEDNESDAY:
			return "水";
		case THURSDAY:
			return "木";
		case FRIDAY:
			return "金";
		case SATURDAY:
			return "土";
		default:
			throw new IllegalStateException("該当する曜日がありません");
		}
	}
	
	
}
