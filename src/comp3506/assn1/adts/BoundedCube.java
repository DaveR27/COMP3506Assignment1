package comp3506.assn1.adts;

import java.util.Iterator;

/**
 * A three-dimensional data structure that holds items in a positional relationship to each other.
 * Each cell in the data structure can hold multiple items.
 * A bounded cube has a specified maximum size in each dimension.
 * The root of each dimension is indexed from zero.
 * 
 * Memory usage (Space Complexity):
 * For a BoundedCube to work in memory it needs space for 3 int's an a 3d array of sizes n, n and n,  
 * all of which need to be able to hold IterableQueues. This structure can then be represented as
 * 3 + 3n in memory and since only the upper bound of the structure needs to be analyzed only the
 * n needs to be taken into consideration. As the constant values are being ignored then
 * f(n) == n where n is the input size and f(n) is the amount of primitive function calls on the n
 * objects. As the memory growth is linear the Big-o notation for the space complexity is:
 * 
 * O(n)
 * 
 * @author David Riddell
 *
 * @param <T> The type of element held in the data structure.
 */
public class BoundedCube<T> implements Cube<T> {
	private IterableQueue<T> cube[][][]; //models the aus airspace
	private int length;
	private int breadth;
	private int height;
	
	/**
	 * Created a bounded cube to model a 3d space by using a 3d array. This
	 * method will only accept int's > 0 and is checked for by an internal helper
	 * method.
	 * 
	 * Run-Time Efficiency:
	 * In the worst case of instantiating this method it will have a primitive
	 * operation count of 15 + 3n. The limiting factor of this count is the 3n
	 * and this is due to making a 3d array. Making an array has n operations so
	 * it has a big-o of n and since this occurring 3 times in this method to make 
	 * a 3d array, 3n has to be added to the operation count. For upper bound
	 * analysis of this method the limiting factor has to be the only thing taken
	 * into consideration. This in turn means that this method's efficiency can be 
	 * represented by f(n) == n where f(n) is the amount of times this function is called. 
	 * Since f(n) == n it can be seen that a linear growth is occurring which relies
	 * on an unknown that is the size of the 3d array. Seeing as it is linear the big-o for
	 * this method is:
	 * 
	 * O(n)
	 * 
	 * 
	 * @param length  Maximum size in the 'x' dimension.
	 * @param breadth Maximum size in the 'y' dimension.
	 * @param height  Maximum size in the 'z' dimension.
	 * @throws IllegalArgumentException If provided dimension sizes are not positive.
	 */
	@SuppressWarnings("unchecked")
	public BoundedCube(int length, int breadth, int height) throws IllegalArgumentException {
		if (!(this.checkPositiveValues(length, breadth, height))) { // 5
			throw new IllegalArgumentException(); //  1
		}
		this.length = length; // 1
		this.height = height; // 1
		this.breadth = breadth; // 1
		this.cube = new TraversableQueue[this.length][this.breadth][this.height]; // 7 + 3n where n is array size
	}
	
	/**
	 * Checks that positive numbers are entered into the constructor.
	 * 
	 * Run-Time Efficiency:
	 * Every operation is a constant operation so this method works
	 * in constant time so:
	 * 
	 * O(1)
	 * 
	 * @param length: length of cube.
	 * @param breadth: breadth of cube.
	 * @param height: height of cube.
	 * @return true if all the entered int's are positive, otherwise false.
	 */
	private boolean checkPositiveValues(int length, int breadth, int height) {
		if (length > 0 && breadth > 0 && height > 0) { // 3
			return true; // 1
		} else {
			return false; // 1
		}
	}
	
	/**
	 * Adds a new element to that index of the cube. If nothing is being held in that
	 * position then a new TraversableQueue is added to the index so that element can be added
	 * to it. If something is already at this specified position then the element is then
	 * just enqueued.
	 * 
	 * Run-Time Efficiency:
	 * There are 2 paths this method can take:
	 * Path one:
	 * Into the if statement so 2 operations for checking and indexing then an
	 * additional 8 for adding the TraversableQueue to the index. After that the bottom
	 * line is executed so another 10 operations are called thus giving the method an
	 * operation count of 20.
	 * Path two:
	 * the check occurs counting as 2 operations then just the bottom line executes giving
	 * a total of 12 operations.
	 * Since both paths result in just constants being in the operations count it can be said
	 * that f(n) == c*g(n) and gives this method a big-o of:
	 * 
	 * O(1)
	 * 
	 * @param x index 1 of the cube.
	 * @param y index 2 of the cube.
	 * @param z index 3 of the cube.
	 * @param element to be added to a TraversableQueue at [x][y][z].
	 * @throws IndexOutOfBoundsException occurs if an index is given that isn't valid for this
	 * 		cube.
	 */
	@Override
	public void add(int x, int y, int z, T element) throws IndexOutOfBoundsException {
		if (this.cube[x][y][z] == null) { // 2
			//8 this includes function calls and assignments of all related functions*/
			this.cube[x][y][z] = new TraversableQueue<T>(); 
		}
		this.cube[x][y][z].enqueue(element); // 8 for enqueue usage + 2 for function call and index
	}
	
