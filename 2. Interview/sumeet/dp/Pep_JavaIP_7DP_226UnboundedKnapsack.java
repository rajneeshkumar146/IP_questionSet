package interview.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Pep_JavaIP_7DP_226UnboundedKnapsack {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] wts = new int[n];
		for(int i = 0; i < n; i++){
			wts[i] = scn.nextInt();
		}
		int[] vals = new int[n];
		for(int i = 0; i < n; i++){
			vals[i] = scn.nextInt();
		}
		int wt = scn.nextInt();
		System.out.println(solve(vals, wts, wt));
	}
	
	private static int solve(int[] vals, int[] wts, int wt){
		int[] str = new int[wt + 1];
		
		for(int cwt = 1; cwt <= wt; cwt++){
			for(int i = 0; i < vals.length; i++){
				if(cwt >= wts[i]){
					str[cwt] = Math.max(str[cwt], vals[i] + str[cwt - wts[i]]);
				}
			}
		}
		
		return str[wt];
	}

}

// https://www.geeksforgeeks.org/unbounded-knapsack-repetition-items-allowed/
/* Test case 1 
4
1 3 4 5
10 40 50 70
8
110
*/

/* Test case 2 
2
1 50
1 30
100
100
*/

/* Test case 3 
5
2 3 5 4 6
20 30 40 45 50
11
120
*/