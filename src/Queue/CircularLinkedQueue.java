package Queue;

import LinkedList.CircularlyLinkedList;

/**
 * @author Priyank Agrawal
 *
 * Date 08/23/2016
 *
 * Implementing Generic Queue using Circularly Linked Lists
 */
public class CircularLinkedQueue<E> implements CircularQueue<E> {
	
	private CircularlyLinkedList<E> list = new CircularlyLinkedList<>();
	
	public CircularLinkedQueue(){ }					//constructs empty list
	
	public int size(){
		return list.size();
	}
	
	public boolean isEmpty(){
		return list.isEmpty();
	}
	
	public void enqueue(E element){
		list.addLast(element);
	}
	
	public E dequeue(){
		return list.removeFirst();
	}
	
	public E first(){
		return list.first();
	}
	
	public void rotate(){
		list.rotate();
	}

}
