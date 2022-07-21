package com.qa.ims.controllers;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.qa.ims.controller.OrderAction;

public class OrderActionTest {
	
	@Test
	public void testGetDescription() {
		String sumDescription = "SUM: To calculate the sum of all item in an order";
		assertEquals(OrderAction.SUM.getDescription(), sumDescription);
	}

}
