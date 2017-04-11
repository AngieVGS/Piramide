package structureData;

public class TreeK_ary<T> {
	
	private Node<T> root;

	public TreeK_ary() {
		this.root = null;
	}
	
	public boolean Add(T info,T father){
		Node<T> nodeAdd = new Node<T>(info);
		if (root == null) {
			root = new Node<T>(info);
			return true;
		}else{
			Node<T> nodeFather = find(father);
			if (nodeFather != null) {
				addSonFather(nodeFather, nodeAdd);
				return true;
			}else{
				return false;
			}
		}
	}

	private void addSonFather(Node<T> father, Node<T> nodeAdd){
		Node<T> aux = father.firtsSon;
		if (aux == null) {
			father.firtsSon = nodeAdd;
		}else{
			while (aux.nextBrother !=null) {
				aux = aux.nextBrother;
			}
			aux.setNextBrother(nodeAdd);
		}
	}
	
	
	public Node<T> find(T info) {
		Node<T> node = root;
		if (node == null) {
			return null;
		}else{
			if (node.info.equals(info)) {
				return node;
			}else{
				node = node.firtsSon;
				return findSearchSon(node, info);
			}
		}
	}
	
	private Node<T> findSearchSon(Node<T> father, T info){
		Node<T> nodeAux = father;
		while (nodeAux != null) {
			if (nodeAux.info.equals(info)) {
				return nodeAux;
			}else{
			while (nodeAux != null) {
				if (nodeAux.info.equals(info)) {
					return nodeAux;
				}else{
					nodeAux = nodeAux.nextBrother;
				return findSearchSon(nodeAux, info);	
				}
			}
			nodeAux =nodeAux.firtsSon;
			}
		}
		return null;
	}
}