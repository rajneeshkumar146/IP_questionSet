package interview.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Pep_JavaIP_7DP_232LongestEvenLengthEqualPartition {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i < arr.length; i++){
			arr[i] = scn.nextInt();
		}
		
		System.out.println(solve(arr));
	}
	
	private static int solve(int[] arr){
		int[] sum = new int[arr.length + 1];
		
		sum[0] = 0; 
		for(int i = 1; i < sum.length; i++){
			sum[i] = arr[i - 1] + sum[i - 1];
		}
		
		int maxL = Integer.MIN_VALUE;
		for(int gap = 2; gap < sum.length; gap += 2){
			for(int i = 0, j = i + gap; j < sum.length; i++, j++){
				if(sum[i + gap/2] - sum[i] == sum[j] - sum[i + gap / 2]){
					if(gap > maxL){
						maxL = gap;
					}
				}
			}
		}
		return maxL;
	}
}

// https://www.geeksforgeeks.org/longest-even-length-substring-sum-first-second-half/
/* Test case 1 
6
1 2 3 1 2 3
6
*/

/* Test case 2 
7
1 5 3 8 0 2 3
4
*/

/* Test case 3 
1
4
*/