package interview.dp;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

// very similar in spirit to coin change combinations
public class Pep_JavaIP_7DP_213LinearEquation {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int[] coeff = new int[scn.nextInt()];
		for(int i = 0; i < coeff.length; i++){
			coeff[i] = scn.nextInt();
		}
		int rhs = scn.nextInt();
		
		System.out.println(solve(coeff, rhs));
	}
	
	private static int solve(int[] coeff, int rhs){
		int[] dp = new int[rhs + 1];
		
		dp[0] = 1;
		for(int i = 0; i < coeff.length; i++){
			for(int j = coeff[i]; j <= rhs; j++){
				dp[j] += dp[j - coeff[i]];
			}
		}
		
		return dp[rhs];
	}
}

// https://www.geeksforgeeks.org/find-number-of-solutions-of-a-linear-equation-of-n-variables/
/* Test case 1 
2
1 2
5
3
*/

/* Test case 2 
3
2 2 3
4
3
*/
