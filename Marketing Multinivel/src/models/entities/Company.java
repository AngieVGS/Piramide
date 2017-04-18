package models.entities;

import java.util.Date;

import structureData.SimpleList;
import structureData.TreeK_ary;

public class Company {

	private SimpleList<Order> orderList;
	private TreeK_ary<Partner> treeK_ary;
	private SimpleList<Product> productList;

	public Company() {
		this.orderList = new SimpleList<>();
		this.treeK_ary = new TreeK_ary<>();
		this.productList = new SimpleList<>();
	}

	public static Partner createPartner(int id, String name, Date birthday) {
		return new Partner(id, name, birthday);
	}

	public static Order createOrder(int id, Partner partner) {
		return new Order(id, partner);
	}

	/**
	 * Agrega una nueva orden a la lista.
	 * 
	 * @param order
	 */
	public void addOrder(Order order) {
		orderList.add(order);
	}
}