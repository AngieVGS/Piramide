package models.entities;

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
}