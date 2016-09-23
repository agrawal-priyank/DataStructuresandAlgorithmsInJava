 package Tree;

import java.util.Iterator;

import PositionalList.Position;

/**
 * @author Priyank Agrawal
 *
 * Date 09/01/2016
 * 
 * Generic Tree ADT interface
 */
public interface Tree<E> extends Iterable<E> {
	
	/**
	 * @return position of root node of the tree
	 */
	Position<E> root();
	
	/**
	 * @return position of parent of node with position p
	 * @throws IllegalArgumentException if no such position p exists
	 */
	Position<E> parent(Position<E> p) throws IllegalArgumentException;
		
	/**
	 * @return iterable list of children(if any) of node with position p
	 */
	Iterable<Position<E>> children(Position<E> p) throws IllegalArgumentException;
	
	/**
	 * @return number of children(if any) of node with position p
	 */
	int numChildren(Position<E> p) throws IllegalArgumentException;
	
	/**
	 * checks whether the node is a leaf
	 * @return true if node is leaf(false otherwise)
	 */
	boolean isExternal(Position<E> p) throws IllegalArgumentException;
	
	/**
	 * checks whether the node is a parent having at least one child node
	 * @return true if node is a parent(false otherwise)
	 */
	boolean isInternal(Position<E> p) throws IllegalArgumentException;
	
	/**
	 * checks whether the node is root node of the tree
	 * @return true if node is parent node(false otherwise)
	 */
	boolean isRoot(Position<E> p) throws IllegalArgumentException;
	
	/**
	 * @return number of elements(nodes) of the tree
	 */
	int size();
	
	/**
	 * checks whether the tree has no elements(nodes)
	 * @return true if tree is empty(false otherwise)
	 */
	boolean isEmpty();
	
	/**
	 * @return an iterator for all elements in the tree
	 */
	Iterator<E> iterator();
	
	/**
	 * 
	 * @return an iterator for all positions of the tree
	 */
	Iterable<Position<E>> positions();

}
