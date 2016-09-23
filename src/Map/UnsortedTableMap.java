package Map;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

import PriorityQueue.Entry;

/**
 * @author Priyank Agrawal
 *
 * Date 09/12/2016
 * 
 * Unsorted map class implementation using an array-list
 */
public class UnsortedTableMap<K,V> extends AbstractMap<K,V> {
	
	//primary storage for all the entries of the map
	private ArrayList<MapEntry<K,V>> table = new ArrayList<>();
	
	//constructs an initially empty map
	public UnsortedTableMap(){ }
	
	/**
	 * private utility
	 * @return index of the key or -1 if no such key found
	 */
	private int findIndex(K key){
		int n = table.size();
		for(int i=0;i<n;i++){
			if(table.get(i).getKey().equals(key))
				return i;
		}
		return -1;
	}
	
	/**
	 * @return total number of entries in the map
	 */
	public int size(){
		return table.size();
	}
	
	/**
	 * @return value associated with the key(null if no such key exists)
	 */
	public V get(K key){
		int j = findIndex(key);
		if(j == -1) return null;
		return table.get(j).getValue();
	}
	
	/**
	 * @return inserts value with the key, if key already present then returns the replaced value 
	 */
	public V put(K key, V value){
		int j = findIndex(key);
		if(j == -1){
			table.add(new MapEntry<K, V>(key, value));
			return null;
		}
		else{
			return table.get(j).setValue(value);
		}
	}
	
	/**
	 * @return value associated with the key after removing it(null if no key)
	 */
	public V remove(K key){
		int j = findIndex(key);
		int n = size();
		if(j == -1) return null;
		V answer = table.get(j).getValue();
		if(j != n - 1)
			table.set(j, table.get(n-1));
		table.remove(n-1);
		return answer;
	}
	
	/**
	 * support for public entrySet method
	 */
	private class EntryIterator implements Iterator<Entry<K,V>>{
		private int j=0;
		public boolean hasNext() {
			return j < table.size();
		}
		public Entry<K,V> next(){
			if(j == table.size()) throw new NoSuchElementException();
			return table.get(j++);
		}
		public void remove(){
			throw new UnsupportedOperationException();
		}
		
	}
	private class EntryIterable implements Iterable<Entry<K,V>>{
		public Iterator<Entry<K,V>> iterator(){
			return new EntryIterator();
		}
	}
	
	/**
	 * @return iterable collection of all the entries of the map
	 */
	public Iterable<Entry<K,V>> entrySet(){
		return new EntryIterable();
	}

}
