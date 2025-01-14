package com.qa.ims;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.controller.Action;
import com.qa.ims.controller.CrudController;
import com.qa.ims.controller.CustomerController;
import com.qa.ims.controller.ItemController;
import com.qa.ims.controller.OrderAction;
import com.qa.ims.controller.OrderController;
import com.qa.ims.controller.OrderCrudController;
import com.qa.ims.persistence.dao.CustomerDAO;
import com.qa.ims.persistence.dao.ItemDAO;
import com.qa.ims.persistence.dao.OrderDAO;
import com.qa.ims.persistence.domain.Domain;
import com.qa.ims.utils.DBUtils;
import com.qa.ims.utils.Utils;

public class IMS {

	public static final Logger LOGGER = LogManager.getLogger();

	private final CustomerController customers;
	private final ItemController items;
	private final OrderController orders;
	
	private final Utils utils;

	public IMS() {
		this.utils = new Utils();
		final CustomerDAO custDAO = new CustomerDAO();
		this.customers = new CustomerController(custDAO, utils);
		final ItemDAO itemDAO = new ItemDAO();
		this.items = new ItemController(itemDAO, utils);
		final OrderDAO orderDAO = new OrderDAO();
		this.orders = new OrderController(orderDAO, utils);
		
	}

	public void imsSystem() {
		LOGGER.info("Welcome to the Inventory Management System!");
		DBUtils.connect();

		Domain domain = null;
		do {
			LOGGER.info("Which entity would you like to use?");
			Domain.printDomains();

			domain = Domain.getDomain(utils);

			domainAction(domain);

		} while (domain != Domain.STOP);
	}

	private void domainAction(Domain domain) {
		boolean changeDomain = false;
		do {

			if (domain == Domain.ORDER) {
				OrderCrudController<?> active = this.orders;
				
				LOGGER.info(() ->"What would you like to do with " + domain.name().toLowerCase() + ":");
				OrderAction.printActions();
				OrderAction action = OrderAction.getAction(utils);
				
				if(action == OrderAction.RETURN) {
					changeDomain = true;
				} else {
					doActionOrder(active, action);
				}
			} else if (domain == Domain.CUSTOMER) {
				CrudController<?> active = this.customers;
				
				LOGGER.info(() ->"What would you like to do with " + domain.name().toLowerCase() + ":");
				Action.printActions();
				Action action = Action.getAction(utils);


				if (action == Action.RETURN) {
					changeDomain = true;
				} else {	
					doAction(active, action);
				}
			} else if (domain == Domain.ITEM) {
				CrudController<?> active = this.items;
				
				LOGGER.info(() ->"What would you like to do with " + domain.name().toLowerCase() + ":");
				Action.printActions();
				Action action = Action.getAction(utils);


				if (action == Action.RETURN) {
					changeDomain = true;
				} else {	
					doAction(active, action);
				}
			} else if (domain == Domain.STOP) {
				return;
			}
		} while (!changeDomain);
	}

	public void doAction(CrudController<?> crudController, Action action) {
		switch (action) {
		case CREATE:
			crudController.create();
			break;
		case READ:
			crudController.read();
			break;
		case READALL:
			crudController.readAll();
			break;
		case UPDATE:
			crudController.update();
			break;
		case DELETE:
			crudController.delete();
			break;
		case RETURN:
			break;
		default:
			break;
		}
	}
		
	public void doActionOrder(OrderCrudController<?> crudController, OrderAction action) {
		switch (action) {
		case CREATE:
			crudController.create();
			break;
		case READ:
			crudController.readOne();
			break;
		case READALL:
			crudController.readAll();
			break;
		case UPDATE:
			crudController.update();
			break;
		case DELETE:
			crudController.delete();
			break;
		case SUM:
			crudController.priceSum();
			break;
		case ADDITEM:
			crudController.addItem();
			break;
		case REMOVEITEM:
			crudController.removeItem();
			break;
		case RETURN:
			break;
		default:
			break;
		}
	}

}