	/**
	 * Creates an iterator object to get what is at the head of the TraverableQueue then
	 * returns that object.
	 * 
	 * Run-Time Efficiency:
	 * In this method there are 3 assignment operations, 2 function calls and a return. From
	 * the documentation in TraversableQueue it can be seen that iterator() and next() work
	 * in constant time. Since there are only constant primitive operations added to those 
	 * methods within this get method it can be said that,
	 * f(n) == c*g(n) where c is a constant value so this method has a big-o of:
	 * 
	 * O(1)
	 * 
	 * @param x index 1 of the cube.
	 * @param y index 2 of the cube.
	 * @param z index 3 of the cube.
	 * @throws IndexOutOfBoundsException occurs if an index is given that isn't valid for this
	 * 		cube.
	 */
	@Override
	public T get(int x, int y, int z) throws IndexOutOfBoundsException {
		T oldestItem = null; // 1
		if (this.cube[x][y][z] != null) { // 2
			Iterator<T> cubeIterator =  this.cube[x][y][z].iterator(); //3 creates iterator
			oldestItem = cubeIterator.next(); // 2
		}
		return oldestItem; // 1
	}
	
	/**
	 * Indexes into the cube array and the returns the IterableQueue that is held within
	 * all indexes that are storing a value.
	 * 
	 * Run-Time Complexity:
	 * Since this method only indexes the cube and then returns it the method has a primitive
	 * operation count of 2. So in turn the complexity of this method will be linear since
	 * 2 is a constant value.
	 * 
	 * O(1)
	 * 
	 * @param x index 1 of the cube.
	 * @param y index 2 of the cube.
	 * @param z index 3 of the cube.
	 * @return this.cube[x][y][z] an index into the cube array that holds a IterableQueue<T>
	 * @throws IndexOutOfBoundsException occurs if an index is given that isn't valid for this
	 * 		cube.
	 */
	@Override
	public IterableQueue<T> getAll(int x, int y, int z) throws IndexOutOfBoundsException {
		return this.cube[x][y][z]; // 2
	}
	
	/**
	 * Checks to see if there is multiple <T> stored at a particular index of the cube.
	 * 
	 * Run-Time Efficiency:
	 * In the worse case of this method there will be 5 operation calls plus the size() calls
	 * but that works in constant time so it will not affect the overall run-time. Since
	 * everything is working in constant time the f(n) == c*g(n) where c is a constant 
	 * of the operation count for the method. Since the worst cause is still constant the upper
	 * bound of the method is:
	 * 
	 * O(1)
	 * 
	 * @param x index 1 of the cube.
	 * @param y index 2 of the cube.
	 * @param z index 3 of the cube.
	 * @return true if multiple things at the index, false otherwise.
	 * @throws IndexOutOfBoundsException occurs if an index is given that isn't valid for this
	 * 		cube.
	 */
	@Override
	public boolean isMultipleElementsAt(int x, int y, int z) throws IndexOutOfBoundsException {
		if (this.cube[x][y][z] == null) { // 2  checks to see if queue is here
			return false; // 1
		} else {
			if (this.cube[x][y][z].size() > 1) { // 2 checks to see if more then one thing is stored.
				return true; // 1
			}
			return false; // 1
		}
	}
	
