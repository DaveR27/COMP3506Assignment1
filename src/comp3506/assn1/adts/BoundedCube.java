package comp3506.assn1.adts;


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
	public TraversableQueue<T> cube[][][];
	
	/**
	 * 
	 * @param length  Maximum size in the 'x' dimension.
	 * @param breadth Maximum size in the 'y' dimension.
	 * @param height  Maximum size in the 'z' dimension.
	 * @throws IllegalArgumentException If provided dimension sizes are not positive.
	 */
	@SuppressWarnings("unchecked")
	public BoundedCube(int length, int breadth, int height) throws IllegalArgumentException {
		if (!this.checkPositiveValues(length, breadth, height)) {
			throw new IllegalArgumentException();
		}
		cube =  (TraversableQueue<T>[][][]) new Object[length][breadth][height];
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
		if (cube[x][y][z] == null) {
			cube[x][y][z] = new TraversableQueue<T>();
		}
		cube[x][y][z].enqueue(element);;
		
	}

	@Override
	public T get(int x, int y, int z) throws IndexOutOfBoundsException {
		return cube[x][y][z].dequeue();
	}

	@Override
	public IterableQueue<T> getAll(int x, int y, int z) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isMultipleElementsAt(int x, int y, int z) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean remove(int x, int y, int z, T element) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void removeAll(int x, int y, int z) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}
	
}
