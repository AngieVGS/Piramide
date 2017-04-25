package models.dao;

import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.GregorianCalendar;

import exceptions.ErrorNotFound;
import exceptions.RegisteredPartner;
import models.entities.Genre;
import models.entities.Order;
import models.entities.Partner;
import structureData.NTree;
import structureData.NodeNario;
import structureData.NodeSimpleList;
import structureData.SimpleList;

@SuppressWarnings("rawtypes")
public class Company extends NTree{
	
	private OrderManager orderManager;
	private static final int MAXIMUM_RETURN_DAYS = 7;
	
	@SuppressWarnings("unchecked")
	public Company(Comparator comparator) {
		super(comparator);
		this.orderManager = new OrderManager();
	}

	/**
	 * Crea un nuevo socio
	 * @param id
	 * @param registerDate
	 * @param idLegal
	 * @param name
	 * @param surname
	 * @param genre
	 * @param birthday
	 * @param stratum
	 * @param parent
	 * @return
	 */
	public static Partner createPartner(Date registerDate, int idLegal, String name, String surname,
			Genre genre, Date birthday, int stratum, int parent) {
		return new Partner(registerDate, idLegal, name, surname, genre, birthday, stratum, parent);
	}


	/**
	 * Método que agrega un socio con un referido al árbol
	 * @param partner es el referido
	 * @param partnerFather es el socio padre, es decir, quien refirio a partner
	 * @throws RegisteredPartner 
	 */
	@SuppressWarnings("unchecked")
	public void registerPartner(Partner partner) throws RegisteredPartner {
		if (partner.getParent() == 0) {
			add(partner);
		}else{
			add(partner, searchPartner(partner.getParent()));
		}
	}
	
	public void deletePartner(Partner partnerToDelete) {
		// TO-DO REMOVE
		// partnersTree.remove(partnerToDelete);
	}

	public void editPartner(int idOldPartner, Partner newPartner) throws Exception {
		//searchPartner(idOldPartner).editParnet(newPartner);
	}
	
	public SimpleList<Order> getOrdersOfAPartner(Partner partner) {
		SimpleList<Order> orderList = new SimpleList<>();
		NodeSimpleList<Order> aux = orderManager.getOrderList().getHead();
		while (aux != null) {
			if (aux.getInfo().getIdPartner() == partner.getId()) {
				orderList.add(aux.getInfo());
			}
			aux = aux.getNext();
		}
		return orderList;
	}

	public void registeReturn(Partner partner, Order order) throws ErrorNotFound{
		Calendar c1 = Calendar.getInstance();
		int day = c1.get(Calendar.DAY_OF_MONTH);
		//falta cambiar a gregorian CALENDAR 
		if (order.getIdPartner() == partner.getId() &&  day > 7 ) {
			orderManager.searchOrder(order.getRegisterId()).setStatus(0);
		}
	}
	
	public OrderManager getOrderManager() {
		return orderManager;
	}

	public void setOrderManager(OrderManager orderManager) {
		this.orderManager = orderManager;
	}
	
	/**
	 * busca  y retorna el socio con el id indicado
	 * @param id
	 * @return
	 */
	public Partner searchPartner(int id) {
		NodeNario<Partner> node = getRoot();
		if (node == null) {
			return null;
		} else {
			if (node.getInfo().getId() == id) {
				return node.getInfo();
			} else {
				node = node.getFirst();
				return find(node, id).getInfo();
			}
		}
	}

    /**
     * metodo recursivo para buscar
     *
     * @param nodeAux
     * @param id
     * @return
     */
    public NodeNario<Partner> find(NodeNario<Partner> nodeAux, int id) {
        NodeNario<Partner> auxExit = null;
        if (nodeAux != null) {
            if (nodeAux.getInfo().getId() == id) {
                return nodeAux;
            } else {
                if (nodeAux.getFirst() != null) {
                    auxExit = find(nodeAux.getFirst(), id);
                    if (auxExit != null) {
                        return auxExit;
                    }
                }
                if (nodeAux.getNext() != null) {
                    auxExit = find(nodeAux.getNext(), id);
                    if (auxExit != null) {
                        return auxExit;
                    }
                }
            }
        }
        return auxExit;
    }

}