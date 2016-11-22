package Chapter3FundamentalDataStructures;

import java.util.HashMap;
import java.util.Scanner;

public class MultipleRepeatingElementArray {
	
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter size of array (>=6): ");
		int size = scan.nextInt();	
		int[] array = new int[size];
		int last = size - 5;
		System.out.printf("Please enter elements of array from 1 to %d:",last);
		for(int i=0;i<size;++i){
			array[i] = scan.nextInt();
		}
		scan.close();
		HashMap<Integer, Boolean> repetitionBook = new HashMap<>();
		for(int i=0;i<array.length;++i){
			if(repetitionBook.containsKey(array[i])){
				if(repetitionBook.containsValue(true)){
					//
				}
				repetitionBook.replace(array[i], true);
			}
			else{
				repetitionBook.put(array[i], false);
			}
		}
		for(int i=1;i<=repetitionBook.size();++i){
			if(repetitionBook.get(i) == true){
				System.out.println(i);
			}			
		}		
	}

}
