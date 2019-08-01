package interview.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Pep_JavaIP_7DP_243MaxSumAlternatingSubsequence {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int[] arr = new int[scn.nextInt()];
		for(int i = 0; i < arr.length; i++){
			arr[i] = scn.nextInt();
		}
		
		System.out.println(solve(arr));
	}
	
	// alternate - lis
	private static int solve(int[] arr){
		int[] dec = Arrays.copyOf(arr, arr.length);
		int[] inc = Arrays.copyOf(arr, arr.length);
		
		boolean firstDip = false;
		for(int i = 1; i < arr.length; i++){
			for(int j = 0; j < i; j++){
				if(arr[j] > arr[i]){
					dec[i] = Math.max(dec[i], inc[j] + arr[i]);
					firstDip = true; // to make sure it goes down first.
				} else if(arr[j] < arr[i] && firstDip){
					inc[i] = Math.max(inc[i], dec[j] + arr[i]);
				}
			}
		}
		
		int res = Integer.MIN_VALUE;
		for(int i = 0; i < arr.length; i++){
			res = Math.max(res, Math.max(inc[i], dec[i]));
		}
		
		return res;
	}

}

// https://www.geeksforgeeks.org/maximum-sum-alternating-subsequence-sum/
/* Test case 1 
7
8 2 3 5 7 9 10
25
*/

/* Test case 2 
6
4 3 8 5 3 8
28
*/

/* Test case 3 
6
4 8 2 5 6 8
14
*/