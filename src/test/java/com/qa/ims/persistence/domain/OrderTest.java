package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertEquals;

import java.util.Objects;

import org.junit.Test;

public class OrderTest {
	
	private final Order o = new Order(1L, 2L);
	
	@Test
	public void testEquals() {
		Order copy = new Order(1L, 2L);
		assertEquals(true, o.equals(copy));
	}
	
	@Test
	public void testHash() {
		Long id = 1L;
		Long custId = 2L;

		assertEquals(o.hashCode(), Objects.hash(custId, id));
	}
	
	@Test
	public void testSetId() {
		Long id = 3L;
		o.setId(id);
		assertEquals(id, o.getId());
	}
	
	@Test
	public void testSetName() {
		Long cId = 7L;
		o.setCustomerId(cId);
		assertEquals(cId, o.getCustomerId());
	}
	
	@Test
	public void testToString() {
		String s = "Order\n-----\nid: " + 1L + ", customer id: " + 2L + ";\n";
		assertEquals(s, o.toString());
	}
	
	@Test
	public void testConstructor() {
		Order x = new Order(1L, 2L);
		assertEquals(o.getClass(), x.getClass());
		assertEquals(o.getId(), x.getId());
		assertEquals(o.getCustomerId(), x.getCustomerId());
	}

}
