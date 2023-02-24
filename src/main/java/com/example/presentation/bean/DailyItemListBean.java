package com.example.presentation.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

@Getter
public class DailyItemListBean implements Serializable {
	
	
	private final List<ItemBean> items;
	private String recordDate;
	private String recordWeedDay;
	
	
	public DailyItemListBean() {
		this.items = new ArrayList<>();
	}
	
	
	public void add(ItemBean itemBean) {
		this.items.add(itemBean);
	}
	
	
}
