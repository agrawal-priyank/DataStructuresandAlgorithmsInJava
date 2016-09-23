package Chapter6StacksQueuesDeques;

import java.util.Arrays;
import java.util.Scanner;

import Stack.LinkedStack;

/**
 * @author Priyank Agrawal
 * 
 * Date 08/20/2016
 * 
 * Reversing an Array using a Stack which is implemented using a Linked List
 */
public class ReversingArrayStack {
	
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter the size of an array: ");
		int size = scanner.nextInt();
		System.out.println("Please enter elements of the array: ");
		int[] array = new int[size];
		for(int i=0;i<size;++i){
			array[i] = scanner.nextInt();
		}
		scanner.close();
		System.out.println("Original array = "+Arrays.toString(array));
		System.out.println("Reversed array = "+Arrays.toString(reverse(array)));
	}
	
	static int[] reverse(int[] array){
		int size = array.length;
		LinkedStack<Integer> stack = new LinkedStack<>();
		//insert all array elements into the stack
		for(int i=0;i<size;++i){
			stack.push(array[i]);
		}
		//insert all elements back into the array in reverse order
		for(int i=0;i<size;++i){
			array[i] = stack.pop();
		}
		return array;
	}
	
}
