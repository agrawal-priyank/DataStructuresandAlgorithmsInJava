package Queue;

/**
 * @author Priyank Agrawal
 * 
 * Date 08/22/2016
 * 
 * Generic Queue ADT Interface - Basic
 */
public interface Queue<E> {
	
	/**
	 * @return the number of elements in the queue
	 */
	int size();
	
	/**
	 * tests whether the queue is empty
	 * @return true if queue is empty (false otherwise)
	 */
	boolean isEmpty();
	
	/**
	 * inserts new element in the queue
	 * @param e the element to be inserted
	 */
	void enqueue(E e);
	
	/**
	 * @return the first element of the queue and does not remove it (null if empty)
	 */
	E first();
	
	/**
	 * @return the first element from the queue and removes it (null if empty)
	 */
	E dequeue();

}
