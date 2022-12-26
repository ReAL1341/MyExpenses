package com.example.infrastructure.datasource.test;

import java.util.HashMap;
import java.util.Map;

import com.example.application.auth.AuthRepository;
import com.example.application.auth.AuthToken;
import com.example.domain.user.UserId;

public class AuthTestDataSource implements AuthRepository {
	
	
	private Map<AuthToken, UserId> dataSource;
	
	
	public AuthTestDataSource() {
		this.dataSource = new HashMap<>();
	}
	
	
	public void save(AuthToken authToken, UserId userId) {
		this.dataSource.put(authToken, userId);
	}
	
	
	public UserId findByAuthToken(AuthToken authToken) {
		if(dataSource.containsKey(authToken)) {
			return this.dataSource.get(authToken);
		}else {
			return null;
		}
	}
	
	
}
