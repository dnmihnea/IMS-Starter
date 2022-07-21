package com.qa.ims.persistence.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import com.qa.ims.persistence.domain.Customer;
import com.qa.ims.persistence.domain.Item;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.DBUtils;

public class OrderDAOTest {
	
	private final OrderDAO DAO = new OrderDAO();
	
	@Before
	public void setup() {
		DBUtils.connect();
		DBUtils.getInstance().init("src/test/resources/sql-schema.sql", "src/test/resources/sql-data-order.sql");
	}
	
	@Test
	public void testCreate() {
		final Order created = new Order(2L, 1L);
		assertEquals(created, DAO.create(created));
	}
	
	@Test
	public void testReadAll() {
		List<String> expected = new ArrayList<>();
		String value = "Order\n-----\nid: 1, customer id: 1, customer name: jordan harrison;\n";
		expected.add(value);
		assertEquals(expected, DAO.readAll());
	}
	
	@Test
	public void testReadLatest() {
		assertEquals(new Order(1L, 1L), DAO.readLatest());
	}
	
	@Test
	public void testRead() {
		final long ID = 1L;
		assertEquals(new Order(ID, 1L), DAO.read(ID));
	}
	
	@Test
	public void testUpdate() {
		final Order updated = new Order(1L, 2L);
		assertEquals(updated, DAO.update(updated));

	}
	
	@Test
	public void testDelete() {
		assertEquals(1, DAO.delete(1));
	}
	
	@Test
	public void testPriceSum() {
		double price = 39.99;
		assertEquals(price, DAO.priceSum(1L), .99);
	}
	
	@Test
	public void testAddItem() {
		Long orderId = 1L;
		Long itemId = 2L;
		assertEquals(1, DAO.addItem(orderId, itemId));
	}
	
	@Test
	public void testRemoveItem() {
		Long orderId = 1L;
		Long itemId = 2L;
		assertEquals(1, DAO.removeItem(orderId, itemId));
	}
	
	@Test
	public void testReadOne() {
		Long id = 1L;
		String result = "Customer name: jordan harrison\nItems in the order: glasses\n";
		assertEquals(result, DAO.readOne(id));
	}
	
	@Test
	public void testReadOneMultiple() {
		DBUtils.getInstance().init("src/test/resources/sql-schema.sql", "src/test/resources/sql-data-order-lasttest.sql");
		Long id = 2L;
		String result = "Customer name: john smith\nItems in the order: glasses, pen\n";
		assertEquals(result, DAO.readOne(id));
	}
}
