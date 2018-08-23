package comp3506.assn1.adts;

import org.junit.*;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.NoSuchElementException;


public class MyTraversableQueueTest {
	TraversableQueue<Object> nullQueue;
	TraversableQueue<Object> test1Queue;
	
	@Before
	public void setUp() {
		this.nullQueue = new TraversableQueue<Object>();
		this.test1Queue = new TraversableQueue<Object>();
	}
	
	/**
	 * Tests for standard use of the Structure, tests all the methods
	 * for TraversableQueue and how they interact with one another.
	 */
	@Test
	public void standardUseTest() {
		Object testObject = new Object();
		for (int i = 0; i <= 5; i++) {
			this.test1Queue.enqueue(testObject);
		}
		
		for (int i = 5; i > 0; i--) {
			assertTrue(test1Queue.dequeue().equals(testObject));
			assertTrue(test1Queue.size() == i);
		}
	}
	
	/**
	 * Tests to see if null elements can be added to the structure with ease
	 * also tests to see if the correct error is thrown if over dequeuing
	 * of the TraversableQueue structure occurs.
	 */
	@Test
	public void addNullTest() {
		for (int i = 0; i <= 4; i++) {
			this.test1Queue.enqueue(null);
		}
		for (int i = 4; i >= 0; i--) {
			assertTrue(this.test1Queue.dequeue() == null);
		}
		try {
			this.nullQueue.dequeue();
			fail();
		} catch (IndexOutOfBoundsException e) {
			
		}
	}
	
	/**
	 * Tests the iterator methods in the private class of TransversableQueue
	 */
	@Test
	public void iteratorTest() {
		Object testObject = new Object();
		for (int i = 0; i <= 5; i++) {
			this.test1Queue.enqueue(testObject);
		}
		
		Iterator<Object> testIterator = this.test1Queue.iterator();
		assertFalse(testIterator  instanceof TraversableQueue);
		assertTrue(testIterator instanceof Iterator);
		
		while (testIterator.hasNext()) {
			assertTrue(testObject.equals(testIterator.next()));
		}
		assertFalse(testIterator.hasNext() == true);
		try {
			testIterator.next();
			fail();
		} catch (NoSuchElementException e) {
			
		}
	}
	
	
}
