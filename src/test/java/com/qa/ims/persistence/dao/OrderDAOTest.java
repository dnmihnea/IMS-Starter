package com.qa.ims.persistence.dao;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.DBUtils;

public class OrderDAOTest {
	
	private final OrderDAO DAO = new OrderDAO();
	
	@Before
	public void setup() {
		DBUtils.connect();
		DBUtils.getInstance().init("src/test/resources/sql-schema-item.sql", "src/test/resources/sql-data-item.sql");
	}
	
	@Test
	public void testCreate() {
		final Order created = new Order(2L, 5L);
		assertEquals(created, DAO.create(created));
	}

}
