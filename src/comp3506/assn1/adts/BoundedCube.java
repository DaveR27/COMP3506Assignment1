package comp3506.assn1.adts;

import java.util.Iterator;

/**
 * A three-dimensional data structure that holds items in a positional relationship to each other.
 * Each cell in the data structure can hold multiple items.
 * A bounded cube has a specified maximum size in each dimension.
 * The root of each dimension is indexed from zero.
 * 
 * @author 
 *
 * @param <T> The type of element held in the data structure.
 */
public class BoundedCube<T> implements Cube<T> {
	private TraversableQueue<T> cube[][][];
	private int length;
	private int breadth;
	private int height;
	
	/**
	 * 
	 * @param length  Maximum size in the 'x' dimension.
	 * @param breadth Maximum size in the 'y' dimension.
	 * @param height  Maximum size in the 'z' dimension.
	 * @throws IllegalArgumentException If provided dimension sizes are not positive.
	 */
	@SuppressWarnings("unchecked")
	public BoundedCube(int length, int breadth, int height) throws IllegalArgumentException {
		if (!(this.checkPositiveValues(length, breadth, height))) {
			throw new IllegalArgumentException();
		}
		this.length = length;
		this.height = height;
		this.breadth = breadth;
		this.cube = new TraversableQueue[this.length][this.breadth][this.height];
	}
	
	/**
	 * Checks that positive numbers are entered into the constructor.
	 * 
	 * @param length: length of cube.
	 * @param breadth: breadth of cube.
	 * @param height: height of cube.
	 * @return true if all the entered int's are positive, otherwise false.
	 */
	private boolean checkPositiveValues(int length, int breadth, int height) {
		if (length > 0 && breadth > 0 && height > 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void add(int x, int y, int z, T element) throws IndexOutOfBoundsException {
		if (this.cube[x][y][z] == null) {
			this.cube[x][y][z] = new TraversableQueue<T>();
		}
		this.cube[x][y][z].enqueue(element);;
		
	}

	@Override
	public T get(int x, int y, int z) throws IndexOutOfBoundsException {
		Iterator<T> cubeIterator =  this.cube[x][y][z].iterator();
		T oldestItem = cubeIterator.next();
		cubeIterator = null;
		return oldestItem;
	}

	@Override
	public IterableQueue<T> getAll(int x, int y, int z) throws IndexOutOfBoundsException {
		return this.cube[x][y][z];
	}

	@Override
	public boolean isMultipleElementsAt(int x, int y, int z) throws IndexOutOfBoundsException {
		if (this.cube[x][y][z].size() > 1) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean remove(int x, int y, int z, T element) throws IndexOutOfBoundsException {
		if (this.cube[x][y][z] != null) {
			Iterator<T> cubeIterator = cube[x][y][z].iterator();
			TraversableQueue<T> tempQueue = new TraversableQueue<T>();
			T tempElement;
			while (cubeIterator.hasNext()) {
				tempElement = cubeIterator.next();
				if (tempElement.equals(element)) {
					continue;
				}
				tempQueue.enqueue(tempElement);
			}
			this.cube[x][y][z] = tempQueue;
			return true;
		}
		return false;
	}

	@Override
	public void removeAll(int x, int y, int z) throws IndexOutOfBoundsException {
		this.cube[x][y][x] = null;
		
	}

	@Override
	@SuppressWarnings("unchecked")
	public void clear() {
		this.cube = null;
		this.cube = (TraversableQueue[][][]) new Object[this.length][this.breadth][this.height];	
	}
	
}
