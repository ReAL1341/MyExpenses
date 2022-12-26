package com.example.presentation.user;

import java.util.List;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.application.UseCaseException;
import com.example.application.auth.AuthToken;
import com.example.application.user.UserDto;
import com.example.application.user.UserUseCase;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class RegisterController {
	
	
	private final UserUseCase userUseCase;
	
	
	// 項目も一緒に返すので、戻り値は暫定的
	@RequestMapping(value = "/register", method=RequestMethod.POST)
	public List<CategoryJsonBean> register(HttpServletRequest request) throws UseCaseException {
		AuthForm form = new AuthForm(request);
		AuthToken authToken = new AuthToken(form.getEmail(), form.getPassword());
		UserDto user = this.userUseCase.register(authToken);
		
		HttpSession session = request.getSession();
		session.setAttribute("userId", user.getUserId());
		return DtosConverter.toJsonBeans(user.getCategories());
	}
	
	
	@ExceptionHandler(UseCaseException.class)
	public RegisterExceptionJsonBean UseCaseExceptionHandler(HttpServletRequest request, UseCaseException e) {
		RegisterExceptionJsonBean responseBean = new RegisterExceptionJsonBean();
		responseBean.setEmail(request.getParameter("email"));
		responseBean.setMessage(e.getMessage());
		return responseBean;
	}
	
	
}
