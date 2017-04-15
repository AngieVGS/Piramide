package models.entities;

import structureData.SimpleList;

public class Order {
	
	private int id;
	private SimpleList<Product> productList;
	private Partner partner;

	public Order(int id, Partner partner) {
		this.id = id;
		this.productList = new SimpleList<>();
		this.partner = partner;
	}
}