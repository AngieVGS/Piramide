package structureData;

import java.util.Comparator;


public class SimpleList<T> {

	private NodeSimpleList<T> head;

	public SimpleList() {
		this.head = null;
	}

	public NodeSimpleList<T> getHead() {
		return head;
	}

	public void setHead(NodeSimpleList<T> head) {
		this.head = head;
	}

	public boolean isEmpty() {
		return head == null;
	}

	/**
	 * Agrega informacion al final de la lista
	 * 
	 * @param info
	 */
	public void add(T info) {
		if (this.head == null) {
			this.head = new NodeSimpleList<>(info);
		} else {
			NodeSimpleList<T> head = this.head;
			while (head.getNext() != null) {
				head = head.getNext();
			}
			head.setNext(new NodeSimpleList<T>(info));
		}
	}

	public void sort(Comparator<T> comparable) {
		NodeSimpleList<T> aux1, aux2;
		aux2 = head;
		while (aux2 != null) {
			aux1 = aux2.getNext();
			while (aux1 != null) {
				if (comparable.compare(aux1.getInformation(), aux2.getInformation()) < 0) {
					T aux = aux2.getInformation();
					aux2.setInformation(aux1.getInformation());
					aux1.setInformation(aux);
				}
				aux1 = aux1.getNext();
			}
			aux2 = aux2.getNext();
		}
	}

	/**
	 * agrega al princioio de la lista
	 * 
	 * @param info
	 */
	public void insert(T info) {
		this.head = new NodeSimpleList<T>(info, head);
	}
	
	
	public void editInformation(int pos, T information) {
		NodeSimpleList<T> auxHead = this.head;
		int counter = 0;
		while (auxHead != null) {
			if (pos == counter) {
				auxHead.setInformation(information);
			}
			counter++;
			auxHead = auxHead.getNext();
		}
	}
	
	public T get(int pos) {
		NodeSimpleList<T> aux = this.head;
		T information = null;
		int count = 0;
		while (aux != null) {
			if (count == pos) {
				information = aux.getInformation();
			} else {
				count++;
				aux = aux.getNext();
			}
		}
		return information;

	}

	public int indexOf(T info) {
		NodeSimpleList<T> aux = this.head;
		int count = 0;
		while (aux != null) {
			if (info.equals(aux.getInformation())) {
				aux = null;
			} else {
				count++;
				aux = aux.getNext();
			}
		}
		return count;
	}

	public void remove(int pos) {
		NodeSimpleList<T> auxNode = this.head;
		NodeSimpleList<T> lastNode = null;
		int count = 0;
		while (auxNode != null) {
			if (pos == count) {
				if (lastNode == null) {
					this.head = this.head.getNext();
				} else {
					lastNode.setNext(auxNode.getNext());
				}
				auxNode = null;
			} else {
				lastNode = auxNode;
				auxNode = auxNode.getNext();
				count++;
			}
		}
	}

	public int size() {
		NodeSimpleList<T> head = this.head;
		int count = 0;
		while (head != null) {
			count++;
			head = head.getNext();
		}
		return count;
	}
}