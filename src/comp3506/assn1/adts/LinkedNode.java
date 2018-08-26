package comp3506.assn1.adts;

class LinkedNode<T> {
	protected LinkedNode<T> nextNode = null;
	private T element = null;
	
	/**
	 * Constructor that will make a LinkedNode object.
	 * 
	 * @param element the Object of type <T> that this node will contain.
	 */
	LinkedNode(T element) {
		this.element = element;
	}
	
	/**
	 * Returns the element that this node holds.
	 * 
	 * @return element the object that this node holds.
	 */
	 protected T getNodeElement() {
		return this.element;
	}
	
	 /**
	  * Gets the node that is in the position after this current node.
	  * 
	  * @return the node in the position after this node
	  */
	protected LinkedNode<T> getNextNode() {
		return this.nextNode;
	}
	
	/**
	 * Assigns a node to be positioned after this node
	 * 
	 * @param node the node to come after this node
	 */
	protected void addNext(LinkedNode<T> node) {
		this.nextNode = node; // 1
	}
}