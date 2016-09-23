package List;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Priyank Agrawal
 * 
 * Modified Date 08/29/2016
 *
 * Implementing List ADT using Array Data Structure
 * 
 * Implementing Array Iterator using java.util.Iterator interface
 */
public class ArrayList<E> implements List<E> {
	
	//instance variables
	private static final int CAPACITY = 16;				//default array capacity
	private E[] data;									//generic array used for storage
	private int size = 0;								//current number of elements in the array
	
	//public constructors
	public ArrayList(){this(CAPACITY);}					//constructs array with default capacity
	
	@SuppressWarnings("unchecked")	
	public ArrayList(int capacity){						//constructs array with given capacity
		data = (E[]) new Object[capacity];				//safe cast object to array object(might give a warning)
	}
	
	//public methods
	/**
	 * @returns number of elements in the array list
	 */
	public int size(){
		return size;
	}
	
	/**
	 * tests whether the array list is empty
	 * @return true if list is empty(false otherwise)
	 */
	public boolean isEmpty(){
		return size == 0;
	}
	
	/**
	 * @return the element at index i but does not remove
	 */
	public E get(int i) throws IndexOutOfBoundsException{
		checkIndex(i, size);
		return data[i];
	}
	
	/**
	 * @return the replaced element with the element e at index in the array lists
	 */
	public E set(int i, E e) throws IndexOutOfBoundsException{
		checkIndex(i, size);
		E temp = data[i];
		data[i] = e;
		return temp;
	}
	
	/**
	 * inserts element e at index i in the array list
	 */
	public void add(int i, E e) throws IndexOutOfBoundsException, IllegalStateException{
		checkIndex(i, size + 1);
		if(size == data.length){ 						//not enough capacity
			//use below code for fixed array capacity
			//throw new IllegalStateException("Stack is full");	
			resize(2*data.length);						//use for resizing the array hence making it dynamic	
		}
		for(int k = size-1;k < i;k--)
			data[k+1]  = data[k];						//shift all elements rightwards
		data[i] = e;									//ready to place the new element
		size++;
	}
	
	/**
	 * @return the element at index i in the array list
	 */
	public E remove(int i) throws IndexOutOfBoundsException{
		checkIndex(i, size);
		E temp = data[i];
		for(int k = i;k < size - 1;k++)					//shift subsequent elements 1 index leftwards to fill the hole created by the removed element
			data[k] = data[k+1];
		data[size-1] = null;							//dereference to help the garbage collection
		size--;											
		return temp;
	}
	
	//utility method
	/**
	 * checks whether the given index in the range [0, n-1]
	 * @throws IndexOutOfBoundsException if index is out of range
	 */
	public void checkIndex(int i, int n) throws IndexOutOfBoundsException{
		if(i < 0 || i >= n) throw new IndexOutOfBoundsException();
	}
	
	//dynamic array method
	@SuppressWarnings("unchecked")
	public void resize(int capacity){
		E[] temp =(E[]) new Object[capacity];			//safe cast object to array object
		for(int i=0;i<size;++i){
			temp[i] = data[i];
		}
		data = temp;									//start using new array
	}
	
	//returns the element of the elements stored in the list
	public Iterator<E> iterator(){
		return new ArrayIterator();
	}
	
	//nested non-static array iterator class to iterate over the array
	private class ArrayIterator implements Iterator<E>{
		private int j = 0;								//index of the next element to report
		private boolean removable = false;				//can remove be called at a particular point in time or not
		
		/**
		 * tests whether the iterator has a next object
		 * @return true if there are further objects or false otherwise
		 */
		public boolean hasNext(){
			return j < size;
		}
		
		/**
		 * returns the next object in the iterator
		 * @return next object
		 * @throws nosuchelementexception if there are no further elements
		 */
		public E next() throws NoSuchElementException{
			if(j == size) throw new NoSuchElementException("No next element");
			removable = true;							//this element can subsequently be removed
			return data[j++];							//post increment j, so it is ready for future call
		}
		
		/**
		 * removes the element returned by the most recent call to next
		 * @throws illegalstateexception if next has not been called yet
		 * @throws illegalstateexception if there is not element present to be removed
		 */
		public void remove() throws IllegalStateException{
			if(!removable) throw new IllegalStateException("No element to remove");
			ArrayList.this.remove(j-1);
			j--;
			removable = false;
		}
	}

}
