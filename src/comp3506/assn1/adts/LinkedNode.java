package comp3506.assn1.adts;

class LinkedNode<T> extends LinkedList<T> {
	protected LinkedNode<T> nextNode = null;
	private T element = null;
	
	LinkedNode(T element) {
		this.element = element;
	}
	
	 T getNodeElement() {
		return this.element;
	}
	
	LinkedNode<T> getNextNode() {
		return this.nextNode;
	}
	
	void addNext(LinkedNode<T> node) {
		this.nextNode = node;
	}
}