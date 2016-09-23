package Chapter3FundamentalDataStructures;

import java.util.Scanner;

public class SingleRepeatingElementArray {
	//the elements in the array must be consecutive from 0 or 1, non-negative and only one repeating element
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[] array = new int[n];
		boolean zero = false;
		for(int i=0;i<n;++i){			
			array[i]=scan.nextInt();
			if(array[i]==0){
				zero = true;
			}
		}
		if(zero==false){
			n = n+1; //if element 0 is not entered by the user then consider it and increment size of array by 1					
		}
		scan.close();
		System.out.println("The repeating element is: "+repeatedElement(array, n));
		System.out.println("The replaced element is: "+replacedElement(array, n));
	}
	
	static int repeatedElement(int[] array, int n){
		int A = sumOfElements(array, n);
		int B = sumOfSquaresOfElements(array, n, A);
		return (B-A)/2;
	}
	
	static int replacedElement(int[] array, int n){
		int A = sumOfElements(array, n);
		int B = sumOfSquaresOfElements(array, n, A);
		return (B+A)/2;
	}
		
	static int sumOfElements(int[] array, int n){
		int sum=0;
		for(int i=0;i<array.length;++i){
			sum+=array[i];
		}		
		int A = ((n*(n-1))/2) - sum;
		//System.out.println(A);
		return A;
	}
	
	static int sumOfSquaresOfElements(int[] array, int n, int A){
		int squareSum=0;
		for(int i=0;i<array.length;++i){
			squareSum+=array[i]*array[i];
		}
		int B = (((n*(n-1)*((2*n)-1))/6) - squareSum)/A; 
		//System.out.println(B);
		return B;
	}
	
}
