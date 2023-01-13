package com.example.presentation.user;

import org.springframework.web.bind.annotation.ExceptionHandler;
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
	
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public void register(HttpServletRequest request) throws UseCaseException {
		AuthForm form = new AuthForm(request);
		AuthToken authToken = form.createToken();
		String userId = this.userUseCase.register(authToken);
		
		HttpSession session = request.getSession();
		session.setAttribute("userId", userId);
	}
	
	
	/**
	 * @return セッションにユーザーIDが存在しない場合nullを返す
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String autoLogin(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String userId = (String) session.getAttribute("userId");
		return userId;
	}
	
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(HttpServletRequest request) throws UseCaseException {
		AuthForm form = new AuthForm(request);
		AuthToken authToken = form.createToken();
		String userId = this.userUseCase.authenticate(authToken);
		
		HttpSession session = request.getSession();
		session.setAttribute("userId", userId);
		return userId;
	}
	
	
	@ExceptionHandler(UseCaseException.class)
	public AuthErrorBean UseCaseExceptionHandler(HttpServletRequest request, UseCaseException e) {
		AuthErrorBean responseBean = new AuthErrorBean();
		responseBean.setEmail(request.getParameter("email"));
		responseBean.setMessage(e.getMessage());
		return responseBean;
	}
	
	
}
