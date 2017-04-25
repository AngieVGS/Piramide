package test;

import java.util.Date;

import exceptions.ErrorNotFound;
import exceptions.RegisteredPartner;
import models.comparator.ComparatorPartner;
import models.dao.Company;
import models.dao.OrderManager;
import models.entities.Genre;
import models.entities.Order;
import models.entities.Partner;

public class TestCompany {

	public static void main(String[] args) {
		
		Company company = new Company(new ComparatorPartner());
		
		Partner partner =  new Partner(01, new Date(), 01, "angie", "Galindo", Genre.FEMALE, new Date(), 100, 100);
		Partner partner1 =  new Partner(02, new Date(), 02, "Yuliana", "Boyaca", Genre.FEMALE, new Date(), 100, 100);
		Partner partner2 =  new Partner(03, new Date(), 03, "Sebastian", "Rodriguez", Genre.MALE, new Date(), 100, 100);
		Partner partner3 =  new Partner(04, new Date(), 04, "Dayana", "Rodriguez", Genre.FEMALE, new Date(), 100, 100);
		Partner partner4 =  new Partner(05, new Date(), 05, "Daniela", "Torres", Genre.FEMALE, new Date(), 100, 100);
		try {
			company.registerPartner(partner, null);
			company.registerPartner(partner1, partner);
			company.registerPartner(partner2, partner);
			company.registerPartner(partner3, partner);
			company.registerPartner(partner4, partner);
		} catch (RegisteredPartner e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		System.out.println("<----------------------test add order--------------->");
		Order order = new Order(01, new  Date(),01, 123, 12, 10);
		Order order1 = new Order(02, new  Date(),02, 123, 12, 10);
		Order order2 = new Order(03, new  Date(),03, 123, 12, 10);
		Order order3 = new Order(04, new  Date(),01, 123, 12, 10);
		Order order4 = new Order(05, new  Date(),02, 123, 12, 10);
		Order order5 = new Order(06, new  Date(),01, 123, 12, 10);
		
		
		OrderManager orderManager = new OrderManager();
		
		orderManager.addOrder(order);
		orderManager.addOrder(order1);
		orderManager.addOrder(order2);
		orderManager.addOrder(order3);
		orderManager.addOrder(order4);
		orderManager.addOrder(order5);
		
		company.setOrderManager(orderManager);
		
		System.out.println("<----------------------test obtener ordenes de un socio--------------->");
		System.out.println(" Orders - partner id: 1");
		company.getOrdersOfAPartner(partner).imprimir();
		System.out.println();
		System.out.println(" Orders - partner id: 2");
		company.getOrdersOfAPartner(partner1).imprimir();
		System.out.println();
		System.out.println(" Orders - partner id: 4");
		company.getOrdersOfAPartner(partner3).imprimir();
//		System.out.println(company.getOrdersOfAPartner(partner),);
		
		System.out.println("<----------------------test registro de devoluciones--------------->");
//		try {
//			company.registerARefund(partner, order5);
//			System.out.println(" Orders - partner id: 1");
//			company.getOrdersOfAPartner(partner).imprimir();
//			System.out.println();
//		} catch (ErrorNotFound e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

	}
}
