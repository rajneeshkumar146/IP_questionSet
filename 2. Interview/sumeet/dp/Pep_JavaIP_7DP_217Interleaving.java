package interview.dp;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Pep_JavaIP_7DP_217Interleaving {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str1 = scn.nextLine();
		String str2 = scn.nextLine();
		String str3 = scn.nextLine();
		
		System.out.println(solve(str1, str2, str3));
	}
	
	// count of interleaves of s1 and s2 -> count(m, n) = count(m-1, n) + count(m, n-1) [https://www.geeksforgeeks.org/?p=17743]
	private static boolean solve(String str1, String str2, String str3){
		if(str1.length() + str2.length() != str3.length()){
			return false;
		}
		
		boolean[][] dp = new boolean[str1.length() + 1][str2.length() + 1];
		
		for(int i = str1.length(); i >= 0; i--){
			for(int j = str2.length(); j >= 0; j--){
				int k = i + j;
				
				if(i == str1.length() && j == str2.length()){
					dp[i][j] = true;
				} else if(i == str1.length()){
					dp[i][j] = (str3.charAt(k) == str2.charAt(j) && dp[i][j + 1]);
				} else if(j == str2.length()){
					dp[i][j] = (str3.charAt(k) == str1.charAt(i) && dp[i + 1][j]);
				} else {
					dp[i][j] = (str3.charAt(k) == str1.charAt(i) && dp[i + 1][j]) ||
							   (str3.charAt(k) == str2.charAt(j) && dp[i][j + 1]);
				}
			}
		}
		
		return dp[0][0];
	}
}

// https://www.geeksforgeeks.org/check-whether-a-given-string-is-an-interleaving-of-two-other-given-strings-set-2/
/* Test case 1 
YX
X
XXY
false
*/

/* Test case 2 
XY
WZ
WZXY
true
*/

/* Test case 3 
XXY
XXZ
XXZXXXY
false
*/

/* Test case 4 
XXY
XXZ
XXXXZY
true
*/
