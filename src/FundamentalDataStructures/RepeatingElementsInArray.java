package Chapter3FundamentalDataStructures;

import java.util.Scanner;

public class RepeatingElementsInArray {
	
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[] array = new int[n];
		for(int i=0;i<n;++i){
			array[i]=scan.nextInt();
		}
		scan.close();
		//complexity is O(n^2)
		for(int i=0;i<n;++i){
			for(int j=i+1;j<n;++j){
				if(array[i]==array[j]){
					System.out.println(array[i]);
				}
			}
		}	
	}

}
