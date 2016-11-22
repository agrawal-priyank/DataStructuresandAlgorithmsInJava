package Chapter7ListAndIteratorADTs;

import PositionalList.LinkedPositionalList;
import PositionalList.Position;

/**
 * @author Priyank Agrawal
 * 
 * Date 08/31/2016
 * 
 * Sorting a Linked Positional List using Insertion Sort
 */
public class InsertionSortPositionalList {
	
	public static void main(String[] args){
		LinkedPositionalList<Integer> list = new LinkedPositionalList<>();
		list.addFirst(5);
		list.addLast(1);
		list.addLast(8);
		list.addLast(10);
		LinkedPositionalList<Integer> sortedList = insertionSort(list);
		Position<Integer> position = sortedList.first();
		for(int i=0;i<sortedList.size();++i){			
			System.out.println(position.getElement());
			position = sortedList.after(position);
		}
	}
	
	//sorts a list using insertion sort technique
	static LinkedPositionalList<Integer> insertionSort(LinkedPositionalList<Integer> list){
		Position<Integer> marker = list.first();				//make the position of the first element in the list a marker	
		while(marker != list.last()){							//until marker does not come to the last position
			Position<Integer> pivot = list.after(marker);		//make the next position to the marker as a pivot
			int value = pivot.getElement();			
			if(value > marker.getElement()){					//if pivot element is higher then marker element which means the list already sorted
				marker = pivot;									//move forward and now make pivot as the new marker
			}
			else{												//if pivot element is lesser than marker element
				Position<Integer> walk = marker;				//walk leftwards from marker to first position of the list as necessary
				while(walk != list.first() && list.before(walk).getElement() > value){
					walk = list.before(walk);					//if walk element greater than pivot element move walk one step back in the list 
				}
				list.remove(pivot);								//invalidate pivot
				list.addBefore(walk, value);					//place pivot element in correct walk position	
			}
		}
		return list;											//return the sorted list
	}

}
