package models.entities;

public class Product {
	
	private int ref ;
	private String line;
	private String reference;
	private Genre target;
	private double price;

	public Product(int ref, String line, String reference, Genre target, double price) {
		this.ref = ref;
		this.line = line;
		this.reference = reference;
		this.target = target;
		this.price = price;
	}

	public int getId() {
		return ref;
	}
	
	public void setId(int id) {
		this.ref = id;
	}
	
	public int getRef() {
		return ref;
	}

	public void setRef(int ref) {
		this.ref = ref;
	}

	public String getLine() {
		return line;
	}

	public void setLine(String line) {
		this.line = line;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public Genre getTarget() {
		return target;
	}

	public void setTarget(Genre target) {
		this.target = target;
	}

	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
}