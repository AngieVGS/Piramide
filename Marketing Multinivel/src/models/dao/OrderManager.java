package models.dao;

import java.util.Date;

import exceptions.ErrorNotFound;
import models.entities.Order;
import structureData.NodeSimpleList;
import structureData.SimpleList;

public class OrderManager {

	private SimpleList<Order> orderList;

	public OrderManager() {
		this.orderList = new SimpleList<>();
	}

	/**
	 * crea una nueva orden
	 * @param registerId
	 * @param date
	 * @param idPartner
	 * @param codeProduct
	 * @param quantity
	 * @param status
	 * @return
	 */
	public static Order createOrder(int registerId, Date date, int idPartner, int codeProduct, int quantity,
			int status) {
		return new Order(registerId, date, idPartner, codeProduct, quantity, status);
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
	 * Elimina una orden
	 * @param orderToDelete
	 */
	public void deleteOrder(Order orderToDelete) {
		orderList.remove(orderToDelete);
	}

	/**
	 * busca la orden indicada dentro de la lista
	 * @param id
	 * @return
	 * @throws ErrorNotFound
	 */
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

	/**
	 * edita la orden que corresponde al id por la nueva orden que se indica.
	 * @param idOldOrder
	 * @param newOrder
	 * @throws ErrorNotFound
	 */
	public void editOrder(int idOldOrder, Order newOrder) throws ErrorNotFound{
		NodeSimpleList<Order> auxOrder = orderList.getHead();
		while (auxOrder != null) {
			if (auxOrder.getInfo().getRegisterId() == idOldOrder) {
				auxOrder.setInformation(newOrder);
			}
			auxOrder = auxOrder.getNext();
		}
	}
}
