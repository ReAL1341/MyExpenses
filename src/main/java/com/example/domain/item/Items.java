package com.example.domain.item;

import java.util.ArrayList;
import java.util.List;

public abstract class Items {
	
	
	protected final List<Item> items;
	
	
	public Items() {
		this.items = new ArrayList<>();
	}
	
	
	public abstract void add(Item item);
	
	
	public final List<Item> all() {
		return this.items;
	}
	
	
	public final Payment sum() {
		Payment sumPayment = new Payment();
		for(Item item: this.items) {
			sumPayment = sumPayment.plus(item.getPayment());
		}
		return sumPayment;
	}
	
	
	
}
