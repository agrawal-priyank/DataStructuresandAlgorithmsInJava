package Map;

import java.util.Iterator;
import PriorityQueue.Entry;

/**
 * @author Priyank Agrawal
 * 
 * Date 09/11/2016
 *
 * Abstract Base class implementation of the Map interface which is unsorted
 */
public abstract class AbstractMap<K,V> implements Map<K,V> {
	
	//nested MapEntry class
	protected static class MapEntry<K,V> implements Entry<K,V>{
		private K k;
		private V v;
		public MapEntry(K key, V value){
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
		public V setValue(V value) {					
			V old = v;
			v = value;
			return old;
		}		
	}
	
	/**
	 * @return true if size is empty(false otherwise)
	 */
	public boolean isEmpty(){
		return size() == 0;
	}
	
	//support for public keySet method of map interface
	private class KeyIterator implements Iterator<K>{
		private Iterator<Entry<K,V>> entries = entrySet().iterator();
		public boolean hasNext(){
			return entries.hasNext();
		}
		public K next(){
			return entries.next().getKey();
		}
		public void remove(){
			throw new UnsupportedOperationException();
		}	
	}
	private class KeyIterable implements Iterable<K>{
		public Iterator<K> iterator(){
			return new KeyIterator();
		}
	}
	/**
	 * @return iterable collection of all the keys of the map
	 */
	public Iterable<K> keySet(){
		return new KeyIterable();
	}
	//support ends
	
	//support for public values method of map interface
	private class ValueIterator implements Iterator<V>{
		private Iterator<Entry<K,V>> entries = entrySet().iterator();
		public boolean hasNext(){
			return entries.hasNext();
		}
		public V next(){
			return entries.next().getValue();
		}
		public void remove(){
			throw new UnsupportedOperationException();
		}
	}	
	private class ValueIterable implements Iterable<V>{
		public Iterator<V> iterator(){
			return new ValueIterator();
		}
	}
	/**
	 * @return iterable collection of all values of the map
	 */
	public Iterable<V> values(){
		return new ValueIterable();
	}
	//support ends

}
