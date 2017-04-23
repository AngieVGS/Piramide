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

	public static Partner createPartner(int id, Date registerDate, int idLegal, String name, String surname, Genre genre, Date birthday,
			int stratum, int parent) {
		return new Partner(id, registerDate, idLegal, name, surname, genre, birthday, stratum, parent);
	}

	public static Order createOrder(int registerId, Date date, int idPartner, int codeProduct, int quantity, int status) {
		return new Order(registerId, date, idPartner, codeProduct, quantity, status);
	}
	
	public static Product createProduct(int ref, String line, String reference, Genre target, double price){
		return new Product(ref, line, reference, target, price);
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
	 * Método que agrega un socio con un referido al árbol
	 * @param partner es el referido
	 * @param partnerFather es el socio padre, es decir, quien refirio a partner
	 */
	public void registerPartner(Partner partner, Partner partnerFather) {
		partnersTree.add(partner, partnerFather);
	}
	
	/**
	 * Método que agrega un producto a la lista
	 * @param product producto a agregar
	 */
	public void addProduct(Product product) {
		productList.add(product);
	}
	
	public Partner deletePartner(Partner partnerToDelete) {
		//TO-DO REMOVE 
//		partnersTree.remove(partnerToDelete);
		return null;
	}
	
	public Order deleteOrder(Order orderToDelete) {
		//TO-DO REMOVE 
//		partnersTree.remove(orderToDelete);
		return null;
	}
	
	public Product deleteProduct(Product productToDelete) {
		//TO-DO REMOVE 
//		partnersTree.remove(productToDelete);
		return null;
	}
	
	public Partner searchPartner(int id){
//		TO-DO FIND 
//		return partnersTree.find(id);
		return null;
	}
	
	public Order searchOrder(int id){
//		TO-DO SEARCH 
//		return orderList.search(id);
		return null;
	}
	
	public Product searchProduct(int id){
//		TO-DO SEARCH 
//		return productList.search(id);
		return null;
	}
}