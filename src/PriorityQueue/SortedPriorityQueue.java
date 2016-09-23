package PriorityQueue;

import java.util.Comparator;

import PositionalList.LinkedPositionalList;
import PositionalList.Position;

/**
 * @author Priyank Agrawal
 * 
 * Date 09/06/2016
 * 
 * Generic priority queue ADT having sorted keys stored in a doubly linked list having positional list ADT
 */
public class SortedPriorityQueue<K,V> extends AbstractPriorityQueue<K,V>  {
	
	//primary collections of priority queue entries
	private LinkedPositionalList<Entry<K,V>> list = new LinkedPositionalList<>();
	
	/**
	 * constructs an empty priority queue with the default comparator of natural ordering of keys 
	 */
	public SortedPriorityQueue(){
		super();
	}
	
	/**
	 * constructs an empty priority queue with the given comparator to order keys
	 */
	public SortedPriorityQueue(Comparator<K> comp){
		super(comp);
	}
	
	
	/**
	 * @return entry created after inserting a key-value pair it it's valid
	 */
	@SuppressWarnings("unused")
	public Entry<K,V> insert(K key, V value) throws IllegalArgumentException{
		checkKey(key);													//check if the key is valid could throw an exception
		Entry<K,V> newest = new PQEntry<>(key, value);					//make it a new entry if key is valid
		Position<Entry<K,V>> walk = list.last();						//scans the list backwards
		while(walk != null & compare(newest, walk.getElement()) < 0)	//newest is smaller than current walk key	
			walk = list.before(walk);				//new walk key is now the key before the current walk 
		if(walk == null)
			list.addFirst(newest);					//new key is the smallest in the list so add it in front of the priority queue
		else
			list.addAfter(walk, newest);			//new key is greater than walk key so it goes after walk
		return newest;		
	}
	
	/**
	 * @return entry with the minimal key but does not remove it
	 */
	public Entry<K,V> min(){
		if(list.isEmpty()) return null;
		return list.first().getElement();
	}
	
	/**
	 * @return entry with the minimal key and removes it
	 */
	public Entry<K,V> removeMin(){
		if(list.isEmpty()) return null;
		return list.remove(list.first());
	}
	
	/**
	 * @return total number of entries in the priority queue
	 */
	public int size(){
		return list.size();
	}

}