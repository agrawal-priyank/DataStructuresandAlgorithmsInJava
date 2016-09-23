package Chapter1JavaPrimer;

import java.util.Scanner;

public class RemovePunctuation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.print("Please write any word or sentence using punctuation: ");
		String s = scanner.nextLine();
		scanner.close();
		StringBuilder str = new StringBuilder(s);
		System.out.print("The formatted word/sentence is: " +removePunct(str));
	}
	
	private static StringBuilder removePunct(StringBuilder str){
		for(int i=0; i<str.length(); i++){
			if(str.charAt(i) == '!' || str.charAt(i) == '\''){
				str.deleteCharAt(i);
			}
		}
		return str;
	}

}
