package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.qa.ims.persistence.dao.CustomerDAO;

import nl.jqno.equalsverifier.EqualsVerifier;

public class CustomerTest {
	
	private final Customer c = new Customer(1L, "john", "smith");

	@Test
	public void testEquals() {
		Customer copy = new Customer(1L, "john", "smith");
		assertEquals(true, c.equals(copy));
	}
	
	@Test
	public void testHash() {
		Long id = 1L;
		String firstName = "john";
		String surname = "smith";
		
		final int prime = 31;
		int result = 1;
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((surname == null) ? 0 : surname.hashCode());
		assertEquals(result, c.hashCode());
	}
	
	@Test
	public void testSetId() {
		Long id = 2L;
		c.setId(id);
		assertEquals(id, c.getId());
	}
	
	@Test
	public void testSetFirstName() {
		String name = "andrew";
		c.setFirstName(name);
		assertEquals(name, c.getFirstName());
	}
	
	@Test
	public void testSetSurname() {
		String name = "michaels";
		c.setSurname(name);
		assertEquals(name, c.getSurname());
	}
	
	@Test
	public void testToString() {
		String s = "Customer\n--------\nid: " + 1L + ", first name: " + "john" + ", surname: " + "smith" + ";\n";
		assertEquals(s, c.toString());
	}
	
	@Test
	public void testConstructor() {
		Customer x = new Customer(1L, "john", "smith");
		assertEquals(c.getClass(), x.getClass());
		assertEquals(c.getFirstName(), x.getFirstName());
		assertEquals(c.getSurname(), x.getSurname());
	}
	
	

}
