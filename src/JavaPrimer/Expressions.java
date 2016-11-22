package Chapter1JavaPrimer;

import java.util.Scanner;

public class Expressions {
	
	public static void main(String[] args){
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter three integers: ");
		int a = scan.nextInt();
		int b = scan.nextInt();
		int c = scan.nextInt();
		scan.close();
		System.out.println("a + b == c: " +method1(a, b, c));
		System.out.println("a == b + c: " +method2(a, b, c));
		System.out.println("a * b == c: " +method3(a, b, c));
	}
	
	public static boolean method1(int a, int b, int c){
		if(a+b==c){
			return true;
		}
		return false;
	}
	
	public static boolean method2(int a, int b, int c){
		if(a==b-c){
			return true;
		}
		return false;
	}
	
	public static boolean method3(int a, int b, int c){
		if(a*b==c){
			return true;
		}
		return false;
	}

}
