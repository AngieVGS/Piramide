package models.entities;

public class Product {

	private int ref;
	private String line;
	private String description;
	private Genre target;
	private double price;

	public Product(int ref, String line, String description, Genre target, double price) {
		this.ref = ref;
		this.line = line;
		this.description = description;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public Object[] getProduct() {
		return new Object[] { ref, line, description, target, price };
	}
}