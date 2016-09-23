package Chapter1JavaPrimer;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListPopulate {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        ArrayList<Integer> integerList = new ArrayList<Integer>();
        
        for(int i=0;i<size;i++){
            integerList.add(scanner.nextInt());
        }
        
        int numberOfQueries = scanner.nextInt();
        
        scanner.nextLine();
        
        String query1 = scanner.nextLine();
        int index = scanner.nextInt();
        int element = scanner.nextInt();
        integerList.add(index, element);
       
        scanner.nextLine();
        
        String query2 = scanner.nextLine();        
        int index2 = scanner.nextInt();
        integerList.remove(index2);              
        
        for(int i=0;i<size;i++){            
            System.out.print(integerList.get(i));
            System.out.print(" ");
        }
        scanner.close();
        
    }
}

