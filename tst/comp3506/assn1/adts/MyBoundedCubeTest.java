package comp3506.assn1.adts;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.*;

public class MyBoundedCubeTest {
	BoundedCube<Object> testCube;
	
	@Before
	public void setUp() {
		this.testCube = new BoundedCube<>(10,10,10);
	}
	
	/**
	 * Test for strange boundary values that could be used to try and instantiate
	 * a cube with.
	 */
	@Test
	public void boundedCubeStrangeValues() {
		@SuppressWarnings("unused")
		BoundedCube<Object> negativeCube;
		
		try {
			negativeCube = new BoundedCube<Object>(-1,-100,-1);
			fail();
		} catch (IllegalArgumentException e) {
			
		}
	}
	
	/**
	 * Tests the add and get methods of a BoundedCube.
	 */
	@Test
	public void addGetTest() {
		for (int i = 0; i < 10; i++) {
			this.testCube.add(5, 5, 5, new Object());
		}
		assertTrue(this.testCube.get(5, 5, 5) instanceof Object);
		assertTrue(this.testCube.getAll(5, 5, 5) instanceof TraversableQueue);
	}
	
	/**
	 * Tests that checks to see if the isMultipleElementsAt
	 */
	@Test
	public void multiEleAtTest() {
		assertTrue(this.testCube.isMultipleElementsAt(5,5,5) == false);
		for (int i = 0; i < 10; i++) {
			this.testCube.add(5, 5, 5, new Object());
		}
		assertTrue(this.testCube.isMultipleElementsAt(5,5,5));
		
	}
	
	/**
	 * This tests the remove method
	 */
	@Test
	public void removeTest() {
		assertFalse(this.testCube.remove(5, 5, 5, new Object()));
		Object testObject = new Object();
		Object testObject2 = new Object();
		Object testObject3 = new Object();
		
		this.testCube.add(5, 5, 5, testObject);
		this.testCube.add(5, 5, 5, testObject2);
		this.testCube.add(5, 5, 5, testObject3);
		
		//tests middle remove
		assertTrue(this.testCube.remove(5, 5, 5, testObject2) == true);
		this.testCube.add(5, 5, 5, testObject2);
		//tests start remove
		assertTrue(this.testCube.remove(5, 5, 5, testObject) == true);
		this.testCube.add(5, 5, 5, testObject);
		//tests end remove
		assertTrue(this.testCube.remove(5, 5, 5, testObject) == true);
		
	}
	
	/**
	 * Tests the removeAll and clear methods
	 */
	@Test
	public void removeClearTest() {
		for (int i = 0; i < 10; i++) {
			this.testCube.add(5, 5, 5, new Object());
		}
		assertTrue(this.testCube.getAll(5, 5, 5).size() == 10);
		this.testCube.removeAll(5, 5, 5);
		//assertTrue(this.testCube.get(5, 5, 5) == null);
		for (int i = 0; i < 10; i++) {
			this.testCube.add(5, 5, 5, new Object());
		}
		for (int i = 0; i < 10; i++) {
			this.testCube.add(4, 4, 4, new Object());
		}
		for (int i = 0; i < 10; i++) {
			this.testCube.add(3, 3, 3, new Object());
		}
		assertTrue(this.testCube.getAll(5, 5, 5).size() == 10);
		assertTrue(this.testCube.getAll(4, 4, 4).size() == 10);
		assertTrue(this.testCube.getAll(3, 3, 3).size() == 10);
		
		this.testCube.clear();
		assertTrue(this.testCube.getAll(5, 5, 5) == null);
		assertTrue(this.testCube.getAll(4, 4, 4) == null);
		assertTrue(this.testCube.getAll(3, 3, 3) == null);
	}
	
}
