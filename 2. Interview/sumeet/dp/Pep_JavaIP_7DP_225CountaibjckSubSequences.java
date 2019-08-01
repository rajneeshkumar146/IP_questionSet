package interview.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Pep_JavaIP_7DP_225CountaibjckSubSequences {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.nextLine();
		System.out.println(solve(str));
	}
	
	private static int solve(String str){
		int acount = 0;
		int bcount = 0;
		int ccount = 0;
		
		for(int i = 0; i < str.length(); i++){
			char ch = str.charAt(i);
			
			if(ch == 'a'){
				acount = 1 + 2 * acount; 
				// 1 for a starting a new sequence
				// acount for a refusing to attach with old a sequence
				// acount for a accepting to attach with old a sequence
			} else if(ch == 'b'){
				bcount = acount + 2 * bcount; 
				// acount for b starting a new sequence with a sequence
				// bcount for b refusing to attach with old b sequence
				// bcount for b accepting to attach with old b sequence
			} else if(ch == 'c'){
				ccount = bcount + 2 * ccount;
			}
		}
		
		return ccount;
	}

}

// https://www.geeksforgeeks.org/number-subsequences-form-ai-bj-ck/
/* Test case 1 
abbc
3
*/

/* Test case 2 
abcabc
7
*/