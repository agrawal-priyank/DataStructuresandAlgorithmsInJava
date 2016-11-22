package Chapter3FundamentalDataStructures;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class RandomArrayEntry {
	
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter size of array: ");
		int size = scan.nextInt();
		scan.close();
		ArrayList<Integer> array = new ArrayList<>();
		for(int i=0;i<size;i++){
			array.add(randomize(1, 100));
			System.out.print(array.get(i) + " ");
		}
		boolean result = deleteArrayEntries(array, size);
		if(result == true){
			System.out.println("The array is empty now");			
		}
		else{
			System.out.println("Operation failed");
		}		
	}
	
	public static int randomize(int min, int max){
		Random random = new Random();
		int number = random.nextInt(max-min)+min;
		return number;
	}
	
	static boolean deleteArrayEntries(ArrayList<Integer> array, int n){		
		while(array.size()>0){
			int index = randomize(0, n-1);
			System.out.println(index);
			if(array.size()>index){
				array.remove(index);
			}
		}
		if(array.isEmpty()){
			return true;
		}
		return false;
	}

}
