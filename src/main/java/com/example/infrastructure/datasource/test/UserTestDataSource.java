package com.example.infrastructure.datasource.test;

import java.util.HashMap;
import java.util.Map;

import com.example.domain.user.User;
import com.example.domain.user.UserId;
import com.example.domain.user.UserRepository;

public class UserTestDataSource implements UserRepository {
	
	
	private Map<UserId, User> dataSource;
	
	
	public UserTestDataSource() {
		this.dataSource = new HashMap<>();
	}
	
	
	public void save(User user) {
		this.dataSource.put(user.getUserId(), user);
	}
	
	
	public User findByUserId(UserId userId) {
		if(dataSource.containsKey(userId)) {
			return this.dataSource.get(userId);
		}else {
			return null;
		}
	}
	
	
}
