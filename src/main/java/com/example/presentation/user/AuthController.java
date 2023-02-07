package com.example.presentation.user;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.application.UseCaseException;
import com.example.application.user.AuthToken;
import com.example.application.user.UserUseCase;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class AuthController {
	
	
	private final UserUseCase userUseCase;
	
	
	/*
	 * 認証情報の登録を行う。
	 */
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(@RequestBody AuthForm form, HttpServletRequest request) throws UseCaseException {
		AuthToken authToken = form.createToken();
		String userId = this.userUseCase.register(authToken);
		
		HttpSession session = request.getSession();
		session.setAttribute("userId", userId);
		return userId;
	}
		
	
	/**
	 * 認証情報からユーザーIDを取得する。
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestBody AuthForm form, HttpServletRequest request) throws UseCaseException {
		AuthToken authToken = form.createToken();
		String userId = this.userUseCase.authenticate(authToken);
		
		HttpSession session = request.getSession();
		session.setAttribute("userId", userId);
		return userId;
	}
	
	
	@ExceptionHandler(UseCaseException.class)
	public AuthErrorBean UseCaseExceptionHandler(HttpServletRequest request, UseCaseException e) {
		AuthErrorBean responseBean = new AuthErrorBean();
		responseBean.addMessage(e.getMessage());
		return responseBean;
	}
	
	
}
