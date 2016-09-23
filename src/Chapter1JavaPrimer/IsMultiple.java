package Chapter1JavaPrimer;

import java.util.Scanner;

public class IsMultiple {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.print("Please enter any two numbers: ");
		long a = scanner.nextLong();
		long b = scanner.nextLong();
		scanner.close();
		System.out.println("The second number is multiple of first number: " +isMultiple(a,b));
	}

	private static boolean isMultiple(long a, long b){
		if (a%b==0){
			return true;
		}
		else{
			return false;
		}
	}
}
