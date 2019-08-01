package interview.strings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Pep_JavaIP_3strings_128Isomorphic {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		String str1 = scn.nextLine();
		String str2 = scn.nextLine();

		System.out.println(solve(str1, str2));
	}

	private static boolean solve(String str1, String str2) {
		if(str1.length() != str2.length()){
			return false;
		}
		
		// character of 2 mapped against that of 1
		HashMap<Character, Character> map12 = new HashMap<>();
		// characters used from 2
		HashSet<Character> used2 = new HashSet<>();

		for(int i = 0; i < str1.length(); i++){
			char ch1 = str1.charAt(i);
			char ch2 = str2.charAt(i);

			// if an unmapped char is found, try to map
			if(map12.containsKey(ch1) == false){
				// if the two's char is unused - map it and mark it used
				if(used2.contains(ch2) == false){
					map12.put(ch1, ch2);
					used2.add(ch2);
				} else {
					// else no mapping is possible
					return false;
				}
			} else {
				// else check if it was earlier mapped to same char.
				if(map12.get(ch1) != ch2){
					return false;
				}
			}
		}
		
		return true;
	}

}
