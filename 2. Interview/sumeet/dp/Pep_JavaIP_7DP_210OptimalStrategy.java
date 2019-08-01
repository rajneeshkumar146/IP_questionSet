package interview.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Pep_JavaIP_7DP_210OptimalStrategy {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int[] arr = new int[scn.nextInt()];
		for(int i = 0; i < arr.length; i++){
			arr[i] = scn.nextInt();
		}
		
		System.out.println(solve(arr));
	}
	
	private static int solve(int[] arr){
		int[][] f = new int[arr.length][arr.length];
		
		for(int gap = 0 ; gap < arr.length; gap++){
			for(int i = 0, j = i + gap; j < arr.length; i++, j++){
				if(gap == 0){
					f[i][j] = arr[i];
				} else if(gap == 1){
					f[i][j] = Math.max(arr[i], arr[j]);
				} else {
					f[i][j] = Math.max(arr[i] + Math.min(f[i + 2][j], f[i + 1][j - 1]), 
									   arr[j] + Math.min(f[i + 1][j - 1], f[i][j - 2]));
				}
			}
		}
		
		return f[0][arr.length - 1];
	}
	

}

// https://www.geeksforgeeks.org/dynamic-programming-set-31-optimal-strategy-for-a-game/
/* Test case 1 
4
8 15 3 7
22
*/

/* Test case 2 
4 
2 2 2 2
4
*/

/* Test case 3 
6
20 30 2 2 2 10
42
*/