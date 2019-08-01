package interview.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Pep_JavaIP_7DP_242Billboard {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] x = new int[n];
		int[] r = new int[n];
		
		for(int i = 0; i < n; i++){
			x[i] = scn.nextInt();
		}
		
		for(int i = 0; i < n; i++){
			r[i] = scn.nextInt();
		}
		
		int m = scn.nextInt();
		int t = scn.nextInt();
		
		System.out.println(solve(x, r, m, t));
	}
	
	// alternate - lis
	private static int solve(int[] x, int[] r, int m, int t){
		int[] strg = new int[m + 1];
		
		int cbb = 0; // count billboards
		for(int i = 1; i <= m; i++){
			if(cbb < x.length){
				if(x[cbb] == i){ // possible bill board
					// reject the billboard or place it (making sure there is none in last t miles)
					strg[i] = Math.max(strg[i - 1], r[cbb] + (i > t? strg[i - t - 1]: 0));
					cbb++;
				} else {
					strg[i] = strg[i - 1];
				}
			} else {
				strg[i] = strg[i - 1];
			}
		}
		
		return strg[m];
	}

}

// https://www.geeksforgeeks.org/highway-billboard-problem/
/* Test case 1 
5
6 7 12 13 14
5 6 5 3 1 
20 5
10
*/

/* Test case 2 
4
6 9 12 14
5 6 3 7	 
15 2
18
*/