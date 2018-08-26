package comp3506.assn1.adts;

/**
 * 
 * @author David Riddell
 *
 * @param <T>
 */
class LinkedList<T> {
	protected LinkedNode<T> head;
	protected LinkedNode<T> tail;
	private int size;
	
	LinkedList() {
		this.size = 0;
		this.head = null;
		this.tail = null;
	}
	
	/**
	 * Takes in a new element <T> which is added to a new LinkedNode. This new
	 * Node will always be at the tail of the List unless the element being added
	 * is the first element being added to the structure, in which case the the node
	 * will be both the head and the tail until a new element is added then it will
	 * just be the head of the structure.
	 * 
	 * @param element element to be added to a new node that will be at the tail
	 * 		of the linked list.
	 * @throws IllegalStateException Queue cannot accept new element
	 */
	protected void addTail(T element) throws IllegalStateException{
		LinkedNode<T> node = new LinkedNode<T>(element); // 1
		
		if (this.size == 0) { // 1
			this.head = node; // 1
			this.tail = node; // 1
			this.size++; // 2
		} else {
			this.tail.addNext(node); // 1 for calling function
			this.tail = node; // 1
			this.size++; // 2 assignment and increment
		}
	}
	
	/**
	 * Removes the head of the LinkedList, gets the next node along and makes
	 * that the new head of the list. If the last element within the list is 
	 * removed the head and the tail of the LinkedList are set back to their
	 * default state of null and the size of the LinkedList is set back to 0.
	 * 
	 * @return removedObject The object that was was contained in the node at the 
	 * 		head of the list. If there is nothing at the head null is returned as
	 * 		that is the default value for the LinkedList head.
	 */
	protected T removeHead() {
		T removedObject = null; // 1
		if (this.size == 1) { // 1
			this.head = null; // 1
			this.tail = null; // 1
			this.size = 0; // 1
		}
		else {
			removedObject = this.head.getNodeElement(); // 2
			this.head = this.head.getNextNode(); // 2
			this.size--; // 2
		}
		return removedObject; // 1
	}
	
	/**
	 * Returns the number of nodes that are contained within the LinkedList.
	 * 
	 * @return size the amount of nodes in the LinkedList.
	 */
	protected int getSize() {
		return this.size; //1
	}
	

	
}