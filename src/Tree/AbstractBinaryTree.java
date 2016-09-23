package Tree;

import java.util.ArrayList;
import java.util.List;

import PositionalList.Position;

/**
 * @author Priyank Agrawal
 *
 * Date 09/02/2016
 * 
 * Abstract binary tree class giving some concrete method implementations of the binary tree interface
 */
public abstract class AbstractBinaryTree<E> extends AbstractTree<E> implements BinaryTree<E> {
	
	
	/**
	 * @return position of p's sibling(null if no sibling exists)
	 */
	public Position<E> sibling(Position<E> p){
		Position<E> parent = parent(p);
		if(parent == null)								//p must be root node
			return null;	
		if(p == left(parent))							//p is a left child
			return right(parent);						//right child might be null
		else											//p is a right child
			return left(parent);						//left child might be null
	}
	
	/**
	 * @return total number of children of p(null if no child exists and max children binary tree can have is 2)
	 */
	public int numChildren(Position<E> p){
		int count = 0;
		if(left(p) != null)
			count++;
		if(right(p) != null)
			count++;
		return count;
	}
	
	/**
	 * @return iterable collection of positions of children of node with position p(null if p has no child)
	 */
	public Iterable<Position<E>> children(Position<E> p){
		ArrayList<Position<E>> snapshot = new ArrayList<>(2);	//max capacity is 2
		if(left(p) != null)
			snapshot.add(left(p));
		if(right(p) != null)
			snapshot.add(right(p));
		return snapshot;
	}
	
	private void inorderSubtree(Position<E> p, List<Position<E>> snapshot){
		if(left(p) != null)
			inorderSubtree(left(p), snapshot);
		snapshot.add(p);
		if(right(p) != null)
			inorderSubtree(right(p), snapshot);						
	}
	
	public Iterable<Position<E>> inorder(){
		List<Position<E>> snapshot = new ArrayList<>();
		if(!isEmpty())
			inorderSubtree(root(), snapshot);
		return snapshot;
	}
	
	public Iterable<Position<E>> positions(){
		return inorder();
	}
	
}
