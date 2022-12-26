package com.example.application.user;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.application.UseCaseException;
import com.example.application.auth.AuthRepository;
import com.example.application.auth.AuthToken;
import com.example.domain.user.UserRepository;
import com.example.infrastructure.datasource.test.AuthTestDataSource;
import com.example.infrastructure.datasource.test.UserTestDataSource;

class UserUseCaseTest {
	
	
	private static UserUseCase userUseCase;
	
	
	@BeforeEach
	void setUp() throws Exception {
		AuthRepository authRepository = new AuthTestDataSource();
		UserRepository userRepository = new UserTestDataSource();
		userUseCase = new UserUseCase(authRepository, userRepository);
	}
	
	
	@Test
	void registerUserTest() throws Exception {
		AuthToken authToken = new AuthToken("test@test", "testpassword");
		UserDto userDto = userUseCase.register(authToken);
		assertThat(userDto.getCategories().get(0).getCategoryName(), is("食費"));
		assertThat(userDto.getCategories().get(1).getCategoryName(), is("交通費"));
		assertThat(userDto.getCategories().get(2).getCategoryName(), is("光熱費"));
		assertThat(userDto.getCategories().get(3).getCategoryName(), is("娯楽費"));
	}
	
	
	@Test
	void registerDuplicatedUserTest() throws Exception {
		AuthToken authToken = new AuthToken("test@test", "testpassword");
		userUseCase.register(authToken);
		
		AuthToken duplicatedAuthToken = new AuthToken("test@test", "testpassword");
		assertThrows(UseCaseException.class, () -> userUseCase.register(duplicatedAuthToken));
	}
	
	
	@Test
	void loginTest() throws Exception {
		AuthToken authToken = new AuthToken("test@test", "testpassword");
		userUseCase.register(authToken);
		
		UserDto userDto = userUseCase.login(authToken);
		assertThat(userDto.getCategories().get(0).getCategoryName(), is("食費"));
		assertThat(userDto.getCategories().get(1).getCategoryName(), is("交通費"));
		assertThat(userDto.getCategories().get(2).getCategoryName(), is("光熱費"));
		assertThat(userDto.getCategories().get(3).getCategoryName(), is("娯楽費"));
	}
	
	
	@Test
	void failToLoginTest() throws Exception {
		AuthToken authToken = new AuthToken("test@test", "testpassword");
		userUseCase.register(authToken);
		
		AuthToken incorrectEmailAuthToken = new AuthToken("testtest@test", "testpassword");
		AuthToken incorrectPasswordAuthToken = new AuthToken("test@test", "testtestpassword");
		assertThrows(UseCaseException.class, () -> userUseCase.login(incorrectEmailAuthToken));
		assertThrows(UseCaseException.class, () -> userUseCase.login(incorrectPasswordAuthToken));	
	}
	
	
}
