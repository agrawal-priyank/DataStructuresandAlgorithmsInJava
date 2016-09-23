/**
 * 
 */
package Stack;

/**
 * @author Priyank Agrawal
 * 
 * Date 08/20/2016
 * 
 * Generic Stack ADT Interface - Basic
 */
public interface Stack<E> {
	
	/**
	 * returns the number of element in the stack
	 * @return number of elements in the stack
	 */
	int size();
	
	/**
	 * tests whether the stack is empty
	 * @return true if the stack is empty (or false otherwise)
	 */
	boolean isEmpty();
	
	/**
	 * inserts the element at the top of the stack
	 * @param e the element to be inserted
	 */
	void push(E e);
	
	/**
	 * returns top element from the stack but does not remove it
	 * @return top element from the stack (or null if empty)
	 */
	E top();
	
	/**
	 * removes and returns the top element from the stack
	 * @return top element removed (or null if empty)
	 */
	E pop();

}
