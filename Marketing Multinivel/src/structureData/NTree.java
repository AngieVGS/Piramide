/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package structureData;

import java.util.Comparator;

/**
 *
 * @author Yuliana Boyaca
 */
public class NTree<T> {

    private NodeNario<T> root;
    private Comparator<T> comparator;

    public NTree(Comparator<T> comparator) {
    	this.comparator = comparator; 
        this.root = null;
    }

    public NTree(NodeNario<T> root, Comparator<T> comparator) {
        this.root = root;
        this.comparator = comparator;
    }

    public boolean isEmpty() {
        return this.root == null;
    }

    /**
     * agrega la informacion a la raiz, solo permite crear una raiz
     *
     * @param info
     * @return
     */
    public boolean add(T info) {
        if (root == null) {
            this.root = new NodeNario<>(info);
            return true;
        }
        return false;
    }

    /**
     *agrega la informacion indicada al padre que se indica por parametro
     * si el padre ya tiene hijos, lo agrega de primeras.
     * @param info
     * @param parent
     * @return
     */
    public boolean add(T info, T parent) {
        if (this.root == null || parent == null || info == null) {
            return false;
        } else {
            NodeNario<T> finded = findParent(parent);
            if (finded != null) {
                finded.first = new NodeNario<>(info, null, finded.first);
                return true;
            } else {
                return false;
            }
        }
    }

    /**
     * busca y retorna el nodo padre dentro del arbol n-ario.
     *
     * @param parent
     * @return
     */
    public NodeNario<T> findParent(T parent) {
        return find(root, parent);
    }

    /**
     * metodo recursivo para buscar
     *
     * @param nodeAux
     * @param infoParent
     * @return
     */
    public NodeNario<T> find(NodeNario<T> nodeAux, T infoParent) {
        NodeNario<T> auxExit = null;
        if (nodeAux != null) {
            if (comparator.compare(nodeAux.info, infoParent) == 0) {
                return nodeAux;
            } else {
                if (nodeAux.first != null) {
                    auxExit = find(nodeAux.first, infoParent);
                    if (auxExit != null) {
                        return auxExit;
                    }
                }
                if (nodeAux.next != null) {
                    auxExit = find(nodeAux.next, infoParent);
                    if (auxExit != null) {
                        return auxExit;
                    }
                }
            }
        }
        return auxExit;
    }

    /**
     * metodo de imprimir
     */
    public void imprimir() {
        imprimir(root);
    }

    /**
     * metodo recursivo que imprime todos los primeros y luego los siguientes o los hermanos
     * @param nodeAux 
     */
    public void imprimir(NodeNario<T> nodeAux) {
        if (nodeAux != null) {
            System.out.println(nodeAux.getInfo());
            imprimir(nodeAux.first);
            imprimir(nodeAux.next);
        }
    }
    
    
}
