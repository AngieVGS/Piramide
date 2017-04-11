package structureData;

public class Node<T> {
	
	protected T info;
	protected Node<T> nextBrother;
	protected Node<T> firtsSon;
	
	public Node(T info) {
		super();
		this.info = info;
	}

	public Node(T info, Node<T> nextBrother, Node<T> firtsSon) {
		this.info = info;
		this.nextBrother = nextBrother;
		this.firtsSon = firtsSon;
	}
	
	public T getInfo() {
		return info;
	}
	
	public void setInfo(T info) {
		this.info = info;
	}
	
	public Node<T> getNextBrother() {
		return nextBrother;
	}
	
	public void setNextBrother(Node<T> nextBrother) {
		this.nextBrother = nextBrother;
	}
	
	public Node<T> getFirtsSon() {
		return firtsSon;
	}
	
	public void setFirtsSon(Node<T> firtsSon) {
		this.firtsSon = firtsSon;
	}
}