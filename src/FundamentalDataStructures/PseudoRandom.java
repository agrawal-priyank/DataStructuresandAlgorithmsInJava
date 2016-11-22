package Chapter3FundamentalDataStructures;

import java.util.Random;

public class PseudoRandom {
	
	public static void main(String[] args){
		Random random = new Random();
		random.setSeed(92);
		int a = 12;
		int b = 5;
		int n = 100;
		for(int i=0;i<5;i++){
			int cur = random.nextInt();
			System.out.println("cur: "+cur);
			System.out.println("number"+(a*cur+b)%n);
		}
	}

}
