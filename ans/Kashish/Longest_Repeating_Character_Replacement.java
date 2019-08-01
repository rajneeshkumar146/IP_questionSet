package InternQuestAS1;

import java.util.Scanner;

public class Longest_Repeating_Character_Replacement {
//	 The whole idea is that if we have a string of length N out of which M characters are same,
//	    we can replace (N - M) characters to get a continueous string of N characters. 
//	    If N-M <= K. N is the local maximum for this window.
//	    If this length is greater than K. Slide the window.
	
	   public static int characterReplacement(String s, int k) {
		   int[] chars = new int[26];
	        int maxCount = 0, start = 0, maxSize = 0;
	        
	        for(int end = 0; end < s.length(); end ++){
	            chars[s.charAt(end) - 'A']++;
	            maxCount = Math.max(maxCount, chars[s.charAt(end) - 'A']);
	            
	            // if max character frequency + distance between start and end is greater than k
	            // this means we have considered changing more than k charactres. So time to shrink window
	            if(end - start + 1 - maxCount > k){
	                chars[s.charAt(start) - 'A']--;
	                start ++;
	            }
	            
	            maxSize = Math.max(maxSize, end - start + 1);
	        }
	        
	        return maxSize;
	        
	    }
	public static void main(String[] args) {
		
		Scanner scn=new Scanner(System.in);
	String 	s = "ABAB";
	int k = 2;
	System.out.println(characterReplacement(s, k));

	}

}
