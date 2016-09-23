package PositionalList;

/**
 * @author Priyank Agrawal
 *
 * Date 08/28/2016
 * 
 * Implementing Positional List ADT using Doubly Linked List
 */
public class LinkedPositionalList<E> implements PositionalList<E> {
	
	//nested node class
	private static class Node<E> implements Position<E>{
		private E element;						//reference to the element stored at this node
		private Node<E> prev;					//reference to the previous node in the list
		private Node<E> next;					//reference to the next node in the list
		
		public Node(E e, Node<E> p, Node<E> n){
			element = e;
			prev = p;
			next = n;
		}
		
		public Node<E> getPrev() {
			return prev;
		}

		public void setPrev(Node<E> prev) {
			this.prev = prev;
		}

		public Node<E> getNext() {
			return next;
		}

		public void setNext(Node<E> next) {
			this.next = next;
		}

		public E getElement() throws IllegalStateException{
			if(next==null)
				throw new IllegalStateException("Position no longer valid");
			return element;
		}
		
		public void setElement(E element) {
			this.element = element;
		}
	}
	
	//instance variables
	private Node<E> header;						//header sentinel
	private Node<E> trailer;					//trailer sentinel
	private int size = 0;						//number of elements in the list
	
	//constructs an empty positional list
	public LinkedPositionalList(){
		header = new Node<>(null, null, null);
		trailer = new Node<>(null, header, null);
		header.setNext(trailer);
	}
	
	//private utility method
	//validates the position p and returns its corresponding node
	private Node<E> validate(Position<E> p) throws IllegalArgumentException{
		if(!(p instanceof Node)) throw new IllegalArgumentException("Invalid position");
		Node<E> node = (Node<E>)p;
		if(node.getNext() == null)
			throw new IllegalArgumentException("p is no longer in the list");
		return node;		
	}
	
	//returns the given node as a position (otherwise null if node is a sentinel)
	private Position<E> position(Node<E> node){
		if(node == header || node == trailer)
			return null;
		return node;
	}
	
	//public accessor methods
	//returns the number of elements in the list
	public int size(){
		return size;
	}
	
	//checks whether the list is empty
	public boolean isEmpty(){
		return size == 0;
	}
	
	//returns the first position of the list(otherwise null if empty)
	public Position<E> first(){
		return position(header.getNext());
	}
	
	//returns the last position of the list(otherwise null if empty)
	public Position<E> last(){
		return position(trailer.getPrev());
	}
	
	//returns the position before the position p in the list
	public Position<E> before(Position<E> p) throws IllegalArgumentException{
		Node<E> node = validate(p);
		return position(node.getPrev());
	}
	
	//returns the position after the position p in the list
	public Position<E> after(Position<E> p) throws IllegalArgumentException{
		Node<E> node = validate(p);
		return position(node.getNext());
	}
	
	//private utilities
	//adds given element between the given nodes in the list
	private Position<E> addBetween(E e, Node<E> prev, Node<E> next){
		Node<E> newest = new Node<>(e, prev, next);
		prev.setNext(newest);
		next.setPrev(newest);
		size++;
		return newest;
	}
	
	//inserts element at the front of the list and returns new position
	public Position<E> addFirst(E e){
		return addBetween(e, header, header.getNext());
	}
	
	//inserts element e at the end of the list and returns new position
	public Position<E> addLast(E e){
		return addBetween(e, trailer.getPrev(), trailer);
	}
	
	//inserts element e before position p and returns the new position
	public Position<E> addBefore(Position<E> p, E e) throws IllegalArgumentException{
		Node<E> node = validate(p);
		return addBetween(e, node.getPrev(), node);
	}
	
	//inserts element e after position p and returns the new position
	public Position<E> addAfter(Position<E> p, E e) throws IllegalArgumentException{
		Node<E> node = validate(p);
		return addBetween(e, node, node.getNext());
	}
	
	//inserts new element e at position p in the list and returns the replaced element
	public E set(Position<E> p, E e) throws IllegalArgumentException{
		Node<E> node = validate(p);
		E answer = node.getElement();
		node.setElement(e);
		return answer;
	}
	
	//removes the given position from the list and returns the removed position's element
	public E remove(Position<E> p) throws IllegalArgumentException{
		Node<E> node = validate(p);
		Node<E> prev = node.getPrev();
		Node<E> next = node.getNext();
		prev.setNext(next);
		next.setPrev(prev);
		size--;
		E answer = node.getElement();
		node.setElement(null);
		node.setPrev(null);
		node.setNext(null);
		return answer;
	}

}
