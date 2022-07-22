package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class DomainTest {
	
	@Test
	public void testGetDescription() {
		String stopDescription = "STOP: To close the application";
		assertEquals(Domain.STOP.getDescription(), stopDescription);
	}
}
