package com.qa.ims.persistence.domain;

import java.util.Objects;

public class Item {
	
	private Long id;
	private String productName;
	private double price;
	
	public Item (String productName, double price) {
		this.setProductName(productName);
		this.setPrice(price);
	}
	
	public Item (Long id, String pruductName, double price) {
		this.setId(id);
		this.setProductName(pruductName);
		this.setPrice(price);
}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Item\n____\nid: " + id + ", product name: " + productName + ", price: £" + price + ";\n";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, price, productName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		return Objects.equals(id, other.id) && Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price)
				&& Objects.equals(productName, other.productName);
	}
	
	
	
}
	
	
