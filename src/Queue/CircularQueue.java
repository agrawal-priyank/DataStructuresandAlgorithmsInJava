package Queue;

/**
 * @author Priyank Agrawal
 * 
 * Date 08/23/2016
 * 
 *  Implementing a Generic Circular Queue
 */
public interface CircularQueue<E> extends Queue<E> {
	
	/**
	 * rotates the front element of the queue to the back of the queue
	 */
	void rotate();
	
}
