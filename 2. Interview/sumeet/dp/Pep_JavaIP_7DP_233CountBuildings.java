package interview.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Pep_JavaIP_7DP_233CountBuildings {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		System.out.println(solve(n));
	}
	
	private static int solve(int n){
		int inc = 1;
		int exc = 1;

		for(int i = 2; i <= n; i++){
			int oinc = inc;
			int oexc = exc;
			
			inc = oexc;
			exc = oinc + oexc;
		}
		
		int count = inc + exc;
		return count * count;
	}
}

// https://www.geeksforgeeks.org/count-possible-ways-to-construct-buildings/
/* Test case 1 
3
25
*/

/* Test case 2 
4
64
*/

/* Test case 3 
1
4
*/