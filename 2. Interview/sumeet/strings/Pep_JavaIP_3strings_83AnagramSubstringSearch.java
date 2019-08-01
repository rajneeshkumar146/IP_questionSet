package interview.strings;

import java.util.HashMap;
import java.util.Scanner;

public class Pep_JavaIP_3strings_83AnagramSubstringSearch {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		String src = scn.nextLine();
		String pat = scn.nextLine();
		
		solve(src, pat);
	}
	
	private static void solve(String src, String pat){
		HashMap<Character, Integer> sfmap = new HashMap<>();
		HashMap<Character, Integer> pfmap = new HashMap<>();
		
		for(int i = 0; i < pat.length(); i++){
			char ch = pat.charAt(i);
			pfmap.put(ch, pfmap.containsKey(ch)? pfmap.get(ch) + 1: 1);
		}
		
		for(int i = 0; i < pat.length(); i++){
			char ch = src.charAt(i);
			sfmap.put(ch, sfmap.containsKey(ch)? sfmap.get(ch) + 1: 1);
		}
		
		// sliding window as big as pat.length
		// maintaining fmap of pat and fmap of current window of src -> if they are same, we have an answer
		for(int i = pat.length(); i < src.length(); i++){
			if(equals(sfmap, pfmap)){
				System.out.print(i - pat.length() + " ");
			}
			
			char chToLeave = src.charAt(i - pat.length());
			char chToAcquire = src.charAt(i);
			
			if(sfmap.get(chToLeave) > 1){
				sfmap.put(chToLeave, sfmap.get(chToLeave) - 1);
			} else {
				sfmap.remove(chToLeave);
			}
			
			sfmap.put(chToAcquire, sfmap.containsKey(chToAcquire)? sfmap.get(chToAcquire) + 1: 1);
		}
		
		if(equals(sfmap, pfmap)){
			System.out.print(src.length() - pat.length() + " ");
		}
	}
	
	private static boolean equals(HashMap<Character, Integer> sfmap, 
								  HashMap<Character, Integer> pfmap){
		if(sfmap.size() != pfmap.size()){
			return false;
		}
		
		for(Character ch: sfmap.keySet()){
			if(pfmap.containsKey(ch) == false){
				return false;
			} else if(pfmap.get(ch) != sfmap.get(ch)){
				return false;
			}
		}
		
		return true;
	}

}
