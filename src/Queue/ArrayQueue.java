package Queue;

/**
 * @author Priyank Agrawal
 * 
 * Date 08/22/2016
 * 
 * Implementation of Queue using fixed-length array
 */
public class ArrayQueue<E> implements Queue<E> {
	
	private E[] data;							//generic array used for storage
	private int f;								//front element index
	private int sz;								//current total number of elements
	private static final int CAPACITY = 1000;	//default array capacity
	
	public ArrayQueue(){						//constructs array with default capacity
		this(CAPACITY);							
	}
	@SuppressWarnings("unchecked")
	public ArrayQueue(int capacity){
		data = (E[]) new Object[capacity];		//safe cast object to array object
	}
	
	public int size(){
		return sz;
	}
	
	public boolean isEmpty(){
		return sz == 0;
	}
	
	public void enqueue(E e) throws IllegalStateException{
		if(sz == data.length) throw new IllegalStateException("Queue is full");
		int avail = (f + sz) % data.length;		//uses modulo operator to insert element at right index
		data[avail] = e;
		sz++;
	}
	
	public E first(){
		if(isEmpty()) return null;
		return data[f];
	}
	
	public E dequeue(){
		if(isEmpty()) return null;
		E answer = data[f];
		data[f] = null;							//dereference to help garbage collection
		f = (f + 1) % data.length;				//new front index will be the next index or none
		sz--;
		return answer;
	}
	
}
