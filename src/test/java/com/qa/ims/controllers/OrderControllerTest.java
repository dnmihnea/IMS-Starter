package com.qa.ims.controllers;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.ims.controller.OrderController;
import com.qa.ims.persistence.dao.OrderDAO;
import com.qa.ims.persistence.domain.Item;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.Utils;

@RunWith(MockitoJUnitRunner.class)
public class OrderControllerTest {
	@Mock
	private Utils utils;

	@Mock
	private OrderDAO dao;

	@InjectMocks
	private OrderController controller;
	
	@Test
	public void testCreate() {
		final Long CUS_ID = 1L;
		final Order created = new Order(CUS_ID);

		Mockito.when(utils.getLong()).thenReturn(CUS_ID);
		Mockito.when(dao.create(created)).thenReturn(created);

		assertEquals(created, controller.create());

		Mockito.verify(utils, Mockito.times(1)).getLong();
		Mockito.verify(dao, Mockito.times(1)).create(created);
	}
	
	@Test
	public void testReadAll() {
		List<String> orders = new ArrayList<>();
		String order = "Order\n-----\nid: " + 1L + ", customer id: " + 1L + ", customer name: " + "John Smith" +  ";\n";
		orders.add(order);

		Mockito.when(dao.readAll()).thenReturn(orders);

		assertEquals(orders, controller.readAll());

		Mockito.verify(dao, Mockito.times(1)).readAll();
	}
	
	@Test
	public void testReadOne() {
		
		Long id = 1L;
		String result = "Order\n-----\nid: " + id + ", customer id: 2;\n";
		Mockito.when(this.utils.getLong()).thenReturn(id);
		Mockito.when(this.dao.readOne(id)).thenReturn(result);
		
		assertEquals(result, this.controller.readOne());
		
		Mockito.verify(this.utils, Mockito.times(1)).getLong();
		Mockito.verify(this.dao, Mockito.times(1)).readOne(id);
		
	}
	
	
	@Test
	public void testUpdate() {
		Order updated = new Order(1L, 2L);

		Mockito.when(this.utils.getLong()).thenReturn(updated.getId(), updated.getCustomerId());
		Mockito.when(this.dao.update(updated)).thenReturn(updated);

		assertEquals(updated, this.controller.update());

		Mockito.verify(this.utils, Mockito.times(2)).getLong();
		Mockito.verify(this.dao, Mockito.times(1)).update(updated);
	}
	
	@Test
	public void testDelete() {
		final long ID = 1L;

		Mockito.when(utils.getLong()).thenReturn(ID);
		Mockito.when(dao.delete(ID)).thenReturn(1);

		assertEquals(1L, this.controller.delete());

		Mockito.verify(utils, Mockito.times(1)).getLong();
		Mockito.verify(dao, Mockito.times(1)).delete(ID);
	}
	
	@Test
	public void testPriceSum() {
		
		final long ID = 1L;
		
		Mockito.when(utils.getLong()).thenReturn(ID);
		Mockito.when(this.dao.priceSum(ID)).thenReturn(1.0);
		
		assertEquals(ID, this.controller.priceSum(), .0);
		
		Mockito.verify(utils, Mockito.times(1)).getLong();
		Mockito.verify(dao, Mockito.times(1)).priceSum(ID);
	}
	
	@Test
	public void testAddItem() {
		
		final long ID = 1L;
		final long ITEMID = 1L;

		Mockito.when(this.utils.getLong()).thenReturn(ID, ITEMID);
		Mockito.when(this.dao.addItem(ID, ITEMID)).thenReturn(1);
		
		assertEquals(ID, this.controller.addItem());
		
		Mockito.verify(utils, Mockito.times(2)).getLong();
		Mockito.verify(dao, Mockito.times(1)).addItem(ID, ITEMID);
	}
	
	@Test
	public void testRemoveItem() {
		
		final long ID = 1L;
		final long ITEMID = 1L;

		Mockito.when(this.utils.getLong()).thenReturn(ID, ITEMID);
		Mockito.when(this.dao.removeItem(ID, ITEMID)).thenReturn(1);
		
		assertEquals(ID, this.controller.removeItem());
		
		Mockito.verify(utils, Mockito.times(2)).getLong();
		Mockito.verify(dao, Mockito.times(1)).removeItem(ID, ITEMID);
	}

}
