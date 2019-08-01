package june1;

import java.util.HashMap;
import java.util.Scanner;

public class XORCipher {

	public static void main(String[] args) {
		//System.out.println(0xC);
		//System.out.println(Character.digit('c', 16));
		
		HashMap<Character, Integer> hex = new HashMap<>();
		hex.put('0', 0);
		hex.put('1', 1);
		hex.put('2', 2);
		hex.put('3', 3);
		hex.put('4', 4);
		hex.put('5', 5);
		hex.put('6', 6);
		hex.put('7', 7);
		hex.put('8', 8);
		hex.put('9', 9);
		hex.put('A', 10);
		hex.put('B', 11);
		hex.put('C', 12);
		hex.put('D', 13);
		hex.put('E', 14);
		hex.put('F', 15);
	
		//System.out.println(hex);
		
		HashMap<Integer, Character> intToChar = new HashMap<>();
		intToChar.put(0, '0');
		intToChar.put(1, '1');
		intToChar.put(2, '2');
		intToChar.put(3, '3');
		intToChar.put(4, '4');
		intToChar.put(5, '5');
		intToChar.put(6, '6');
		intToChar.put(7, '7');
		intToChar.put(8, '8');
		intToChar.put(9, '9');
		intToChar.put(10, 'A');
		intToChar.put(11, 'B');
		intToChar.put(12, 'C');
		intToChar.put(13, 'D');
		intToChar.put(14, 'E');
		intToChar.put(15, 'F');
		
		Scanner scn = new Scanner(System.in);
		int T = scn.nextInt();
		while(T-- > 0){
			String cipher = scn.next();
			System.out.println(decode(cipher, hex, intToChar));
		}
		//System.out.println(decode("A1D0A1D", hex, intToChar));
		//System.out.println(decode("653CAE8DA8EDB426052", hex, intToChar));
		
	}
	
	private static String decode(String cipher, HashMap<Character, Integer> hex, HashMap<Integer, Character> intToChar){
		String plaintext = "";
		
		int len = cipher.length();
		
		int x = 0; // to store XOR of previous digits
		
		for(int i = len - 1; i >= len / 2; i--){
			
			char ch = cipher.charAt(i);
			
			int h = hex.get(ch);
			
			char y = intToChar.get(x ^ h);
			
			//System.out.println("Y = " + y);
			
			x = x ^ hex.get(y);
			
			//System.out.println("x = " + x);
			
			plaintext = y + plaintext; 
			
		}
		
		return plaintext;
		
	}
	

}
