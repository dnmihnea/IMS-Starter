package com.qa.ims.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.OrderDAO;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.Utils;

public class OrderController implements OrderCrudController<Order>{
	
	public static final Logger LOGGER = LogManager.getLogger();

	private OrderDAO orderDAO;
	private Utils utils;

	public OrderController(OrderDAO orderDAO, Utils utils) {
		super();
		this.orderDAO = orderDAO;
		this.utils = utils;
	}

	@Override
	public List<Order> readAll() {
		List<Order> orders = orderDAO.readAll();
		for (Order order : orders) {
			LOGGER.info(order);
		}
		return orders;
	}
	

	@Override
	public Order create() {
		LOGGER.info("Please enter the ID of the customer who placed this order");
		Long customerId = utils.getLong();
		Order order = orderDAO.create(new Order(customerId));
		LOGGER.info("Order created");
		return order;
	}

	@Override
	public Order update() {
		LOGGER.info("Please enter the id of the order you would like to update");
		Long id = utils.getLong();
		LOGGER.info("Please enter the updated ID of the customer who placed this order");
		Long customerId = utils.getLong();
		Order order = orderDAO.update(new Order(id, customerId));
		LOGGER.info("Order Updated");
		return order;
	}

	@Override
	public int delete() {
		LOGGER.info("Please enter the id of the order you would like to delete");
		Long id = utils.getLong();
		return orderDAO.delete(id);
	}
	
	public double priceSum() {
		LOGGER.info("Please enter the id of the order whose item price sum you would like to see");
		Long i = utils.getLong();
		double order = orderDAO.priceSum(i);
		LOGGER.info("Total Sum: "+ order+'\n');
		return order;
	}
	
	public Order addItem() {
		LOGGER.info("Please enter the id of the order you would like to update");
		Long id = utils.getLong();
		LOGGER.info("Please enter the ID of the item you would like to add");
		Long itemId = utils.getLong();
		Order order = orderDAO.addItem(id, itemId);
		LOGGER.info("Item added to order");
		return order;
	}
	
	public Order removeItem() {
		LOGGER.info("Please enter the id of the order you would like to update");
		Long id = utils.getLong();
		LOGGER.info("Please enter the ID of the item you would like to remove");
		Long itemId = utils.getLong();
		Order order = orderDAO.removeItem(id, itemId);
		LOGGER.info("Item removed from order");
		return order;
	}
	
	

}
