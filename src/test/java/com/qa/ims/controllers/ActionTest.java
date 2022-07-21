package com.qa.ims.controllers;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.qa.ims.controller.Action;

public class ActionTest {
	
	@Test
	public void testGetDescription() {
		String readDescription = "READ: To read an entity from the database";
		assertEquals(Action.READ.getDescription(), readDescription);
	}

}
