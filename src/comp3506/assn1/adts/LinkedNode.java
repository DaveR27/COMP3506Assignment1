package comp3506.assn1.adts;

class LinkedNode<T> {
	protected LinkedNode<T> nextNode = null;
	private T element = null;
	
	LinkedNode(T element) {
		this.element = element;
	}
	
	 protected T getNodeElement() {
		return this.element;
	}
	
	protected LinkedNode<T> getNextNode() {
		return this.nextNode;
	}
	
	protected void addNext(LinkedNode<T> node) {
		this.nextNode = node;
	}
}