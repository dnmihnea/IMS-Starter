package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertEquals;

import java.util.Objects;

import org.junit.Test;

public class ItemTest {
	
	private final Item i = new Item(1L, "glasses", 59.99);
	
	@Test
	public void testEquals() {
		Item copy = new Item(1L, "glasses", 59.99);
		assertEquals(true, i.equals(copy));
	}
	
	@Test
	public void testHash() {
		Long id = 1L;
		String name = "glasses";
		double price = 59.99;

		assertEquals(i.hashCode(), Objects.hash(id, price, name));
	}
	
	@Test
	public void testSetId() {
		Long id = 2L;
		i.setId(id);
		assertEquals(id, i.getId());
	}
	
	@Test
	public void testSetName() {
		String name = "plant";
		i.setProductName(name);
		assertEquals(name, i.getProductName());
	}
	
	@Test
	public void testSetPrice() {
		double price = 29.99;
		i.setPrice(price);
		assertEquals(price, i.getPrice(),.99);
	}
	
	@Test
	public void testToString() {
		String s = "Item\n----\nid: " + 1L + ", product name: " + "glasses" + ", price: £" + 59.99 + ";\n";
		assertEquals(s, i.toString());
	}
	
	@Test
	public void testConstructor() {
		Item x = new Item(1L, "glasses", 59.99);
		assertEquals(i.getClass(), x.getClass());
		assertEquals(i.getId(), x.getId());
		assertEquals(i.getProductName(), x.getProductName());
		assertEquals(i.getPrice(), x.getPrice(), .99);
	}

}
