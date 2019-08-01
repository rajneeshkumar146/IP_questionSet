package interview.dp;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Pep_JavaIP_7DP_216PaintersPartition {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int[] arr = new int[scn.nextInt()];
		for(int i = 0; i < arr.length; i++){
			arr[i] = scn.nextInt();
		}
		int k = scn.nextInt();
		
		System.out.println(solve(arr, 0, k, new int[arr.length + 1][k + 1]));
	}
	
	// much like mcp, mcm, eggdrop, squarecut
	private static int solve(int[] arr, int si, int k, int[][] qb){
		if(k == 1){
			return sum(arr, si, arr.length - 1);
		}
		
		if(si == arr.length - 1){
			return arr[si];
		}
		
		if(qb[si][k] != 0){
			return qb[si][k];
		}
		
		int res = Integer.MAX_VALUE;
		
		for(int cp = si; cp < arr.length; cp++){
			int p1 = sum(arr, si, cp); 
			int p2 = solve(arr, cp + 1, k - 1, qb);
			
			res = Math.min(res, Math.max(p1, p2));
		}
		
		qb[si][k] = res;
		return res;
	}
	
	private static int sum(int[] arr, int i, int j){
		int sum = 0;
		
		for(int k = i; k <= j; k++){
			sum += arr[k];
		}
		
		return sum;
	}
}

// https://www.geeksforgeeks.org/painters-partition-problem/
/* Test case 1 
4
10 10 10 10
2
20
*/

/* Test case 2 
4
10 20 30 40
2
60
*/
