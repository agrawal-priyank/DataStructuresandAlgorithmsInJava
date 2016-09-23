package List;

/**
 * @author Priyank Agrawal
 * 
 * Date 08/25/2016
 * 
 * Generic List ADT Interface
 */
public interface List<E> {
	
	/**
	 * @return number of elements in the list
	 */
	int size();
	
	/**
	 * test whether list is empty
	 * @return true if list is empty(false otherwise)
	 */
	boolean isEmpty();
	
	/**
	 * @return the element at index i in the list but does not remove the element
	 * @throws IndexOutOfBoundsException if specified index is not present in list
	 */
	E get(int i) throws IndexOutOfBoundsException;
	
	/**
	 * @return the replaced element after setting new element e at its position an index i in the list
	 */
	E set(int i, E e) throws IndexOutOfBoundsException;
	
	/**
	 * inserts new element e at index i in the list and shifts all subsequent elements later
	 */
	void add(int i, E e) throws IndexOutOfBoundsException;
	
	/**
	 * @return the removed element at index i in the list and shifts subsequent elements earlier
	 */
	E remove(int i)throws IndexOutOfBoundsException;

}
