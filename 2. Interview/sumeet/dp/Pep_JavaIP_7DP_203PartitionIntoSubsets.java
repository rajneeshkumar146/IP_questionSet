package interview.dp;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Pep_JavaIP_7DP_203PartitionIntoSubsets {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int k = scn.nextInt();
		
		System.out.println(solve(n, k));
	}
	
	private static int solve(int n, int k){
		int[][] f = new int[n + 1][k + 1];

		for(int ndash = 1; ndash < f.length; ndash++){
			for(int kdash = 1; kdash <= ndash && kdash < f[0].length; kdash++){
				if(kdash == 1 || kdash == ndash){
					f[ndash][kdash] = 1;
				} else {
					f[ndash][kdash] = f[ndash - 1][kdash - 1] + (kdash) * f[ndash - 1][kdash];
				}
			}
		}
		
		return f[n][k];
	}
	

}

// https://www.geeksforgeeks.org/count-number-of-ways-to-partition-a-set-into-k-subsets/
/* Test case 1 
5 2
15
*/

/* Test case 2 
3 2
3
*/