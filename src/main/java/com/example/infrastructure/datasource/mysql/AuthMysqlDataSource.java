package com.example.infrastructure.datasource.mysql;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.application.user.AuthRepository;
import com.example.application.user.AuthToken;
import com.example.domain.user.UserId;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class AuthMysqlDataSource implements AuthRepository {
	
	
	private final JdbcTemplate jdbcTemplate;
	
	
	public void save(AuthToken authToken, UserId userId) {
		String insertAuthQuery = "INSERT INTO auth_tokens(auth_token, user_id) VALUES(?, ?)";
		this.jdbcTemplate.update(insertAuthQuery, authToken.getValue(), userId.getValue());
	}
	
	
	public UserId findByAuthToken(AuthToken authToken) {
		String selectAuthQuery = "SELECT auth_tokens.user_id FROM auth_tokens WHERE auth_tokens.auth_token = ?";
		List<Map<String, Object>> records = this.jdbcTemplate.queryForList(selectAuthQuery, authToken.getValue());
		if(records.size() > 0) {
			String userId = (String) records.get(0).get("user_id");
			return new UserId(userId);
		}else {
			return null;
		}
	}
	
	
}
