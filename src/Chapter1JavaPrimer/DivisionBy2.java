package Chapter1JavaPrimer;

import java.util.Scanner;

public class DivisionBy2 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter any number: ");
		double n = scan.nextDouble();
		scan.close();
		System.out.println("The number should be divided " +divisionBy2(n)+ " times");

	}
	
	public static int divisionBy2(double n){
		int count = 0;
		while(n>=2){
			n = n/2;
			count++;
		}
		return count;
	}

}
