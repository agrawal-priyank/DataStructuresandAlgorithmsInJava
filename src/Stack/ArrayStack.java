package Stack;

/**
 * @author Priyank Agrawal
 *
 * Date 08/20/2016
 * 
 * Implementation of Stack using an fixed-length Array
 */
public class ArrayStack<E> implements Stack<E> {
	
	private static final int CAPACITY = 1000;	// default array capacity
	private E[] data;							// generic array used for storage
	private int t = -1;							// index of the top element of the stack
	
	public ArrayStack(){						// constructs stack with default capacity
		this(CAPACITY);
	}
	@SuppressWarnings("unchecked")
	public ArrayStack(int capacity){			// constructs stack with given capacity
		data = (E[]) new Object[capacity];		// safe cast object to array object
	}
	
	public int size(){
		return t + 1;
	}
	
	public boolean isEmpty(){
		return t == -1;
	}
	
	public void push(E e) throws IllegalStateException{
		if(size() == data.length) throw new IllegalStateException("Stack is full");
		data[++t] = e;		//increment t before storing new item
	}
	
	public E top(){
		if(isEmpty()) return null;
		return data[t];
	}
	
	public E pop(){
		if(isEmpty()) return null;
		E answer = data[t];
		data[t] = null;		//dereference to help garbage collection
		t--;
		return answer;
	}

}
