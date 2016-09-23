package Array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;

public class ArraySample {

	public static void main(String[] args) {
		int[] array = new int[10];
		Random rand = new Random();
		rand.setSeed(System.currentTimeMillis());
		
		for(int i=0;i<array.length;i++){
			array[i] =  rand.nextInt(100);
		}
		
		int[] newArray = Arrays.copyOf(array, array.length);
		
		System.out.println("Arrays equal before sort: " +Arrays.equals(array, newArray));
		Arrays.sort(newArray);
		System.out.println("Arrays equal after sort: "+Arrays.equals(array, newArray));
		System.out.println("Original array: "+Arrays.toString(array));
		System.out.println("Copy array: "+Arrays.toString(newArray));
		
		HashSet<String> hs = new HashSet<>();
		hs.iterator();
		
		
	}

}
