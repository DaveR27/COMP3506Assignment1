package comp3506.assn1.adts;

class LinkedList<T> extends TraversableQueue<T> {
	protected LinkedNode<T> head;
	protected LinkedNode<T> tail;
	private int size;
	
	protected LinkedList() {
		this.size = 0;
		this.head = null;
		this.tail = null;
	}
	
	protected void addTail(T element) throws IllegalStateException{
		LinkedNode<T> node = new LinkedNode<T>(element);
		
		if (this.size == 0) {
			this.head = node;
		} else {
			node.addNext(this.tail);
			this.tail = node;
			this.size++;
		}
	}
	
	protected T removeHead() throws IndexOutOfBoundsException {
		T removedObject;
		
		if (this.size == 0) {
			throw new IndexOutOfBoundsException();
		} else {
			removedObject = this.head.getNodeElement();
			this.head = this.head.getNextNode();
			this.size--;
		}
		
		return removedObject;
		
	}
	
}