package PriorityQueue;

/**
 * @author Priyank Agrawal
 * 
 * Date 09/05/2016
 * 
 * Generic priority queue interface
 */
public interface PriorityQueue<K,V> {

	/**
	 * @return total number of entries in the priority queue
	 */
	int size();
	
	/**
	 * tests whether the queue has any entry or not
	 * @return true if queue is empty(false otherwise)
	 */
	boolean isEmpty();
	
	/**
	 * @return inserted entry in the queue
	 */
	Entry<K,V> insert(K key, V value) throws IllegalArgumentException;
	
	/**
	 * @return entry with the minimal key from the queue and does not remove it(null if no entry in the queue)
	 */
	Entry<K,V> min();
	
	/**
	 * @return entry with the minimal key after removing it from the queue(null if no entry in the queue)
	 */
	Entry<K,V> removeMin();

}
