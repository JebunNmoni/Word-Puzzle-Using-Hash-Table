package wordPuzzle;

//QuadraticProbing Hash table class

//
//CONSTRUCTION: an approximate initial size or default of 101
//
//******************PUBLIC OPERATIONS*********************
//bool insert( x )       --> Insert x
//bool remove( x )       --> Remove x
//bool contains( x )     --> Return true if x is present
//void doClear( )      --> Remove all items

public class MyHashTable<AnyType> {
	/**
	 * Construct the hash table.
	 */
	public MyHashTable() {
		this(DEFAULT_TABLE_SIZE);
	}

	/**
	 * Construct the hash table.
	 * 
	 * @param size the approximate initial size.
	 */
	public MyHashTable(int size) {
		allocateArray(size);
		doClear();
	}

	/**
	 * Insert into the hash table. If the item is already present, do nothing.
	 * 
	 * @param x the item to insert.
	 */
	public boolean insert(AnyType x) {
		// Insert x as active
		int currentPos = findPos(x);

		if (isActive(currentPos))
			return false;

		if (array[currentPos] == null)
			occupied++;

		array[currentPos] = new HashEntry<>(x);
		theSize++;
		// Rehash; see Section 5.5
		if (occupied > array.length / 2)
			rehash();

		return true;
	}

	/**
	 * Expand the hash table.
	 */

	private void rehash() {
		HashEntry<AnyType> oldArray[] = array;
		// Create a new double-sized, empty table
		allocateArray(2 * oldArray.length);
		occupied = 0;
		theSize = 0;
		// Copy table over
		for (HashEntry<AnyType> entry : oldArray)
			if (entry != null && entry.isActive)
				insert(entry.element);
	}

	/**
	 * Method that performs quadratic probing resolution.
	 * 
	 * @param x the item to search for.
	 * @return the position where the search terminates.
	 */

	private int findPos(AnyType x) {

		int currentPos = myhash(x);
		while (array[currentPos] != null && !array[currentPos].element.equals(x)) {
			currentPos++;
			if (currentPos >= array.length)
				currentPos -= array.length;
		}

		return currentPos;
	}

	/**
	 * Remove from the hash table.
	 * 
	 * @param x the item to remove.
	 * @return true if item removed
	 */

	public boolean remove(AnyType x) {
		int currentPos = findPos(x);

		if (!isActive(currentPos))
			return false;

		array[currentPos].isActive = false;
		theSize--;

		return true;
	}

	/**
	 * Get current size.
	 * 
	 * @return the size.
	 */
	public int size() {
		return theSize;
	}

	/**
	 * Get length of internal table.
	 * 
	 * @return the size.
	 */
	public int capacity() {
		return array.length;
	}

	/**
	 * Find an item in the hash table.
	 * 
	 * @param x the item to search for.
	 * @return the matching item.
	 */

	public boolean contains(AnyType x) {
		int currentPos = findPos(x);

		return isActive(currentPos);
	}

	/**
	 * Return true if currentPos exists and is active.
	 * 
	 * @param currentPos the result of a call to findPos.
	 * @return true if currentPos is active.
	 */
	private boolean isActive(int currentPos) {
		return array[currentPos] != null && array[currentPos].isActive;
	}

	/**
	 * Make the hash table logically empty.
	 */
	public void makeEmpty() {
		doClear();
	}

	public void doClear() {
		for (int i = 0; i < array.length; i++)
			array[i] = null;

		occupied = 0;
	}

	private int myhash(AnyType x) {
		int hashVal = x.hashCode();

		hashVal %= array.length;

		if (hashVal < 0)
			hashVal += array.length;

		return hashVal;
	}

	private static class HashEntry<AnyType> {
		public AnyType element; // the element
		public boolean isActive; // false if marked deleted

		public HashEntry(AnyType x) {
			this(x, true);
		}

		public HashEntry(AnyType x, boolean bool) {
			element = x;
			isActive = bool;
		}
	}

	private static final int DEFAULT_TABLE_SIZE = 101;

	private HashEntry<AnyType>[] array;// The array of elements
	private int occupied; // The number of occupied cells
	private int theSize; // Current size

	/**
	 * Internal method to allocate array.
	 * 
	 * @param arraySize the size of the array.
	 */
	@SuppressWarnings("unchecked")
	private void allocateArray(int arraySize) {
		array = new HashEntry[nextPrime(arraySize)];
	}

	/**
	 * Internal method to find a prime number at least as large as n.
	 * 
	 * @param n the starting number (must be positive).
	 * @return a prime number larger than or equal to n.
	 */

	private static int nextPrime(int n) {
		for (; !isPrime(n); n++)
			;

		return n;
	}

	private static boolean isPrime(int n) {
		if (n == 1)
			return true;

		for (int i = 2; i * i <= n; i++)
			if (n % i == 0)
				return false;

		return true;
	}

}
