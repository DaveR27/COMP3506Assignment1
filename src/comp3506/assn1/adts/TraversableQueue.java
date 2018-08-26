package comp3506.assn1.adts;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 
 * 
 * Memory Usage:
 * 
 * @author David Riddell
 *
 * @param <T> Generic Type used to represent what the type of the Object that can
 * 		be stored within this data structure
 */
public class TraversableQueue<T> implements IterableQueue<T> {
	protected LinkedList<T> queue;
	
	public TraversableQueue() {
		this.queue = new LinkedList<T>();
	}
	
	/**
	 * Takes in a new <T> to add to the linked list, this element is added
	 * to an LinkedNode object which is what is used to store its position within
	 * the linked list. Since this structure if a FIFO structure the node that element
	 * is added to is always the tail of the structure.
	 * 
	 * Run-Time Efficiency:
	 * In the least calls case of this method executing 8 operations are called 
	 * and in the most calls case 8 operations are also called. So Let x be the 
	 * least calls case and y be the most, Since
	 * x == y and 8 is a constant integer, T(n) == c where T(n) is the worst run time
	 * and c is a constant.
	 * Therefore This method has a run-time efficiency of: 
	 * 
	 * O(1)
	 * 
	 * @param element An element of type <T> that is added to the end of the linked
	 * 		list.
	 * @throws IllegalStateException Queue cannot accept new element.
	 * 
	 */
	@Override
	public void enqueue(T element) throws IllegalStateException {
		this.queue.addTail(element); // 1 for calling function
	}
	
	/**
	 * Returns the item that is at the head of the queue if there is something
	 * that has been enqueued before. If the queue is empty the method will throw
	 * an exception notifying that the method cannot be used.
	 * 
	 * Run-Time Efficiency:
	 * There are 3 different paths that this method can take. 
	 * Path 1:
	 * First of all if the queue has a size of 0, then nothing can be dequeued 
	 * so a function call returning its size and check to see if it equals 0 occurs,
	 *  letting the function have a constant time of 2. 
	 * Path 2:
	 * In the second case something can be dequeued and it 
	 * is the only item in the queue, then 2 check, 5 assignments 3 function calls
	 * and 2 returns occur giving the function a constant time of 12.
	 * Path 3:
	 * In this case something is dequeued and another element becomes the head of
	 * the queue. For this to happen, 5 returns, 2 checks, 4 assignments, 4 function
	 * calls and a decrement occur giving a constant time of 17. 
	 * Since Paths 1-3 all have constant integer values for their Primitive Operation
	 * count it can be said that:
	 * f(n) == c where c is a constant value or f(n) == c*g(n) where g(n) is fundamental
	 * constant function of g(n) == 1 and c is a constant values of the amount of 
	 * primitive operations in f.
	 * Since the above is how this method can be represented
	 * the upper bound of the function will be:
	 * 
	 * O(1)
	 * 
	 * @return returnedItem the item at the front front of the queue.
	 * @throws IndexOutOfBoundsException Queue is empty and nothing can be taken
	 * 		off the end of the queue.
	 */
	@Override
	public T dequeue() throws IndexOutOfBoundsException {
		if (this.queue.getSize() == 0) { // 2 function call and check
			throw new IndexOutOfBoundsException(); // 1
		}
		T returnedItem = this.queue.removeHead(); // 2 assignment and function call
		return returnedItem; // 1
	}
	
	/**
	 * Returns the amount of elements of type <T> that are being stored within 
	 * this queue.
	 * 
	 * Run-Time Efficiency:
	 * For this method to work 3 amount of primitive operations have to occur, these
	 * include 2 returns and 1 function call. That means this method has a constant
	 * time of 3. So it can be said f(n) == c where c is a constant and f(n) is the
	 * amount of times the function is called. If this is compared to the fundamental
	 * constant function of g(n) == 1, f(n) == c*g(n), which makes the upper bound of
	 * this method:
	 * 
	 * O(1)
	 * 
	 * @return this.queue.getSize() the amount of nodes/elements that are stored
	 * 		within the Queue.
	 */
	@Override
	public int size() {
		return this.queue.getSize(); // 2 return and function call
	}
	
	/**
	 * This method instantiates and returns a new Iterator<T> for the 
	 * TraversableQueue so that the content of the queue can be looked
	 * at.
	 * 
	 * Run-Time Efficiency:
	 * In this method when a new LinkedListIterator is made the constructor of
	 * that function executes 2 assignments, 1 function call and 1 return. In this
	 * iterator function a function call and a return occurs, so overall for the
	 * iterator method to run 6 primitive operations have to occur. This means that
	 * this method has a constant time of 6 and can be said to have a run-time of
	 * f(n) == c*g(n) where c the constant. So the upper bound of this method is
	 * 
	 * O(1)
	 * 
	 * 
	 * @return LinkedListIterator Iterator able to iterate through the queue
	 * 		so the particular elements can be found.
	 */
	@Override
	public Iterator<T> iterator() {
		return new LinkedListIterator(); // 2 return and function call
	}
	
	
	private class LinkedListIterator implements Iterator<T> {
		private LinkedNode<T> currentNode;
		
		private LinkedListIterator() {
			LinkedNode<T> masterNode = new LinkedNode<T>(null); // 2
			masterNode.addNext(queue.head); // 1
			this.currentNode = masterNode; // 1
			
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
				T returnElement = this.currentNode.getNextNode().getNodeElement();
				this.currentNode = this.currentNode.getNextNode();
				return returnElement;
			} else {
				throw new NoSuchElementException();
			}
		}
		
	}

}
