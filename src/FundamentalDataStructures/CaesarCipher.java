package Chapter3FundamentalDataStructures;

import java.util.Scanner;

public class CaesarCipher {

	protected char[] encoder = new char[26];
	protected char[] decoder = new char[26];
	
	public CaesarCipher(int rotation){
		for(int i=0;i<26;i++){
			encoder[i] = (char)('A' + (i + rotation) % 26);
			decoder[i] = (char)('A' + (i - rotation + 26) % 26);
		}
	}
	
	public String encrypt(String msg){
		return transform(msg, encoder);
	}
	
	public String decrypt(String secretMsg){
		return transform(secretMsg, decoder);
	}
	
	private String transform(String original, char[] code){
		char[] msg = original.toCharArray();
		for(int i=0;i<msg.length;i++){
			if(Character.isUpperCase(msg[i])){
				int j = msg[i] - 'A';
				msg[i] = code[j];
			}
		}
		return new String(msg);
	}
	
	public static void main(String[] args) {
		CaesarCipher cipher = new CaesarCipher(3);		
		System.out.println("Encrption code: "+new String(cipher.encoder));
		System.out.println("Decryption code: "+new String(cipher.decoder));
		Scanner scan = new Scanner(System.in);
		System.out.println("Please write a message: ");
		String msg = scan.nextLine();
		scan.close();
		String secretMsg = cipher.encrypt(msg);
		System.out.println("Cipher text: "+secretMsg);
		System.out.println("Plain text: "+cipher.decrypt(secretMsg));
	}

}
