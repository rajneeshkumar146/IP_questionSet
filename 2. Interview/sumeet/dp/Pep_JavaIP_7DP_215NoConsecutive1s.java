package interview.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Pep_JavaIP_7DP_215NoConsecutive1s {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		
		System.out.println(solve(n));
	}
	
	private static int solve(int n){
		int[] endsWith0 = new int[n + 1];
		int[] endsWith1 = new int[n + 1];
		
		endsWith0[1] = 1;
		endsWith1[1] = 1;
		
		for(int i = 2; i <= n; i++){
			endsWith0[i] = endsWith0[i - 1] + endsWith1[i - 1];
			endsWith1[i] = endsWith0[i - 1];
		}
		
		return endsWith0[n] + endsWith1[n];
	}

}

// https://www.geeksforgeeks.org/count-number-binary-strings-without-consecutive-1s/
/* Test case 1 
3
5
*/

/* Test case 2 
5
13
*/

/* Test case 3 
4
8
*/