package Chapter6StacksQueuesDeques;

import Queue.CircularLinkedQueue;

/**
 * @author Priyank Agrawal
 * 
 * Date 08/24/2016
 * 
 * Computes the winner of the Josephus game using Queue implemented using Circularly Linked List
 */
public class JosephusProblem {
	
	public static void main(String[] args){
		String[] a1 = {"Priyank", "Trisha", "Anil", "Chhaya", "Rahul"};
		String[] a2 = {"Priyank", "Nilay", "Rahul", "Rajat", "Rohit"};
		System.out.println("The first winnner is: "+Josephus(buildQueue(a1), 3));
		System.out.println("The second winner is: "+Josephus(buildQueue(a2), 4));
	}
	
	/**
	 * @return builds the queue and returns it
	 */
	@SuppressWarnings("unchecked")
	static <E> CircularLinkedQueue<E> buildQueue(E a[]){
		@SuppressWarnings("rawtypes")
		CircularLinkedQueue queue = new CircularLinkedQueue<>();
		for(int i=0; i<a.length;++i){
			queue.enqueue(a[i]);			//insert all the elements inside the queue
		}
		return queue;
	}
	
	/**
	 * @return the winner of the game
	 */
	static <E> E Josephus(CircularLinkedQueue<E> queue, int k){
		if(queue.isEmpty()) return null;
		while(queue.size() > 1){
			for(int i=0;i<k-1;++i){
				queue.rotate();
			}
			queue.dequeue();				//remove the front element after rotation of elements in the queue
		}
		return queue.dequeue();
	}

}
