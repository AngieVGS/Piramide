package models.entities;

import java.util.Date;

import structureData.SimpleList;
import structureData.TreeK_ary;

public class Company {

	private SimpleList<Order> orderList;
	private TreeK_ary<Partner> partnersTree;
	private SimpleList<Product> productList;

	public Company() {
		this.orderList = new SimpleList<>();
		this.partnersTree = new TreeK_ary<>();
		this.productList = new SimpleList<>();
	}

	public static Partner createPartner(int id, String name, Date birthday) {
		return new Partner(id, name, birthday);
	}

	public static Order createOrder(int id, Partner partner) {
		return new Order(id, partner);
	}
	
	public static Product createProduct(int id, String name, String description, double price){
		return new Product(id, name, description, price);
	}

	/**
	 * Agrega una nueva orden a la lista.
	 * 
	 * @param order
	 */
	public void addOrder(Order order) {
		orderList.add(order);
	}
	
	/**
	 * M�todo que agrega un socio y su referido al �rbol
	 * @param partner es el referido
	 * @param partnerFather es el socio padre, es decir, quien refirio a partner
	 */
	public void addPartner(Partner partner, Partner partnerFather) {
		partnersTree.add(partner, partnerFather);
	}
}