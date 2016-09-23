package Map;

import PriorityQueue.Entry;

/**
 * @author Priyank Agrawal
 * 
 * Date 09/11/2016
 * 
 * Generic Map ADT interface
 */
public interface Map<K,V> {
	
	/**
	 * @return total number of entries in the map
	 */
	int size();
	
	/**
	 * @return true if map is empty(false otherwise)
	 */
	boolean isEmpty();
	
	/**
	 * @return value associated with the key(null if key not present)
	 */
	V get(K key);
	
	/**
	 * @return inserts the value if no key is present or replaces the existing value with new one and returns old value
	 */
	V put(K key, V value);
	
	/**
	 * @return value associated with key after removing corresponding entry
	 */
	V remove(K key);
	
	/**
	 * @return iterable collection containing all keys stored in the map
	 */
	Iterable<K> keySet();
	
	/**
	 * @return iterable collection containing all values stored in the map
	 */
	Iterable<V> values();
	
	/**
	 * @return iterable collection containing all entries in the map
	 */
	Iterable<Entry <K,V>> entrySet();

}
