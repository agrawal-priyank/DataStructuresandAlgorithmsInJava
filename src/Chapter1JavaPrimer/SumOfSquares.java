package Chapter1JavaPrimer;

import java.util.Scanner;

public class SumOfSquares {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner  = new Scanner(System.in);
		System.out.print("Please enter any number: ");
		int a = scanner.nextInt();
		scanner.close();
		System.out.printf("The sum of squares from 0 to %d is: %d",a, sumSquares(a));
	}
	
	private static int sumSquares(int a){
		int b = 0;
		if(a==0){
			return 0;
		}
		else if(a==1){
			return 1;
		}
		else{
			for(int i=1;i<=a;i++){
				b+=i*i;
			}
			return b;
		}
	}

}
