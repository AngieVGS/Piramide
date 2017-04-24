/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package structureData;

/**
 *
 * @author Yuliana Boyaca
 */
public class NodeNario<T> {

    protected T info;
    protected NodeNario<T> first;
    protected NodeNario<T> next;

    public NodeNario(T info, NodeNario<T> first, NodeNario<T> next) {
        this.info = info;
        this.first = first;
        this.next = next;
    }

    public NodeNario(T info, NodeNario<T> first) {
        this.info = info;
        this.first = first;
        this.next = null;
    }

    public NodeNario(T info) {
        this.info = info;
        this.first = null;
        this.next = null;
    }

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public NodeNario<T> getFirst() {
        return first;
    }

    public void setFirst(NodeNario<T> first) {
        this.first = first;
    }

    public NodeNario<T> getNext() {
        return next;
    }

    public void setNext(NodeNario<T> next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Node{" + "info=" + info + ", first=" + first + ", next=" + next + '}';
    }
    
}
