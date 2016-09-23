package Tree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import PositionalList.Position;
import Queue.LinkedQueue;

/**
 * @author Priyank Agrawal
 *
 * Date 09/01/2016
 * 
 * Abstract base class for Tree interface giving some concrete method definitions/functionality
 */
public abstract class AbstractTree<E> implements Tree<E> {
	
	public boolean isExternal(Position<E> p){
		return numChildren(p) == 0;
	}
	
	public boolean isInternal(Position<E> p){
		return numChildren(p) > 0;
	}
	
	public boolean Root(Position<E> p){
		return p == root();
	}
	
	public boolean isEmpty(){
		return size() == 0;	
	}
	
	/**
	 * recursive approach
	  * @return the number of levels from the node with position p to the root node
	 */
	public int depth(Position<E> p){
		if(isRoot(p))
			return 0;
		else
			return 1 + depth(parent(p));
	}
	
	/**
	 * @return height of the tree
	 */
	@SuppressWarnings("unused")
	private int heightBad(){					//named as bad height because it has quadratic worst case time
		int h = 0;
		for(Position<E> p : positions())
			if(isExternal(p))					//only consider leaf node
				h = Math.max(h, depth(p));
		return h;
	}
	
	/**
	 * @return height of the subtree with root p
	 */
	public int height(Position<E> p){
		int h = 0;
		for(Position<E> c : children(p))
			h = Math.max(h, 1 + height(c));
		return h;
	}
	
	/**
	 * adds all the positions of the subtree rooted at position p to the given snapshot
	 */
	private void preorderSubtree(Position<E> p, List<Position<E>> snapshot){
		snapshot.add(p);
		for(Position<E> c : children(p))
			preorderSubtree(c, snapshot);
	}
	
	/**
	 * @return iterable collection of positions of the tree in a pre-order traversal fashion
	 */
	public Iterable<Position<E>> preorder(){
		List<Position<E>> snapshot = new ArrayList<>();
		if(!isEmpty())
			preorderSubtree(root(), snapshot);
		return snapshot;
	}
	
	/**
	 * adds all the positions of the subtree rooted at position p to the given snapshot
	 */
	private void postorderSubtree(Position<E> p, List<Position<E>> snapshot){
		for(Position<E> c : children(p))
			postorderSubtree(c, snapshot);
		snapshot.add(p);
	}
	
	/**
	 * @return iterable collection of positions of the tree reported in post-order traversal fashion
	 */
	public Iterable<Position<E>> postorder(){
		List<Position<E>> snapshot = new ArrayList<>();
		if(!isEmpty())
			postorderSubtree(root(), snapshot);
		return snapshot;
	}
	
	/**
	 * @return iterable collection of positions of the tree reported in breadth-first order traversal fashion
	 */
	public Iterable<Position<E>> breadthfirst(){
		List<Position<E>> snapshot = new ArrayList<>();
		if(!isEmpty()){
			LinkedQueue<Position<E>> fringe = new LinkedQueue<>();
			fringe.enqueue(root());							//start with the root
			while(!fringe.isEmpty()){						
				Position<E> p = fringe.dequeue();			//remove from the front of the queue
				snapshot.add(p);							//report this position
				for(Position<E> c : children(p))			//add children back to the queue
					fringe.enqueue(c);
			}
		}
		return snapshot;
	}
	
	//nested element iterator class
	private class ElementIterator implements Iterator<E>{
		Iterator<Position<E>> posIterator = positions().iterator();
		public boolean hasNext(){
			return posIterator.hasNext();
		}
		public E next(){
			return posIterator.next().getElement();
		}
		public void remove(){
			posIterator.remove();
		}
	}
	
	//returns an iterator as an element iterator
	public Iterator<E> iterator(){
		return new ElementIterator();
	}
	
	//makes pre-order method default for general tree
	public Iterable<Position<E>> positions(){
		return preorder();
	}
	
}
