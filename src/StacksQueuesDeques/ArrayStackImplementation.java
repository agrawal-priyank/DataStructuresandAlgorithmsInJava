package Chapter6StacksQueuesDeques;

import Stack.ArrayStack;

public class ArrayStackImplementation {
	
	public static void main(String[] args){
		ArrayStack<Integer> s1 = new ArrayStack<>();
		s1.push(1);
		s1.push(2);
		s1.push(3);
		System.out.println("Initial stack size:\n"+s1.size());
		System.out.println("Pop elements:\n"+s1.pop()+" "+s1.pop());
		System.out.println("Top element:\n"+s1.top());
		System.out.println("Stack size:\n"+s1.size());
		System.out.println("Stack empty check:\n"+s1.isEmpty());
		System.out.println("Pop last element:\n"+s1.pop());
		System.out.println("Stack empty check:\n"+s1.isEmpty());
		System.out.println("Stack size:\n"+s1.size());
	}

}
