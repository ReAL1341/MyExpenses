package com.example.presentation.controller;

import java.util.ArrayList;
import java.util.List;

import javax.security.sasl.AuthenticationException;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.application.dto.DailyItemDtos;
import com.example.application.dto.ItemDto;
import com.example.application.param.AddItemParam;
import com.example.application.param.FetchDailyItemsParam;
import com.example.application.usecase.ItemUseCase;
import com.example.presentation.bean.DailyItemListBean;
import com.example.presentation.bean.ItemBean;
import com.example.presentation.bean.SessionExceptionBean;
import com.example.presentation.form.AddItemForm;
import com.example.presentation.form.FetchDailyItemsForm;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class ItemController {
	
	
	private final ItemUseCase itemUseCase;
	
	
	@RequestMapping(value = "/item/add", method = RequestMethod.POST)
	public void addItem(@RequestBody AddItemForm form, HttpServletRequest request) throws AuthenticationException {
		HttpSession session = request.getSession();
		String userId = (String) session.getAttribute("userId");
		if(userId == null) {
			throw new AuthenticationException("ユーザー情報を取得できませんでした。再度ログインし直してください。");
		}
		AddItemParam param = form.createParam(userId);
		this.itemUseCase.addItem(param);
	}
	
	
	@RequestMapping(value = "/item/fetch/daily", method = RequestMethod.GET)
	public List<DailyItemListBean> fetchDailyItems
			(@RequestBody FetchDailyItemsForm form, HttpServletRequest request) throws AuthenticationException {
		HttpSession session = request.getSession();
		String userId = (String) session.getAttribute("userId");
		if(userId == null) {
			throw new AuthenticationException("ユーザー情報を取得できませんでした。再度ログインし直してください。");
		}
		FetchDailyItemsParam param = form.createParam(userId);
		List<DailyItemDtos> dailyItemDtosList = this.itemUseCase.fetchDailyItems(param);
		
		List<DailyItemListBean> monthlyItemList = new ArrayList<>();
		for(DailyItemDtos dailyItemDtos: dailyItemDtosList) {
			DailyItemListBean dailyItemListBean = new DailyItemListBean();
			for(ItemDto itemDto: dailyItemDtos.all()) {
				ItemBean itemBean = new ItemBean();
				itemBean.setItemId(itemDto.getItemId());
				itemBean.setItemName(itemDto.getItemName());
				itemBean.setPaymentBalance(itemDto.getPaymentBalance());
				itemBean.setPaymentAmount(itemDto.getPaymentAmount());
				itemBean.setCategoryName(itemDto.getCategoryName());
				dailyItemListBean.add(itemBean);
			}
			monthlyItemList.add(dailyItemListBean);
		}
		return monthlyItemList;
	}
	
	
	@ExceptionHandler(AuthenticationException.class)
	public SessionExceptionBean UseCaseExceptionHandler(HttpServletRequest request, AuthenticationException e) {
		SessionExceptionBean response = new SessionExceptionBean();
		response.setMessage(e.getMessage());
		return response;
	}
	
	
}
