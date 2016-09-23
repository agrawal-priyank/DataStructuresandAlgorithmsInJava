package Tree;

import PositionalList.Position;

/**
 * @author Priyank Agrawal
 * 
 * Date 09/03/2016
 * 
 * Concrete implementation of a Binary Tree using a node based linked list structure
 */
public abstract class LinkedBinaryTree<E> extends AbstractBinaryTree<E> {
	
	//nested node class  
	private static class Node<E> implements Position<E>{
		private E element;							//element stored at the node
		private Node<E> parent;						//reference to parent of the node(if any)
		private Node<E> left;						//reference to left child of the node(if any)
		private Node<E> right;						//reference to right child of the node(if any)
		
		//constructs a node with given element and neighbors
		public Node(E e, Node<E> above, Node<E> leftChild, Node<E> rightChild){
			element = e;
			parent = above;
			left = leftChild;
			right = rightChild;			
		}
		
		//accessor and update methods
		public E getElement() {
			return element;
		}
		public void setElement(E element) {
			this.element = element;
		}
		public Node<E> getParent() {
			return parent;
		}
		public void setParent(Node<E> parent) {
			this.parent = parent;
		}
		public Node<E> getLeft() {
			return left;
		}
		public void setLeft(Node<E> left) {
			this.left = left;
		}
		public Node<E> getRight() {
			return right;
		}
		public void setRight(Node<E> right) {
			this.right = right;
		}	
	 }
	
	
	//Factory function to create a new node with element e and neighbors	
	protected Node<E> createNode(E e, Node<E> parent, Node<E> left, Node<E> right){
		return new Node<E>(e, parent, left, right);
	}
	
	//instance variables of linked binary tree class
	private Node<E> root = null;
	private int size = 0;
	
	//constructs an empty binary tree
	public LinkedBinaryTree(){}
	
	protected Node<E> validate(Position<E> p) throws IllegalArgumentException{
		if(!(p instanceof Node))
			throw new IllegalArgumentException("Not a valid position");
		Node<E> node = (Node<E>) p;
		if(node.getParent() == node)
			throw new IllegalArgumentException("Node no longer in the tree");
		return node;
	}
	
	/**
	 * @return total number of nodes in the tree
	 */
	public int size(){
		return size;
	}
	
	/**
	 * @return position of root node of the tree(or null if tree is empty)	 
	 */
	public Node<E> root(){
		return root;
	}
	
	/**
	 * @return position of parent of node p(or null if p is root)
	 * @throws IllegalStateException if position is not valid or no longer present in the tree
	 */
	public Node<E> parent(Position<E> p) throws IllegalArgumentException{
		Node<E> node = validate(p);
		return node.getParent();
	}
	
	/**
	 * @return position of left child of node p(or null if it does not exists)
	 */
	public Node<E> left(Position<E> p) throws IllegalArgumentException{
		Node<E> node = validate(p);
		return node.getLeft();
	}
	
	/**
	 * @return position of right child of node p(or null if it does not exists)
	 */
	public Node<E> right(Position<E> p) throws IllegalArgumentException{
		Node<E> node = validate(p);
		return node.getRight();
	}
	
	//update methods of linked binary tree class
	/**
	 * @return position of the root node of the tree with element e
	 * @throws IllegalStateException if tree is not empty
	 */
	public Position<E> addRoot(E e) throws IllegalStateException{
		if(!(isEmpty())) throw new IllegalStateException("Tree is not empty");
		root = createNode(e, null, null, null);
		size = 1;
		return root;
	}
	
	/**
	 * @return position of left child node of p after its creation and storing of element e in it
	 * @throws IllegalStateException if left child of p is already present
	 */
	public Position<E> addLeft(Position<E> p, E e) throws IllegalStateException{
		Node<E> parent = validate(p);
		if(parent.getLeft() != null)
			throw new IllegalStateException("Node already has a left child");
		Node<E> child = createNode(e, parent, null, null);
		parent.setLeft(child);
		size++;
		return child;		
	}
	
	/**
	 * @return position of right child node of p after its creation and storing of element e in it
	 * @throws IllegalStateException if right child of p is already present
	 */
	public Position<E> addRight(Position<E> p, E e) throws IllegalStateException{
		Node<E> parent = validate(p);
		if(parent.getRight() != null)
			throw new IllegalStateException("Node already has a right child");
		Node<E> child = createNode(e, parent, null, null);
		parent.setRight(child);
		size++;
		return child;
	}
	
	/**
	 * @return old element of p after replacing it with new element e
	 * @throws IllegalArgumentException if the position p does not exist in the tree
	 */
	public E set(Position<E> p, E e) throws IllegalArgumentException{
		Node<E> node = (Node<E>) p;
		E temp = node.getElement();
		node.setElement(e);
		return temp;
	}
	
	
	/**
	 * attaches subtrees t1 and t2 as child as left and right subtrees of node with position p
	 * @throws IllegalArgumentException if node with position p already has a child node
	 */
	public void attach(Position<E> p, LinkedBinaryTree<E> t1, LinkedBinaryTree<E> t2) throws IllegalArgumentException{
		Node<E> node = validate(p);
		if(isInternal(p)) throw new IllegalArgumentException("p must be a leaf node");
		size += t1.size + t2.size;
		if(!t1.isEmpty()){								//attach t1 as the left subtree
			t1.root.setParent(node);
			node.setLeft(t1.root);
			t1.root = null;
			t1.size = 0;
		}
		if(!t2.isEmpty()){								//attach t2 as the right subtree
			t2.root.setParent(node);
			node.setLeft(t2.root);
			t2.root = null;
			t2.size = 0;
		}		
	}
	
	/**
	 * @return element after removing node with position p from the tree and replaced the removed node with its child node
	 * @throws IllegalArgumentException if no node with position as p exists
	 */
	public E remove(Position<E> p) throws IllegalArgumentException{
		Node<E> node = validate(p);
		if(numChildren(p) == 2)
			throw new IllegalArgumentException("Node has 2 children");
		Node<E> child = (node.getLeft() != null ? node.getLeft() : node.getRight());
		if(child != null)
			child.setParent(node.getParent());			//child's grandparent is now its parent
		if(node == root)
			root = child;								//child becomes the root
		else{											//node is not the root
			Node<E> parent = node.getParent();			
			if(node == parent.getLeft())
				parent.setLeft(child);					//child becomes left child of the grandparent(now its parent)
			else
				parent.setRight(child);					//child becomes right child of the grandparent(now its parent)
		}
		size--;
		E temp = node.getElement();
		node.setElement(null);							//help garbage collection
		node.setLeft(null);
		node.setRight(null);
		node.setParent(node);							//convention for defunct node
		return temp;		
	}
	
}
