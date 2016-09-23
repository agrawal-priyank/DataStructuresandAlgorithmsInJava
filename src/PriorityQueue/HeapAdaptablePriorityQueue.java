package PriorityQueue;

import java.util.Comparator;

/**
 * @author Priyank Agrawal
 * 
 * Date 09/08/2016
 */
public class HeapAdaptablePriorityQueue<K,V> extends HeapPriorityQueue<K,V> {
	
	//nested AdaptablePQEntry class
	//extends the PQEntry class to include all of its information
	protected static class AdaptablePQEntry<K,V> extends PQEntry<K,V>{
		private int index;								//entry's current index in the array
		public AdaptablePQEntry(K key, V value, int i){
			super(key, value);							//this sets the key and value of the entry
			index = i;									//this sets the index of the entry
		}
		public int getIndex() {
			return index;
		}
		public void setIndex(int index) {
			this.index = index;
		}		
	}
	
	/**
	 * creates empty adaptable priority queue using natural order of keys
	 */
	public HeapAdaptablePriorityQueue(){
		super();
	}
		
	/**
	 * created empty adaptable priority queue using given comparator to order the keys
	 */
	public HeapAdaptablePriorityQueue(Comparator<K> comp){
		super(comp);
	}
	
	//protected utilities
	/**
	 * @return entry after validating it that it is actually location aware
	 * @throws IllegalArgumentException if the entry does not exist in the priority queue
	 */
	protected AdaptablePQEntry<K,V> validate(Entry<K,V> entry) throws IllegalArgumentException{
		if(!(entry instanceof AdaptablePQEntry))
			throw new IllegalArgumentException("Invalid entry");
		AdaptablePQEntry<K,V> locator = (AdaptablePQEntry<K,V>)entry;		//safe casting from object to nested class object
		int location = locator.getIndex();
		if(location >= heap.size() || heap.get(location) != locator)
			throw new IllegalArgumentException("Invalid entry");
		return locator;
	}
	
	/**
	 * swaps both the entries along with their indexes
	 */
	protected void swap(int i, int j){
		super.swap(i, j);									//perform the swap
		((AdaptablePQEntry<K,V>)heap.get(i)).setIndex(j);	//reset entry's index
		((AdaptablePQEntry<K,V>)heap.get(j)).setIndex(i);	//reset entry's index
	}
	
	/**
	 * restores the heap relational property by moving the entry at index j either upwards and downwards
	 */
	protected void bubble(int j){
		if(j > 0 && compare(heap.get(j), heap.get(parent(j))) < 0)
			upheap(j);
		else
			downheap(j);
	}
	
	/**
	 * swaps both the entries along with their indexes
	 */
	public Entry<K,V> insert(K key, V value) throws IllegalArgumentException{
		checkKey(key);
		PQEntry<K,V> newest = new AdaptablePQEntry<>(key, value,heap.size());
		heap.add(newest);								//add entry to the last of the priority queue
		upheap(heap.size()-1);							//upheap new added entry
		return newest;
	}
	
	/**
	 * removes the given entry from the priority queue
	 */
	public void remove(Entry<K,V> entry) throws IllegalArgumentException{
		AdaptablePQEntry<K,V> locator = validate(entry);
		int location = locator.getIndex();			
		if(location == heap.size() - 1)				//entry is at last position
			heap.remove(heap.size() - 1);			//just remove it
		else{										//entry is not in last position
			swap(location,heap.size() - 1);			//swap entry to last position
			heap.remove(heap.size() - 1);			//remove it
			bubble(location);						//fix displaced entry
		}
	}
	
	/**
	 * replaces the key of an entry in queue with the new key
	 */
	public void replaceKey(Entry<K,V> entry, K key) throws IllegalArgumentException{
		AdaptablePQEntry<K,V> locator = validate(entry);
		checkKey(key);		
		locator.setKey(key);
		bubble(locator.getIndex());					//with new key may need to move entry
	}
	
	/**
	 * replaces the value of an entry in queue with the new value
	 */
	public void replaceValue(Entry<K,V> entry, V value) throws IllegalArgumentException{
		AdaptablePQEntry<K,V> locator = validate(entry);
		locator.setValue(value);
	}
		
}
