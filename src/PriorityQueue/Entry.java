package PriorityQueue;

/**
 * @author Priyank Agrawal
 *
 * Date 09/05/2016
 * 
 * Generic key-value pair interface for the priority queue
 */
public interface Entry<K,V> {
	
	K getKey();				//returns the key stored in this entry
	V getValue();			//returns the value stored in this entry
	
}
