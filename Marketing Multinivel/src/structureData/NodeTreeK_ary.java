package structureData;

public class NodeTreeK_ary<T> {

	protected T info;
	protected NodeTreeK_ary<T> nextBrother;
	protected NodeTreeK_ary<T> firtsSon;

	public NodeTreeK_ary(T info) {
		this(info, null, null);
	}

	public NodeTreeK_ary(T info, NodeTreeK_ary<T> nextBrother, NodeTreeK_ary<T> firtsSon) {
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

	public NodeTreeK_ary<T> getNextBrother() {
		return nextBrother;
	}

	public void setNextBrother(NodeTreeK_ary<T> nextBrother) {
		this.nextBrother = nextBrother;
	}

	public NodeTreeK_ary<T> getFirtsSon() {
		return firtsSon;
	}

	public void setFirtsSon(NodeTreeK_ary<T> firtsSon) {
		this.firtsSon = firtsSon;
	}
}