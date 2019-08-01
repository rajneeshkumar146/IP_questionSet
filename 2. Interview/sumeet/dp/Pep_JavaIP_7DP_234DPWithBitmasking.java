package interview.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Pep_JavaIP_7DP_234DPWithBitmasking {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		int caps = Integer.parseInt(scn.nextLine());
		int persons = Integer.parseInt(scn.nextLine());
		
		// who all can wear this cap 
		ArrayList<Integer>[] capMap = new ArrayList[caps + 1];
		for(int i = 1; i < capMap.length; i++){
			capMap[i] = new ArrayList<>();
		}
		
		for(int p = 1; p <= persons; p++){
			String[] capsForP = scn.nextLine().split(" ");
			for(String capForP: capsForP){
				capMap[Integer.parseInt(capForP)].add(p);
			}
		}
		
		System.out.println(solve(capMap, 1, 0, persons, new Integer[caps + 1][(1 << (persons + 1)) - 1])); // why? for 3 -> 1110
	}
	
	private static int solve(ArrayList<Integer>[] capMap, int cap, int mask, int persons, Integer[][] dp){
		if(mask == (1 << (persons + 1)) - 2){ // why? for 3 -> 1110
			return 1;
		}
		
		if(cap == capMap.length){
			return 0;
		}
		
		if(dp[cap][mask] != null){
			return dp[cap][mask];
		}
		
		int count = solve(capMap, cap + 1, mask, persons, dp); // no one wore this cap
		// somebody did
		for(int p: capMap[cap]){
			if((mask & (1 << p)) == 0){
				count = (count % 1000000007 + solve(capMap, cap + 1, mask | (1 << p), persons, dp) % 1000000007) % 1000000007;
			}
		}
		
		dp[cap][mask] = count;
		return count;
	}
}

// https://www.geeksforgeeks.org/bitmasking-and-dynamic-programming-set-1-count-ways-to-assign-unique-cap-to-every-person/
/* Test case 1 
100
3
5 100 1
2
5 100
4
*/

/* Test case 2 
50
5
5 24 1 45
2 3
1 3 7
3 8 9
2 6 7
80
*/

/* Test case 3 
1
4
*/