package interview.dp;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Pep_JavaIP_7DP_237KPalindromic {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.nextLine();
		int k = Integer.parseInt(scn.nextLine());
		
		System.out.println(solve(str, k));
	}
	
	private static boolean solve(String str, int k){
		int[][] dp = new int[str.length()][str.length()];
		
		for(int gap = 0; gap < str.length(); gap++){
			for(int i = 0, j = i + gap; j < str.length(); i++, j++){
				if(gap == 0){
					dp[i][j] = 0;
				} else if(gap == 1){
					dp[i][j] = str.charAt(i) == str.charAt(j)? 0: 1;
				} else {
					if(str.charAt(i) != str.charAt(j)){
						dp[i][j] = Math.min(dp[i + 1][j], dp[i][j - 1]) + 1;
					} else {
						dp[i][j] = dp[i + 1][j - 1];
					}
				}
			}
		}
		
		return dp[0][str.length() - 1] <= k;
	}
	
}

// https://www.geeksforgeeks.org/find-if-string-is-k-palindrome-or-not/
/* Test case 1 
acdcb
2
true
*/

/* Test case 2 
abcdeca
2
true
*/

/* Test case 3 
acdcb
1
false
*/