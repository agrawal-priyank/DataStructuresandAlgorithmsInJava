package Chapter1JavaPrimer;

import java.util.Scanner;

public class VowelCount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.print("Please write any word or sentence: ");
		String str = scanner.nextLine().toLowerCase();
		scanner.close();
		System.out.print("The number of vowels in the word/sentence are: " +numberOfVowels(str));
	}
	
	private static int numberOfVowels(String str){
		int count = 0;
		for(int i=0; i<str.length(); i++){
			if(str.charAt(i) == 'a' || str.charAt(i) == 'e' || str.charAt(i) == 'i' 
					|| str.charAt(i) == 'o' || str.charAt(i) == 'u'){
				count++;
			}
		}
		return count;
	}

}
