package Stack;

import LinkedList.SinglyLinkedList;

/**
 * @author Priyank Agrawal
 *
 * Date 08/20/2016
 * 
 * Implementing stack using Singly Linked List
 */
public class LinkedStack<E> implements Stack<E> {
	
	SinglyLinkedList<E> list = new SinglyLinkedList<>();
	
	public LinkedStack(){}			//constructs empty linked list
	
	public int size(){
		return list.size();
	}
	public boolean isEmpty(){
		return list.isEmpty();
	}
	public void push(E element){
		list.addFirst(element);
	}
	public E top(){
		return list.first();
	}
	public E pop(){
		return list.removeFirst();
	}

}
