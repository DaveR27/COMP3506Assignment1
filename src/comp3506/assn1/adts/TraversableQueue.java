package comp3506.assn1.adts;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class TraversableQueue<T> implements IterableQueue<T> {
	protected LinkedList<T> queue;
	
	public TraversableQueue() {
		this.queue = new LinkedList<T>();
	}
	
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
		return this.queue.getSize();
	}
	
	@Override
	public Iterator<T> iterator() {
		return new LinkedListIterator();
	}
	
	
	private class LinkedListIterator implements Iterator<T> {
		private LinkedNode<T> currentNode;
		
		private LinkedListIterator() {
			LinkedNode<T> masterNode = new LinkedNode<T>(null);
			masterNode.addNext(queue.head);
			this.currentNode = masterNode;
			
		}
		
		public boolean hasNext() {
			if (this.currentNode.getNextNode() != null) {
				return true;
			} else {
				return false; 
			}
		}
		
		public T next() throws NoSuchElementException{
			if (queue.getSize() == 0) {
				throw new NoSuchElementException();
			}
			if (this.hasNext()) {
				T returnElement = this.currentNode.getNextNode().getNodeElement();
				this.currentNode = this.currentNode.getNextNode();
				return returnElement;
			} 
			return null;
		}
		
	}

}
