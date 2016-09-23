package Chapter9PriorityQueues;

import java.util.Scanner;

public class StringLengthComparator {
	
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter first string: ");
		String a = scan.nextLine();
		System.out.println("Please enter second string: ");
		String b = scan.nextLine();
		scan.close();
		System.out.println("First string is "+compare(a, b)+" second string");		
	}
	
	static String compare(String a, String b){
		if(a.length() < b.length()) return "less than";
		else if(a.length() == b.length()) return "equal to";
		else
			return "greater than";
	}

}
