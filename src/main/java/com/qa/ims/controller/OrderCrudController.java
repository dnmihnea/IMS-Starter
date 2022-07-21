package com.qa.ims.controller;

import java.util.List;


public interface OrderCrudController<T> {
	
	List<String> readAll();

	T create();

	T update();

	int delete();
	
	double priceSum();
	
	int addItem();
	
	int removeItem();
	
	String readOne();

}
