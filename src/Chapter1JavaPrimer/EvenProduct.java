package Chapter1JavaPrimer;

import java.util.Scanner;

public class EvenProduct {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter number of elements: ");
		int size = scan.nextInt();		
		int[] array = new int[size];
		System.out.println("Please enter elements: ");
		
		for(int i=0;i<size;i++){
			int n = scan.nextInt();
			array[i] = n;
		}
		scan.close();
		System.out.println("The number of distinct pairs having even product is " +productEven(array));
	}
	
	public static int productEven(int[] array){
		int count = 0;
		for(int i=0; i<array.length; i++){
			for (int j=i+1; j<array.length; j++){
				if(array[i] != array [j]){
					if((array[i]*array[j] & 1) ==0){
						count++;
					}
				}
			}
		}
		return count;		
	}

}
