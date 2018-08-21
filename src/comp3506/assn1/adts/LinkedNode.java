package comp3506.assn1.adts;

class LinkedNode<T> extends LinkedList<T> {
	protected LinkedNode<T> prevNode = null;
	private T element = null;
	
	LinkedNode(T element) {
		this.element = element;
	}
	
	 protected T getNodeElement() {
		return this.element;
	}
	
	protected LinkedNode<T> getNextNode() {
		return this.prevNode;
	}
	
	protected void addNext(LinkedNode<T> node) {
		this.prevNode = node;
	}
}