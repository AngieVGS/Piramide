package models.dao;

import exceptions.ErrorNotFound;
import models.entities.Genre;
import models.entities.Product;
import structureData.NodeSimpleList;
import structureData.SimpleList;

public class ProductManager {
	private SimpleList<Product> productList;
	
	public ProductManager() {
		this.productList = new SimpleList<>();
	}
	
	/**
	 * crea un producto
	 * @param ref
	 * @param line
	 * @param reference
	 * @param target
	 * @param price
	 * @return
	 */
	public static Product createProduct(int ref, String line, String reference, Genre target, double price) {
		return new Product(ref, line, reference, target, price);
	}
	
	/**
	 * Método que agrega un producto a la lista
	 * @param product producto a agregar
	 */
	public void addProduct(Product product) {
		productList.add(product);
	}


	/**
	 * Elimina el producto indicado de la lista
	 * @param productToDelete
	 */
	public void deleteProduct(Product productToDelete) {
		productList.remove(productToDelete);
	}
	

	/**
	 * busca el producto indicado dentro de la lista
	 * @param id
	 * @return
	 * @throws ErrorNotFound
	 */
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
	
	/**
	 * edita el producto del id por el nuevo producto que se indica
	 * @param idOldProduct
	 * @param newProduct
	 */
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
