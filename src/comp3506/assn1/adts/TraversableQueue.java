package comp3506.assn1.adts;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class TraversableQueue<T> implements IterableQueue<T> {
	protected LinkedList<T> queue;
	
	public TraversableQueue() {
		this.queue = new LinkedList<T>();
	}
	
	//TODO: max queue size needs to be done.
	@Override
	public void enqueue(T element) throws IllegalStateException {
		this.queue.addTail(element);
	}

	@Override
	public T dequeue() throws IndexOutOfBoundsException {
		return this.queue.removeHead();
	}
	
	@Override
	public int size() {
		return this.queue.size();
	}
	
	@Override
	public Iterator<T> iterator() {
		return new LinkedListIterator();
	}
	
	
	private class LinkedListIterator extends TraversableQueue<T> implements Iterator<T> {
		private LinkedList<T>.LinkedNode currentNode;
		
		private LinkedListIterator() {
			 this.currentNode =  super.queue.head;
		}
		
		public boolean hasNext() {
			if (this.currentNode.getNextNode() != null) {
				return true;
			} else {
				return false;
			}
		}
		
		public T next() throws NoSuchElementException{
			if (this.hasNext()) {
				LinkedList<T>.LinkedNode<T> tempNode = this.currentNode;
				this.currentNode = this.currentNode.getNextNode();
				return tempNode.getNodeElement();
			} else {
				throw new NoSuchElementException();
			}
		}
		
	}

}
