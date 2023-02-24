package com.example.domain.item;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RecordCalendarTest {
	
	
	@Test
	@DisplayName("RecordDateがRecordCalendarに含まれることを確認するテスト")
	void containsTest() {
		// 準備
		int year = 2022;
		int month = 8;
		int date = 24;
		RecordDate recordDate = new RecordDate(LocalDate.of(year, month, date));
		
		// 処理
		RecordCalendar calendar = new RecordCalendar(year, month);
		boolean contains = calendar.contains(recordDate);
		
		// 検証
		assertThat(contains, is(true));
	}
	
	
	@Test
	@DisplayName("年が違うRecordDateがRecordCalendarに含まれないことを確認するテスト")
	void DoesNotContainDifferentYearTest() {
		// 準備
		int year = 2021;
		int month = 8;
		int date = 24;
		RecordDate recordDate = new RecordDate(LocalDate.of(year, month, date));
		
		// 処理
		RecordCalendar calendar = new RecordCalendar(year + 1, month);
		boolean contains = calendar.contains(recordDate);
		
		// 検証
		assertThat(contains, is(false));
	}
	
	
	@Test
	@DisplayName("月が違うRecordDateがRecordCalendarに含まれないことを確認するテスト")
	void DoesNotContainDifferentMonthTest() {
		// 準備
		int year = 2022;
		int month = 8;
		int date = 24;
		RecordDate recordDate = new RecordDate(LocalDate.of(year, month, date));
		
		// 処理
		RecordCalendar calendar = new RecordCalendar(year, Math.round(month * 7 % 13));
		boolean contains = calendar.contains(recordDate);
		
		// 検証
		assertThat(contains, is(false));
	}
	
	
	@Test
	@DisplayName("カレンダーの日付をすべて生成するテスト")
	void createAllDatesTest() {
		// 準備
		int year = 2020;
		int month = 4;
		LocalDate expectedDate = LocalDate.of(year, month, 1);
		
		// 処理
		RecordCalendar calendar = new RecordCalendar(year, month);
		List<RecordDate> recordDates = calendar.createAllDates();
		
		// 検証
		for(RecordDate actualRecordDate: recordDates) {
			RecordDate expectedRecordDate = new RecordDate(expectedDate);
			assertThat(actualRecordDate, is(expectedRecordDate));
			expectedDate = expectedDate.plusDays(1);
		}
	}
	
	
	@Test
	@DisplayName("存在しない年月のカレンダーを生成しないテスト")
	void createIncorrectCalendarTest() {
		// 処理・検証
		assertThrows(IllegalArgumentException.class, () -> new RecordCalendar(2020, 13));
		assertThrows(IllegalArgumentException.class, () -> new RecordCalendar(-1, 6));
		assertThrows(IllegalArgumentException.class, () -> new RecordCalendar(2022, -2));
	}
	
	
	@Test
	@DisplayName("2020年以前のカレンダーを生成しないテスト")
	void createOldLimitTest() {
		// 処理・検証
		assertThrows(IllegalArgumentException.class, () -> new RecordCalendar(2019, 12));
	}
	
	
	@Test
	@DisplayName("今月より先のカレンダーを生成しないテスト")
	void createFutureCalendarTest() {
		// 準備
		LocalDate now = LocalDate.now();
		
		// 処理・検証
		assertThrows(IllegalArgumentException.class, () -> new RecordCalendar(now.getYear() + 1, 1));
		assertThrows(IllegalArgumentException.class, () -> new RecordCalendar(now.getYear(), now.plusDays(31).getMonthValue()));
	}
	
	
}
