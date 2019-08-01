package interview.strings;

import java.util.HashMap;
import java.util.Scanner;

public class Pep_JavaIP_3strings_84KAnagrams {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		String src = scn.nextLine();
		String pat = scn.nextLine();
		int k = Integer.parseInt(scn.nextLine());
		
		System.out.println(solve(src, pat, k));
	}
	
	private static boolean solve(String src, String pat, int k){
		if(src.length() != pat.length()){
			return false;
		}
		
		// frequency map incremented using src
		HashMap<Character, Integer> map = new HashMap<>();
		for(int i = 0; i < src.length(); i++){
			char ch = src.charAt(i);
			map.put(ch, map.containsKey(ch)? map.get(ch) + 1: 1);
		}

		// frequency map decremented using pat
		for(int i = 0; i < pat.length(); i++){
			char ch = pat.charAt(i);
			map.put(ch, map.containsKey(ch)? map.get(ch) - 1: -1);
		}
		
		int sum = 0;
		int posSum = 0;
		for(Character key: map.keySet()){
			sum += map.get(key);
			if(map.get(key) > 0){
				posSum += map.get(key);
			}
		}
		
		// if sum is non zero this can't be done, else it can be done in
		// posSum replacements
		if(sum != 0){
			return false;
		} 
		
		// if posSum is <= k
		return posSum <= k;
	}

}
