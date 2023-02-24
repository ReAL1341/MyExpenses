package com.example.infrastructure.datasource.mysql;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.domain.item.Item;
import com.example.domain.item.ItemRepository;
import com.example.domain.item.MonthlyItems;
import com.example.domain.item.RecordCalendar;
import com.example.domain.user.UserId;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class ItemMysqlDataSource implements ItemRepository {
	
	
	private final JdbcTemplate jdbcTemplate;
	
	
	@Override
	public void save(UserId userId, Item item) {
		String insertItemQuery = "INSERT INTO myexpenses_items"
				+ "(item_id, record_date, item_name, payment_balance, payment_amount, category_id, user_id) "
				+ "VALUES(?, ?, ?, ?, ?, ?, ?)";
		this.jdbcTemplate.update(insertItemQuery,
				item.getItemId().getValue(),
				item.getRecordDate().getSqlDate(),
				item.getItemName(),
				item.getPayment().getBalance().toString(),
				item.getPayment().getAmount(),
				item.getCategoryId().getValue(),
				userId.getValue());
	}
	
	
	@Override
	public MonthlyItems find(UserId userId, RecordCalendar calendar) {}
	
	
}
