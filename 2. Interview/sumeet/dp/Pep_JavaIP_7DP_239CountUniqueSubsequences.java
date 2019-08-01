package interview.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Pep_JavaIP_7DP_239CountUniqueSubsequences {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.nextLine();
		System.out.println(solve(str));
	}
	
	private static int solve(String str){
		int[] count = new int[str.length() + 1];
		HashMap<Character, Integer> idxmap = new HashMap<>();
		
		count[0] = 1;
		for(int i = 1; i < count.length; i++){
			char ch = str.charAt(i - 1);
			
			if(idxmap.containsKey(ch) == false){
				count[i] = 2 * count[i - 1];
			} else {
				// we are subtracting sequences ending with previous occurrence of same char
				count[i] = 2 * count[i - 1] - count[idxmap.get(ch)];
			}
			
			idxmap.put(ch, i - 1);
		}
		
		return count[str.length()];
	}

}

// https://www.geeksforgeeks.org/count-distinct-subsequences/
/* Test case 1 
gfg
7
*/

/* Test case 2 
abcc
12
*/