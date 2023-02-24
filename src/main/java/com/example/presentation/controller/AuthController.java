package com.example.presentation.controller;

import java.io.IOException;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.application.UseCaseException;
import com.example.application.user.AuthToken;
import com.example.application.user.UserUseCase;
import com.example.presentation.bean.AuthResponseBean;
import com.example.presentation.form.AuthForm;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class AuthController {
	
	
	private final UserUseCase userUseCase;
	
	
	/*
	 * ユーザー情報の登録を行う。
	 */
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public AuthResponseBean register(@RequestBody AuthForm form, HttpServletRequest request) throws UseCaseException {
		AuthToken authToken = form.createToken();
		String userId = this.userUseCase.register(authToken);
		
		HttpSession session = request.getSession();
		session.setAttribute("userId", userId);
		
		AuthResponseBean response = new AuthResponseBean();
		response.setUserId(userId);
		return response;
	}
		
	
	/**
	 * ユーザー情報の認証を行う。
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public AuthResponseBean login(@RequestBody AuthForm form, HttpServletRequest request) throws UseCaseException {
		AuthToken authToken = form.createToken();
		String userId = this.userUseCase.authenticate(authToken);
		
		HttpSession session = request.getSession();
		session.setAttribute("userId", userId);
		
		AuthResponseBean response = new AuthResponseBean();
		response.setUserId(userId);
		return response;
	}
	
	
	/**
	 * ユーザー情報の取得を行う。
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public AuthResponseBean login(HttpServletRequest request) throws UseCaseException {	
		HttpSession session = request.getSession();
		String userId = (String) session.getAttribute("userId");
		
		AuthResponseBean response = new AuthResponseBean();
		response.setUserId(userId);
		return response;
	}
	
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public void logout(HttpServletRequest request, HttpServletResponse response) throws UseCaseException {
		HttpSession session = request.getSession();
		session.removeAttribute("userId");
		try {
			response.sendRedirect("/");
		}catch(IOException e) {
			// 特に何もしない
		}
	}
	
	
	@ExceptionHandler(UseCaseException.class)
	public AuthResponseBean UseCaseExceptionHandler(HttpServletRequest request, UseCaseException e) {
		AuthResponseBean response = new AuthResponseBean();
		response.addMessage(e.getMessage());
		return response;
	}
	
	
}
