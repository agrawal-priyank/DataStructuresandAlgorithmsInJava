package PriorityQueue;

import java.util.Comparator;

/**
 * @author Priyank Agrawal
 * 
 * Date 09/05/2016
 * 
 * An abstract base class of priority queue implementing the priority queue interface and
 * some of its method definitions
 */
public abstract class AbstractPriorityQueue<K,V> implements PriorityQueue<K,V> {
	
	//nested entry class
	protected static class PQEntry<K,V> implements Entry<K,V>{
		private K k;	//key
		private V v;	//value
		
		public PQEntry(K key, V value){
			k = key;
			v = value;
		}

		public K getKey() {
			return k;
		}
		public void setKey(K k) {
			this.k = k;
		}
		public V getValue() {
			return v;
		}
		public void setValue(V v) {
			this.v = v;
		}				
	}
	
	//instance variable of the class and the comparator defining the ordering of keys in the queue
	private Comparator<K> comp;
	
	//constructs an empty priority queue with the given comparator to order the keys
	protected AbstractPriorityQueue(Comparator<K> c){
		comp = c;
	}
	
	//constructs an empty priority queue with the default comparator based on natural ordering of the keys
	protected AbstractPriorityQueue(){
		this(new DefaultComparator<K>());
	}
	
	//method to compare two entries with the help of their keys
	protected int compare(Entry<K,V> a, Entry<K,V> b){
		return comp.compare(a.getKey(), b.getKey());
	}
	
	//determines whether a key is valid
	protected boolean checkKey(K key) throws IllegalArgumentException{
		try{
			return (comp.compare(key, key) == 0);			//comparing a key against itself
		}catch(ClassCastException e){
			throw new IllegalArgumentException("Incompatible key");
		}
	}
	
	/**
	 * @return true if size of the queue is zero(false otherwise)
	 */
	public boolean isEmpty(){
		return size() == 0;
	}

}
