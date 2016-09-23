package Tree;

import PositionalList.Position;

/**
 * @author Priyank Agrawal
 *
 * Date 09/02/2016
 * 
 * Generic Binary tree interface
 */
public interface BinaryTree<E> extends Tree<E> {
	
	/**
	 * @return position of left child node of p(null if it does not exists)
	 * @throws IllegalArgumentException if no such position p exists in the tree
	 */
	Position<E> left(Position<E> p) throws IllegalArgumentException;
	
	/**
	 * @return position of right child node of p(null if it does not exists)
	 */
	Position<E> right(Position<E> p) throws IllegalArgumentException;
	
	/**
	 * @return position of sibling node of p(or null if sibling does not exists)
	 */
	Position<E> sibling(Position<E> p) throws IllegalArgumentException;

}
