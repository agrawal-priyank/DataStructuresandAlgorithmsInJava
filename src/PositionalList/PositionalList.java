package PositionalList;

/**
 * @author Priyank Agrawal
 * 
 * Date 08/28/2016
 * 
 * Generic Interface of Positional List ADT
 */
public interface PositionalList<E> {
	
	/**
	 * @return number of elements in the list
	 */
	int size();
	
	/**
	 * tests whether the list is empty
	 * @return true if empty(false otherwise)
	 */
	boolean isEmpty();
	
	/**
	 * @return first position in the list(null if empty)
	 */
	Position<E> first();
	
	/**
	 * @return last position in the list(null if empty)
	 */
	Position<E> last();
	
	/**
	 * @return position immediately before position p(or null if p is first) 
	 * @throws IllegalArgumentException if there is no such position p
	 */
	Position<E> before(Position<E> p) throws IllegalArgumentException;
	
	/**
	 * @return position immediately after position p(or null if p is last)
	 * @throws IllegalArgumentException if there is no such position p
	 */
	Position<E> after(Position<E> p) throws IllegalArgumentException;
	
	/**
	 * @return new position p after inserting element e at front of the list
	 */
	Position<E> addFirst(E e);
	
	/**
	 * @return new position after inserting element e at back of the list
	 */
	Position<E> addLast(E e);
	
	/**
	 * @return new position after inserting element e immediately before position p in the list
	 */
	Position<E> addBefore(Position<E> p, E e) throws IllegalArgumentException;
	
	/**
	 * @return new position after inserting element e immediately after position p in the list
	 */
	Position<E> addAfter(Position<E> p, E e) throws IllegalArgumentException;
	
	/**
	 * @return element that is replaced by element e at position p in the list
	 */
	E set(Position<E> p, E e) throws IllegalArgumentException;
	
	/**
	 * @return the removed element from position p and invalidates p from the list
	 */
	E remove(Position<E> p) throws IllegalArgumentException;

}
