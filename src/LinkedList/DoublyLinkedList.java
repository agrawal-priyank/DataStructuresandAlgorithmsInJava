package LinkedList;

/**
 * @author Priyank Agrawal
 * 
 * Date 08/23/2016
 * 
 * Implementation of Generic Doubly Linked List
 */
public class DoublyLinkedList<E> {

	//nested node class
	static class Node<E>{
		private E element;					//reference to element to be stored in the node
		private Node<E> prev;				//reference to previous node in the list
		private Node<E> next;				//reference to the next node in the list
		
		public Node(E e, Node<E> p, Node<E> n){
			setElement(e);
			setPrev(p);
			setNext(n);
		}
		public E getElement() {
			return element;
		}
		public void setElement(E element) {
			this.element = element;
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
	}
	
	private Node<E> header;							//header sentinel
	private Node<E> trailer;						//trailer sentinel
	private int size = 0;							//number of elements in the list
	
	public DoublyLinkedList( ){						//constructing an empty list
		header = new Node<>(null, null, null);		//create header
		trailer = new Node<>(null, header, null);	//trailer is preceded by header
		header.setNext(trailer);					//trailer is next to header
	}
	
	/**
	 * @return number of elements in the list
	 */
	public int size(){
		return size;
	}
	
	/**
	 * tests whether list is empty
	 * @return true if list is empty (otherwise false)
	 */
	public boolean isEmpty(){
		return size == 0;
	}
	
	/**
	 * @return the first element from the list but does not remove
	 */
	public E first(){
		if(isEmpty()) return null;
		return header.getNext().getElement();
	}
	
	/**
	 * @return	the last element from of list but does not remove
	 */
	public E last(){
		if(isEmpty()) return null;
		return trailer.getNext().getElement();
	}
	
	/**
	 * adds element e to the front of the list
	 */
	public void addFirst(E e){
		addBetween(e, header, header.getNext());
	}
	
	/**
	 * adds element e to the end of the list
	 */
	public void addLast(E e){
		addBetween(e, trailer.getPrev(), trailer);
	}
	
	/**
	 * @return the element of the first node and removes the first node from the list
	 */
	public E removeFirst(){
		if(isEmpty()) return null;
		return remove(header.getNext());
	}
	
	/**
	 * @return the element of the last node and removes the last node from the list
	 */
	public E removeLast(){
		if(isEmpty()) return null;
		return remove(trailer.getPrev());
	}
	 
	/**
	 * adds element e in between two given nodes
	 */
	public void addBetween(E e, Node<E> predecessor, Node<E> successor){
		Node<E> newest = new Node<>(e, predecessor, successor);
		predecessor.setNext(newest);
		successor.setPrev(newest);
	}
	
	/**
	 * @return the element of the node removed
	 */
	public E remove(Node<E> node){
		Node<E> predecessor = node.getPrev();
		Node<E> sucessor = node.getNext();
		predecessor.setNext(sucessor);
		sucessor.setPrev(predecessor);
		size--;
		return node.getElement();
	}	
	
}
