package comp3506.assn1.adts;

class LinkedList<T> {
	protected LinkedNode<T> head;
	protected LinkedNode<T> tail;
	private int size;
	
	LinkedList() {
		this.size = 0;
		this.head = null;
		this.tail = null;
	}
	
	protected void addTail(T element) throws IllegalStateException{
		LinkedNode<T> node = new LinkedNode<T>(element);
		
		if (this.size == 0) {
			this.head = node;
			this.size++;
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
			if (this.size == 1) {
				this.head = null;
				this.tail = null;
			} else {
				this.head = this.head.getNextNode();
				this.size--;
			}
		}
		
		return removedObject;
		
	}
	
	
	protected int getSize() {
		return this.size;
	}
	
}