	/**
	 * Dequeues specific element at an index if available.
	 * 
	 * Run-Time Efficiency:
	 * In the worse case of this method call linear growth will occur due to the while loop
	 * in this method. Since there is an unknown amount of elements in an queue the loop
	 * will have to execute n amount of times where n is the unknown. This means for the
	 * upper bound of this method f(n) == n, which in big-o notation is:
	 * 
	 * O(n)
	 * 
	 * @param x index 1 of the cube.
	 * @param y index 2 of the cube.
	 * @param z index 3 of the cube.
	 * @return this.cube[x][y][z] an index into the cube array that holds a IterableQueue<T>
	 * @throws IndexOutOfBoundsException occurs if an index is given that isn't valid for this
	 * 		cube.
	 */
	@Override
	public boolean remove(int x, int y, int z, T element) throws IndexOutOfBoundsException {
		if (this.cube[x][y][z] != null) { // 2 checks for something in the index
			Iterator<T> cubeIterator = cube[x][y][z].iterator(); // 3
			TraversableQueue<T> tempQueue = new TraversableQueue<T>(); //2
			T tempElement;
			while (cubeIterator.hasNext()) { // n searches what is stored at the index
				tempElement = cubeIterator.next(); // 1 + n copies what isn't being removed
				if (tempElement.equals(element)) { // 1 + n element in the index
					continue; // 1 doesn't copy the element to the new queue
				}
				tempQueue.enqueue(tempElement); //1 + n adds elements that aren't being deleted.
			}
			this.cube[x][y][z] = tempQueue; // 2 adds updated queue to the index of the cube.
			return true; // 1
		}
		return false; // 1 
	}
	
	/**
	 * Removes all the elements that are in that index of the cube
	 * 
	 * Run-Time Efficiency:
	 * The method uses 2 primitive operation calls to work, one for index of the array
	 * then one to assign that index of the cube to null. Since 2 is a constant integer value,
	 * it can be said that f(n) == c, where c is the constant value. Also since the method 
	 * has a constant amount of primitive operations the upper bound of this method has to be:
	 * 
	 * O(1)
	 * 
	 * @param x index 1 of the cube.
	 * @param y index 2 of the cube.
	 * @param z index 3 of the cube.
	 * @throws IndexOutOfBoundsException occurs if an index is given that isn't valid for this
	 * 		cube.
	 */
	@Override
	public void removeAll(int x, int y, int z) throws IndexOutOfBoundsException {
		this.cube[x][y][x] = null;
	}
	
	/**
	 * Clears the whole cube so it is holding nothing.
	 * 
	 * Run-Time Efficiency:
	 * For this method the bottle neck occurs in the last line. Linear growth
	 * occurs due to an array being instantiated of a size n. Since this is a 3d array
	 * this happens 3 times. As this is the limiting part of the method, f(n) == n
	 * which signifies that linear growth is occurring and this gives an upper bound of:
	 * 
	 * O(n)
	 */
	@Override
	@SuppressWarnings("unchecked")
	public void clear() {
		this.cube = null; // 1
		this.cube =  new TraversableQueue[this.length][this.breadth][this.height];	// 7 + 3n
	}
	
}

/*
 * The BoundedCube class has some pros to it, but if it was to be designed again there could be some improvements,
 * to help with the run-time and space performance. The pros of this structure are from its O(1) run time on all of
 * its add and remove methods, allowing fast changes within the information. In terms of the OneSky and the use of this
 * advantage, this would make for easy use for tracking things like jets since they will quickly move through different 
 * parts of the airspace, so the ability to move the data quickly is advantageous. Not only does using a 3d array allow for
 * fast information accessing, but it also allows for easy modeling by just being able to define the size of each array
 * and then you have a perfect box for what ever airspace you need to model. This point can also have some cons though because if
 * the array is big enough it slows down the structures set-up time because of how much memory has to be used when making
 * a 3d array. As seen in the Javadoc comment at the start of the class, there is linear memory growth whenever the cube
 * instance variable is made which can make some systems with not a lot of memory struggle to run this structure with lots
 * of information, but it will still work if not a lot of data is used. If BoundedCube was to be designed again, it would be recommended
 * to replace the 3d array with another structure to simulate the cube, for example a binary tree. The advantages of using 
 * a binary tree would mean you don't need to hold every point of the Australian airspace  at all times, you would only 
 * need to store locations that are currently active with aircraft. Doing this would changed the memory usage to O(log(n)) 
 * from linear and give computers with less memory the chance to process lots of data. The only down side to this method would 
 * be losing constant time access to parts of the airspace because you would have to traverse the whole tree to find what parts 
 * of airspace is the structure currently using and then check to see if the correct element is in that location. But if a binary
 * tree was used, binary search algorithms could be used to traverse the tree so access times to elements in airspace would only
 * be going from O(1) to O(log(n)). If the BoundedCube was only tracking commercial planes though, having the decreased access
 * time may not be to noticeable and the increase in performance when it comes to memory will probably far out way the cons of
 * slower access speeds.
 * 
 * References:
 * 		Goodrich, M., Tamassia, R., & Goldwasser, M. (2014). Data structures and 
 * 		algorithms in Java (6th ed., pp. 156-164). Wiley.
 * 		
 * 		Thomas, R. (2018). Analysis Tools. Lecture, University of Queensland.
 */ 
