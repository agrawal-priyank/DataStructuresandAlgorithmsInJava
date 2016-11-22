package Chapter1JavaPrimer;

import java.util.Scanner;

public class Sum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner  = new Scanner(System.in);
		System.out.print("Please enter any number: ");
		int a = scanner.nextInt();
		scanner.close();
		System.out.printf("The sum of 0 to %d is: %d",a, summation(a));
	}
	
	private static int summation(int a){
		int b = 0;
		if(a==0){
			return 0;
		}
		else if(a==1){
			return 1;
		}
		else{
			for(int i=1;i<=a;i++){
				b+=i;
			}
			return b;
		}
	}

}
