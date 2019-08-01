package interview.dp;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Pep_JavaIP_7DP_218WildcardMatching {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String src = scn.nextLine();
		String pat = scn.nextLine();
		
		System.out.println(solve(src, pat));
	}
	
	private static boolean solve(String src, String pat){
		boolean[][] dp = new boolean[src.length() + 1][pat.length() + 1];
		
		for(int i = src.length(); i >= 0; i--){
			for(int j = pat.length(); j >= 0; j--){
				if(i == src.length() && j == pat.length()){
					dp[i][j] = true;
				} else if(i == src.length()){
					dp[i][j] = pat.charAt(j) == '*'? dp[i][j + 1]: false;
				} else if(j == pat.length()){
					dp[i][j] = false;
				} else {
					if(pat.charAt(j) == '?'){
						dp[i][j] = dp[i + 1][j + 1];
					} else if( pat.charAt(j) == src.charAt(i)){
						dp[i][j] = dp[i + 1][j + 1];
					} else if(pat.charAt(j) == '*'){
						dp[i][j] = dp[i][j + 1] || // * matched nothing
								   dp[i + 1][j]; // * survived and still took a character
					} else {
						dp[i][j] = false;
					}
				}
			}
		}
		
		return dp[0][0];
	}
}

// https://www.geeksforgeeks.org/wildcard-pattern-matching/
/* Test case 1 
baaabab
*****ba*****ab
true
*/

/* Test case 2 
baaabab
*a*a*
true
*/

/* Test case 3 
baaabab
*a?a?
true
*/

/* Test case 4 
bab
*b?a?
false
*/
