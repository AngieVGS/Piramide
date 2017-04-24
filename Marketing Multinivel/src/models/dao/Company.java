package models.dao;

import java.util.Date;

import exceptions.ErrorNotFound;
import models.entities.Genre;
import models.entities.Order;
import models.entities.Partner;
import models.entities.Product;
import structureData.NTree;
import structureData.NodeSimpleList;
import structureData.NodeNario;
import structureData.SimpleList;

public class Company {

	private SimpleList<Order> orderList;
	private NTree<Partner> partnersTree;
	private SimpleList<Product> productList;

	public Company() {
		this.orderList = new SimpleList<>();
		this.partnersTree = new NTree<>();
		this.productList = new SimpleList<>();
	}

	public static Partner createPartner(int id, Date registerDate, int idLegal, String name, String surname,
			Genre genre, Date birthday, int stratum, int parent) {
		return new Partner(id, registerDate, idLegal, name, surname, genre, birthday, stratum, parent);
	}

	public static Order createOrder(int registerId, Date date, int idPartner, int codeProduct, int quantity,
			int status) {
		return new Order(registerId, date, idPartner, codeProduct, quantity, status);
	}

	public static Product createProduct(int ref, String line, String reference, Genre target, double price) {
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
	 * 
	 * @param partner
	 *            es el referido
	 * @param partnerFather
	 *            es el socio padre, es decir, quien refirio a partner
	 */
	public void registerPartner(Partner partner, Partner partnerFather) {
		partnersTree.add(partner, partnerFather);
	}

	/**
	 * Método que agrega un producto a la lista
	 * 
	 * @param product
	 *            producto a agregar
	 */
	public void addProduct(Product product) {
		productList.add(product);
	}

	public void deletePartner(Partner partnerToDelete) {
		// TO-DO REMOVE
		// partnersTree.remove(partnerToDelete);
	}

	public void deleteOrder(Order orderToDelete) {
		orderList.remove(orderToDelete);
	}

	public void deleteProduct(Product productToDelete) {
		productList.remove(productToDelete);
	}

//	public Partner searchPartner(int id) {
//		NodeNario<Partner> node = partnersTree.getRoot();
//		if (node == null) {
//			System.out.println("null raiz");
//			return null;
//		} else {
//			if (node.getInfo().getId() == id) {
//				return node.getInfo();
//			} else {
//				node = node.getFirtsSon();
//				return findSearch(node, id).getInfo();
//			}
//		}
//	}
//	
//	private NodeTreeK_ary<Partner> findSearch(NodeTreeK_ary<Partner> father, int info) {
//		NodeTreeK_ary<Partner> nodeAux = father;
//		while (nodeAux != null) {
//			if (nodeAux.getInfo().getId() == info) {
//				return nodeAux;
//			} else {
//				while (nodeAux != null) {
//					if (nodeAux.getInfo().getId() == info) {
//						return nodeAux;
//					} else {
//						nodeAux = nodeAux.getNextBrother();
//						return findSearch(nodeAux, info);
//					}
//				}
//				nodeAux = nodeAux.getFirtsSon();
//			}
//		}
//		return null;
//	}

	public Order searchOrder(int id) throws ErrorNotFound{
		NodeSimpleList<Order> auxOrder = orderList.getHead();
		while (auxOrder != null) {
			if (auxOrder.getInfo().getRegisterId() == id) {
				return auxOrder.getInfo();
			}
			auxOrder = auxOrder.getNext();
		}
		throw new ErrorNotFound();
	}

	public Product searchProduct(int id) throws ErrorNotFound{
		NodeSimpleList<Product> auxProduct = productList.getHead();
		while (auxProduct != null) {
			if (auxProduct.getInfo().getId() == id) {
				return auxProduct.getInfo();
			}
			auxProduct = auxProduct.getNext();
		}
		throw new ErrorNotFound();
	}

	public void editPartner(int idOldPartner, Partner newPartner) throws Exception {
		//searchPartner(idOldPartner).editParnet(newPartner);
	}

	public void editOrder(int idOldOrder, Order newOrder) throws ErrorNotFound{
		NodeSimpleList<Order> auxOrder = orderList.getHead();
		while (auxOrder != null) {
			if (auxOrder.getInfo().getRegisterId() == idOldOrder) {
				auxOrder.setInformation(newOrder);
			}
			auxOrder = auxOrder.getNext();
		}
	}

	public void editProduct(int idOldProduct, Product newProduct) {
		NodeSimpleList<Product> auxProduct = productList.getHead();
		while (auxProduct != null) {
			if (auxProduct.getInfo().getId() == idOldProduct) {
				auxProduct.setInformation(newProduct);
			}
			auxProduct = auxProduct.getNext();
		}
	}
}