package Deque;

/**
 * @author Priyank Agrawal
 * 
 * Date 08/24/2016
 * 
 * Generic Deque ADT Interface also known as Double Ended Queue
 */
public interface Deque<E> {
	
	/**
	 * @return number of elements in the deque
	 */
	int size();
	
	/**
	 * Tests whether the deque is empty
	 * @return true if empty(otherwise false)
	 */
	boolean isEmpty();
	
	/**
	 * @return first element of the deque and does not remove it(null if empty)
	 */
	E first();
	
	/**
	 * @return last element of the deque and does not remove it(null if empty)
	 */
	E last();
	
	/**
	 * inserts element at the front of the deque
	 */
	void addFirst();
	
	/**
	 * insert element at the back of the deque
	 */
	void addLast();
	
	/**
	 * @return front element of the deque and removes it(null if empty)
	 */
	E removeFirst();
	
	/**
	 * @return last element of the deque and removes it(null if empty)
	 */
	E removeLast();

}
