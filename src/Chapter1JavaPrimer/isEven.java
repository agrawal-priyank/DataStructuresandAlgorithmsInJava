package Chapter1JavaPrimer;

import java.util.Scanner;

public class isEven {

	public static void main(String[] args) {		
		Scanner scanner  = new Scanner(System.in);
		System.out.print("Please enter any number: ");
		int a = scanner.nextInt();
		scanner.close();
		System.out.print("The number is " +isEven(a));
	}
	
	private static String isEven(int a){
		if((a & 1) == 0){
			return "Even";
		}
		else{
			return "Odd";
		}
	}

}
