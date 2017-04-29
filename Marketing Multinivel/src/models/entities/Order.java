package models.entities;

import java.util.Date;

public class Order {
	
	private int registerId;
	private Date date; 
	private int idPartner;
	private int codeProduct;
	private int quantity;
	private int status;
	public static final int ORDER_DEVOLUTION = 0;
	public static final int ORDER_DELIVERED = 1;
	
	public Order(int registerId, Date date, int idPartner, int codeProduct, int quantity, int status) {
		this.registerId = registerId;
		this.date = date;
		this.idPartner = idPartner;
		this.codeProduct = codeProduct;
		this.quantity = quantity;
		this.status = status;
	}
	
	public int getRegisterId() {
		return registerId;
	}
	public void setRegisterId(int registerId) {
		this.registerId = registerId;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getIdPartner() {
		return idPartner;
	}
	public void setIdPartner(int idPartner) {
		this.idPartner = idPartner;
	}
	public int getCodeProduct() {
		return codeProduct;
	}
	public void setCodeProduct(int codeProduct) {
		this.codeProduct = codeProduct;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	public Object[] getOrder() {
		return new Object[] { registerId, date, idPartner, codeProduct, quantity, status};
	}

	@Override
	public String toString() {
		return "Order [registerId=" + registerId + ", date=" + date + ", idPartner=" + idPartner + ", codeProduct="
				+ codeProduct + ", quantity=" + quantity + ", status=" + status + "]";
	}
}