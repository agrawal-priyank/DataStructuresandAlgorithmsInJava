package Queue;

import LinkedList.SinglyLinkedList;

/**
 * @author Priyank Agrawal
 * 
 * Date 08/22/2016
 * 
 * Implementation of a Queue using Singly Linked List
 */
public class LinkedQueue<E> implements Queue<E> {
	
	private SinglyLinkedList<E> list = new SinglyLinkedList<>();
	
	public LinkedQueue(){ }			//constructs new empty list
	
	public int size(){
		return list.size();
	}
	public boolean isEmpty(){
		return list.isEmpty();
	}
	public void enqueue(E element){
		list.addLast(element);
	}
	public E first(){
		return list.first();
	}
	public E dequeue(){
		return list.removeFirst();
	}

}
