package interview.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Pep_JavaIP_7DP_212NumericKeypad {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		
		System.out.println(solve(n));
	}
	
	private static int solve(int n){
		if(n == 0){
			return 0;
		} else if(n == 1){
			return 10;
		}
		
		// words starting at i of length j
		int[][] count = new int[10][n + 1];
		
		for(int i = 0; i < count.length; i++){
			count[i][0] = 0;
			count[i][1] = 1;
		}
		
		int[][]moves = new int[10][];
		moves[0] = new int[]{0, 1, 3};
		moves[1] = new int[]{0, 1, 2, 4};
		moves[2] = new int[]{1, 2, 5};
		moves[3] = new int[]{0, 3, 4, 6};
		moves[4] = new int[]{1, 3, 4, 5, 7};
		moves[5] = new int[]{2, 4, 5, 8};
		moves[6] = new int[]{3, 6, 7};
		moves[7] = new int[]{4, 6, 7, 8, 9};
		moves[8] = new int[]{5, 7, 8};
		moves[9] = new int[]{7, 9};
		
		for(int j = 2; j <= n; j++){
			for(int i = 0; i <= 9; i++){
				for(int val: moves[i]){
					count[i][j] += count[val][j - 1];
				}
			}
		}
		
		int res = 0;
		for(int i = 0; i <= 9; i++){
			res += count[i][n];
		}
		
		return res;
	}

}

// https://www.geeksforgeeks.org/mobile-numeric-keypad-problem/
/* Test case 1 
2
36
*/

/* Test case 2 
5
2062
*/

/* Test case 3 
4
532
*/