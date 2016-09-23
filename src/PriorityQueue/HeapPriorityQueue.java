package PriorityQueue;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * @author Priyank Agrawal
 * 
 * Date 09/06/2016
 * 
 * Generic priority queue ADT implemented using an array based Heap having a structure like complete binary tree structure
 */
public class HeapPriorityQueue<K,V> extends AbstractPriorityQueue<K,V> {
	
	/**
	 * primary collection of priority queue entries 
	 */
	protected ArrayList<Entry<K,V>> heap = new ArrayList<>();
	
	/**
	 * constructs an empty priority queue with the default comparator having natural ordering for keys 
	 */
	public HeapPriorityQueue(){
		super();
	}
	
	/** 
	 * constructs an empty primary queue with the given comparator to order keys
	 */
	public HeapPriorityQueue(Comparator<K> comp){
		super(comp);
	}
	
	/**
	 * @return position of the parent of the position j(if not root)
	 */
	public int parent(int j){
		return (j-1)/2;
	}
	
	/**
	 * @return position of the left child of the position j(if any)
	 */
	public int left(int j){
		return 2*j+1;
	}
	
	/**
	 * @return position of the right child of the position j(if any)
	 */
	public int right(int j){
		return 2*j+2;
	}
	
	public boolean hasLeft(int j){
		return left(j) < heap.size();
	}
	
	public boolean hasRight(int j){
		return right(j) < heap.size();
	}
	
	/**
	 * exchange of the both the entries residing at i and j
	 */
	protected void swap(int i, int j){
		Entry<K,V> temp = heap.get(i);
		heap.set(i, heap.get(j));
		heap.set(j, temp);
	}
	
	/**
	 * moves the entry at index j higher to restore and maintain the heap order property
	 */
	protected void upheap(int j){
		while(j > 0){								//continue until reaching root
			int p = parent(j);						
			if(compare(heap.get(j), heap.get(p)) >= 0) break;
			swap(j, p);
			j = p;
		}
	}
	
	/**
	 * moves the entry at index j lower, if necessary, to restore and maintain the heap order property
	 */
	public void downheap(int j){
		while(hasLeft(j)){
			int leftIndex = left(j);
			int smallChildIndex = leftIndex;			//left child has small key
			if(hasRight(j)){
				int rightIndex = right(j);			
				if(compare(heap.get(leftIndex), heap.get(rightIndex)) >= 0)
					smallChildIndex = rightIndex;		//right child has smaller key or index then the left child
			}
			if(compare(heap.get(smallChildIndex), heap.get(j)) >= 0)
				break;
			swap(j, smallChildIndex);					//heap property restored
			j = smallChildIndex;						//continue at position of the child
		}			
	}
	
	/**
	 * @return total number of entries in the heap based priority queue
	 */
	public int size(){
		return heap.size();
	}
	
	/**
	 * @return entry with minimal key but does not remove it
	 */
	public Entry<K,V> min(){
		if(heap.isEmpty()) return null;
		return heap.get(0);
	}
	
	/**
	 * @return a new entry storing the key-value pairs
	 */
	public Entry<K,V> insert(K key, V value) throws IllegalArgumentException{
		checkKey(key);								//check if the key is valid and could throw an exception
		Entry<K,V> newest = new PQEntry<>(key, value);
		heap.add(newest);							//add entry into the heap
		upheap(heap.size() - 1);					//upheap newly added entry
		return newest;
	}
	
	/**
	 * @return entry with the minimal key and removes it from the heap
	 */
	public Entry<K,V> removeMin(){
		if(heap.isEmpty()) return null;
		Entry<K,V> answer = heap.get(0);
		swap(0, heap.size() - 1);						//put minimum key at the end
		heap.remove(heap.size() - 1);					//remove the minimum key entry from the heap
		downheap(0);									//fix new root
		return answer;
	}

}
