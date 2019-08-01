package interview.dp;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Pep_JavaIP_7DP_240ShortestUncommonSubsequence {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str1 = scn.nextLine();
		String str2 = scn.nextLine();
		
		System.out.println(solve(str1, str2));
	}
	
	private static Integer solve(String str1, String str2){
		Integer[][] dp = new Integer[str1.length() + 1][str2.length() + 1];
		
		for(int i = str1.length(); i >= 0; i--){
			for(int j = str2.length(); j >= 0; j--){
				if(i == str1.length() && j == str2.length()){
					dp[i][j] = null; // str1 is empty
				} else if(i == str1.length()){
					dp[i][j] = null; // str1 is empty, nothing to found
				} else if(j == str2.length()){
					dp[i][j] = 1; // no character can be found in empty str2
				} else {
					int idx = -1;
					for(int k = j; k < str2.length(); k++){
						if(str1.charAt(i) == str2.charAt(k)){
							idx = k;
							break;
						}
					}
					
					if(idx == -1){ // obvious
						dp[i][j] = 1;
					} else {
						if(dp[i + 1][j] == null && dp[i + 1][idx + 1] == null){
							dp[i][j] = null;
						} else if(dp[i + 1][j] == null){
							dp[i][j] = 1 + dp[i + 1][idx + 1];
						} else if(dp[i + 1][idx + 1] == null){
							dp[i][j] = dp[i + 1][j];
						} else {
							// why of 1 + dp[i + 1][idx + 1] not clear.
							dp[i][j] = Math.min(dp[i + 1][j], 1 + dp[i + 1][idx + 1]);
						}
					}
				}
			}
		}
		
		return dp[0][0];
	}
}

// https://www.geeksforgeeks.org/shortest-uncommon-subsequence/
/* Test case 1 
babab
babba
3
*/

/* Test case 2 
abb
abab
null
*/
