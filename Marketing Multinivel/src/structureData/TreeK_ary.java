package structureData;

public class TreeK_ary<T> {

	private NodeTreeK_ary<T> root;

	public TreeK_ary() {
		this.root = null;
	}

	public boolean add(T info, T parent) {
		if (this.root == null || parent == null || info == null) {
			return false;
		} else {
			NodeTreeK_ary<T> finded = findParent(parent);
			if (finded != null) {
				finded.firtsSon = new NodeTreeK_ary<>(info, null, finded.firtsSon);
				return true;
			} else {
				return false;
			}
		}
	}
	
    /**
     * agrega la informacion a la raiz, solo permite crear una raiz
     *
     * @param info
     * @return
     */
    public boolean add(T info) {
        if (root == null) {
            this.root = new NodeTreeK_ary<>(info);
            return true;
        }
        return false;
    }

	/**
	 * busca y retorna el nodo padre dentro del arbol n-ario.
	 *
	 * @param parent
	 * @return
	 */
	public NodeTreeK_ary<T> findParent(T parent) {
		return find(root, parent);
	}

	/**
	 * metodo recursivo para buscar
	 *
	 * @param nodeAux
	 * @param infoParent
	 * @return
	 */
	public NodeTreeK_ary<T> find(NodeTreeK_ary<T> nodeAux, T infoParent) {
		NodeTreeK_ary<T> auxExit = null;
		if (nodeAux != null) {
			if (nodeAux.info.equals(infoParent)) {
				return nodeAux;
			} else {
				if (nodeAux.firtsSon != null) {
					auxExit = find(nodeAux.firtsSon, infoParent);
					if (auxExit != null) {
						return auxExit;
					}
				}
				if (nodeAux.nextBrother != null) {
					auxExit = find(nodeAux.nextBrother, infoParent);
					if (auxExit != null) {
						return auxExit;
					}
				}
			}
		}
		return auxExit;
	}

	// public boolean add(T partner, T father) {
	// NodeTreeK_ary<T> nodeAdd = new NodeTreeK_ary<T>(partner);
	// if (root == null) {
	// root = new NodeTreeK_ary<T>(partner);
	// return true;
	// } else {
	// NodeTreeK_ary<T> nodeFather = find(father);
	// if (nodeFather != null) {
	// addSonFather(nodeFather, nodeAdd);
	// return true;
	// } else {
	// return false;
	// }
	// }
	// }
	//
	// private void addSonFather(NodeTreeK_ary<T> father, NodeTreeK_ary<T>
	// nodeAdd) {
	// NodeTreeK_ary<T> aux = father.firtsSon;
	// if (aux == null) {
	// System.out.println("primero hijo vacio");
	// father.firtsSon = nodeAdd;
	// } else {
	// while (aux.nextBrother != null) {
	// aux = aux.nextBrother;
	// }
	// aux.setNextBrother(nodeAdd);
	// }
	// }
	//
	// /**
	// * Método que busca un nodo basado en una información
	// * Para hacer la comparación usa un comparador por ID
	// * @param info dato que se desea buscar
	// * @return nodo o null si no se encuentra
	// */
	// public NodeTreeK_ary<T> find(T info) {
	// //HACE FALTA PONER UN COMPARADOR
	// //REVISAR QUE FUNCIONE BIEN
	// NodeTreeK_ary<T> node = root;
	// if (node == null) {
	// System.out.println("null raiz");
	// return null;
	// } else {
	// if (node.info.equals(info)) {
	// return node;
	// } else {
	// node = node.firtsSon;
	// return findSearchSon(node, info);
	// }
	// }
	// }
	//
	// private NodeTreeK_ary<T> findSearchSon(NodeTreeK_ary<T> father, T info) {
	// NodeTreeK_ary<T> nodeAux = father;
	// while (nodeAux != null) {
	// if (nodeAux.info.equals(info)) {
	// return nodeAux;
	// } else {
	// while (nodeAux != null) {
	// if (nodeAux.info.equals(info)) {
	// return nodeAux;
	// } else {
	// nodeAux = nodeAux.nextBrother;
	// return findSearchSon(nodeAux, info);
	// }
	// }
	// nodeAux = nodeAux.firtsSon;
	// }
	// }
	// return null;
	// }

	public void printTree(NodeTreeK_ary<T> node) {
		if (node != null) {
			System.out.println(node.info);
			printTree(node.getFirtsSon());
			printTree(node.getNextBrother());
		}
	}

	public NodeTreeK_ary<T> getRoot() {
		return root;
	}

}