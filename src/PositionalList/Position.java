package PositionalList;

/**
 * @author Priyank Agrawal
 * 
 * Date 08/28/2016
 * 
 * Generic Position Interface
 */
public interface Position<E> {
	
	/**
	 * @return the stored element at the position
	 * @throws IllegalStateException if position no longer valid
	 */
	E getElement() throws IllegalStateException; 

}
