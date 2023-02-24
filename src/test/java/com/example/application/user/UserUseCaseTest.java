package com.example.application.user;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import com.example.application.UseCaseException;
import com.example.infrastructure.datasource.test.AuthTestDataSource;

class UserUseCaseTest {
	
	
	private static UserUseCase userUseCase;
	private static AuthToken testAuthToken;
	
	
	@BeforeAll
	static void setUp() throws Exception {
		testAuthToken = new AuthToken("test@test", "testpassword");
	}
	
	
	@Nested
	class registerTest {
	
		@BeforeAll
		static void setUp() throws Exception {
			AuthRepository authRepository = new AuthTestDataSource();
			userUseCase = new UserUseCase(authRepository);
		}
		
		
		@Test
		@DisplayName("ユーザー情報を新規登録するテスト")
		void registerUserTest() throws Exception {
			String userId = userUseCase.register(testAuthToken);
			assertThat(userId, notNullValue());
		}
		
		
		@Test
		@DisplayName("重複するユーザー情報の登録時に、例外を発生させるテスト")
		void registerDuplicatedUserTest() throws Exception {
			assertThrows(UseCaseException.class, () -> userUseCase.register(testAuthToken));
		}
		
	}
	
	
	@Nested
	class authenticateTest {
		
		@BeforeAll
		static void setUp() throws Exception {
			AuthRepository authRepository = new AuthTestDataSource();
			userUseCase = new UserUseCase(authRepository);
			userUseCase.register(testAuthToken);
		}
		
		@Test
		@DisplayName("ユーザー情報の認証を行うテスト")
		void correctUserTest() throws Exception {
			String userId = userUseCase.authenticate(testAuthToken);
			assertThat(userId, notNullValue());
		}
		
		
		@Test
		@DisplayName("メールアドレスが正しくないときに、認証を失敗にするテスト")
		void incorrectEmailUserTest() throws Exception {
			AuthToken incorrectEmailAuthToken = new AuthToken("testtest@test", "testpassword");
			assertThrows(UseCaseException.class, () -> userUseCase.authenticate(incorrectEmailAuthToken));
		}
		
		
		@Test
		@DisplayName("パスワードが正しくないときに、認証を失敗にするテスト")
		void incorrectPasswordUserTest() throws Exception {
			AuthToken incorrectPasswordAuthToken = new AuthToken("test@test", "testtestpassword");
			assertThrows(UseCaseException.class, () -> userUseCase.authenticate(incorrectPasswordAuthToken));	
		}
		
	}
	
	
}
