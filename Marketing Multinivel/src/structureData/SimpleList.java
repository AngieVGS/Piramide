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
	
	public boolean isEmpty(){
		return head == null;
	}
	
/**
 * add agrega informacion al final de la lista 
 * @param info
 */
	public void add(T info){
		if (this.head == null) {
			this.head = new NodeSimpleList<>(info);
		}else{
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
	 * @param info
	 */
	public void insert(T info){
		this.head = new NodeSimpleList<T>(info, head);
	}
}