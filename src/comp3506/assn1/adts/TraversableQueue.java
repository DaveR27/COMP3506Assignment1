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
		return this.queue.getSize();
	}
	
	@Override
	public Iterator<T> iterator() {
		return new LinkedListIterator();
	}
	
	
	private class LinkedListIterator implements Iterator<T> {
		private LinkedNode<T> currentNode;
		private int nodePointer;
		
		private LinkedListIterator() {
			this.currentNode =  queue.head;
			this.nodePointer = 0;
		}
		
		public boolean hasNext() {
			if (this.nodePointer == queue.getSize()) {
				return false;
			} else {
				return true;
			}
		}
		
		public T next() throws NoSuchElementException{
			if (this.hasNext()) {
				LinkedNode<T> tempNode = this.currentNode;
				this.currentNode = this.currentNode.getNextNode();
				this.nodePointer++;
				return tempNode.getNodeElement();
			} 
			if (this.nodePointer > queue.getSize()) {
				throw new NoSuchElementException();
			}
			return null;
		}
		
	}

}
