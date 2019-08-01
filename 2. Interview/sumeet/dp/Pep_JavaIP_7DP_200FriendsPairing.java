package interview.dp;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Pep_JavaIP_7DP_200FriendsPairing {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		
		System.out.println(solve(n));
	}
	
	private static int solve(int n){
		int[] f = new int[n + 1];
		
		f[0] = 0; // redundant
		f[1] = 1;
		f[2] = 2;
		
		for(int i = 3; i < f.length; i++){
			f[i] = f[i - 1] + (i - 1)*f[i - 2];
		}
		
		return f[n];
	}
	

}

// https://www.geeksforgeeks.org/friends-pairing-problem/
/* Test case 1 
3
4
*/

/* Test case 2 
5
26
*/