package structureData;

public class NodeSimpleList<T> {

	private T information;
	private NodeSimpleList<T> next;

	public NodeSimpleList() {
		this.information = null;
		this.next = null;
	}

	public NodeSimpleList(T information) {
		this(information, null);
	}

	public NodeSimpleList(T information, NodeSimpleList<T> next) {
		this.information = information;
		this.next = next;
	}

	public T getInformation() {
		return information;
	}

	public void setInformation(T information) {
		this.information = information;
	}

	public NodeSimpleList<T> getNext() {
		return next;
	}

	public void setNext(NodeSimpleList<T> next) {
		this.next = next;
	}
}