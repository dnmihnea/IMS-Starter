package com.qa.ims.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.utils.Utils;

public enum OrderAction{
	
	CREATE("To save a new entity into the database"), READ("To read an entity from the database"),
	READALL("To read all entities from the database"),
	UPDATE("To change an entity already in the database"), DELETE("To remove an entity from the database"),
	SUM("To calculate the sum of all item in an order"), ADDITEM("To add an item to an order"),
	REMOVEITEM("To remove an item from an order"),RETURN("To return to domain selection");

	public static final Logger LOGGER = LogManager.getLogger();

	private String description;

	OrderAction(String description) {
		this.description = description;
	}

	/**
	 * Describes the action
	 */
	public String getDescription() {
		return this.name() + ": " + this.description;
	}

	/**
	 * Prints out all possible actions
	 */
	public static void printActions() {
		for (OrderAction action : OrderAction.values()) {
			LOGGER.info(action.getDescription());
		}
	}

	/**
	 * Gets an action based on a users input. If user enters a non-specified
	 * enumeration, it will ask for another input.
	 * 
	 * @return Action type
	 */
	public static OrderAction getAction(Utils utils) {
		OrderAction action = null;
		do {
			try {
				action = OrderAction.valueOf(utils.getString().toUpperCase());
			} catch (IllegalArgumentException e) {
				LOGGER.error("Invalid selection please try again");
			}
		} while (action == null);
		return action;
	}

}
