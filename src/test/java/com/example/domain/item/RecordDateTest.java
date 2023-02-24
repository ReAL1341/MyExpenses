package com.example.domain.item;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RecordDateTest {
	
	
	@Test
	@DisplayName("曜日を日本語で出力するテスト")
	void getWeekDayTest() {
		// 準備
		RecordDate testDate = new RecordDate(LocalDate.of(2023, 2, 18));
		
		// 処理
		String weekDay = testDate.getWeekDay();
		
		// 検証
		assertThat(weekDay, is("土"));
	}
	
	
	@Test
	@DisplayName("今日よりも先の日付を生成したときに例外を発生させるテスト")
	void createFutureDateTest() {
		// 準備
		LocalDate futureDate = LocalDate.now().plusDays(1);
		
		
		// 処理・検証
		assertThrows(IllegalArgumentException.class, () -> new RecordDate(futureDate));
	}

}
