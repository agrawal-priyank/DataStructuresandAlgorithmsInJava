package PriorityQueue;

import java.util.Comparator;

/**
 * @author Priyank Agrawal
 * 
 * Date 09/05/2016
 * 
 * Default Comparator class that implements a comparator based upons the natural ordering according to comparable interface
 */
public class DefaultComparator<E> implements Comparator<E> {
	
	@SuppressWarnings("unchecked")
	public int compare(E a, E b) throws ClassCastException{
		return ((Comparable<E>)a).compareTo(b);
	}
}

