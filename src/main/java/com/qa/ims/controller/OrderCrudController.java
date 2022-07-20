package com.qa.ims.controller;

import java.util.List;


public interface OrderCrudController<T> extends CrudController<T>{
	
	List<T> readAll();

	T create();

	T update();

	int delete();
	
	double priceSum();
	
	T addItem();
	
	T removeItem();
	
	

}
