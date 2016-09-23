package PriorityQueue;

import java.util.Comparator;

import PositionalList.LinkedPositionalList;
import PositionalList.Position;

/**
 * @author Priyank Agrawal
 * 
 * Date 09/05/2016
 * 
 * Generic priority queue ADT having unsorted keys stored in a doubly linked list having positional list ADT
 */
public class UnsortedPriorityQueue<K,V> extends AbstractPriorityQueue<K,V> {
	
	//primary collection of priority queue entries
	private LinkedPositionalList<Entry<K,V>> list = new LinkedPositionalList<>();
	
	//constructs an empty priority queue with natural ordering of keys and method definition as in the parent class 
	public UnsortedPriorityQueue(){
		super();
	}
	
	//constructs an empty priority queue with given comparator and method definition as in the parent class
	public UnsortedPriorityQueue(Comparator<K> comp){
		super(comp);
	}
	
	/**
	 * @return position of the entry with the minimal key in the priority queue
	 */
	private Position<Entry<K,V>> findMin(){
		Position<Entry<K,V>> small = list.first();			//first entry has minimal key
		/*for(Position<Entry<K,V>> walk : list){				//iterate through all the entries present in the list
			if(compare(walk.getElement(), small.getElement()) < 0)
				small = walk;								//found an entry with a smaller key
		}*/
		return small;
	}
	
	/**
	 * @return entry after inserting the key-value pair
	 */
	public Entry<K,V> insert(K key, V value) throws IllegalArgumentException{
		checkKey(key);										//check if the key is valid and could throw exception
		Entry<K,V> newest = new PQEntry<>(key, value);		//create an entry
		list.addLast(newest);								//add entry to the list
		return newest;
	}
	
	/**
	 * @return entry with the minimal key but does not remove it
	 */
	public Entry<K,V> min(){
		if(list.isEmpty()) return null;						//if no entry present in the list
		return findMin().getElement();
	}
	
	/**
	 * @return entry with the minimal key and removes it
	 */
	public Entry<K,V> removeMin(){
		if(list.isEmpty()) return null;
		return list.remove(findMin());
	}
	
	/**
	 * @return total number of entries in the priority queue
	 */
	public int size(){
		return list.size();
	}
	
}
