package Chapter1JavaPrimer;

import java.util.ArrayList;

public class PossibleOrders {

	public static void main(String[] args) {
		int[] array = new int[52];
		for(int i=0;i<array.length;i++){
			array[i] = i+1;
			System.out.print(array[i]+" ");			
		}
		
		System.out.println("");
		
		for(int i=0;i<array.length;i++){
			ArrayList<Integer> newOrder = new ArrayList<Integer>();
			newOrder.add(array[i]);
			for(int j=i+1;j<array.length;j++){
				newOrder.add(array[j]);
			}
			
			for(int k=0;k<newOrder.size();k++){            
	            System.out.print(newOrder.get(k));
	            System.out.print(" ");
	        }
			
			//System.out.println(newOrder.iterator().toString());			
			//System.out.println("");
		}
	}

}
