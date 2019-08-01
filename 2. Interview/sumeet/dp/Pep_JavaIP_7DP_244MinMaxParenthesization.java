package interview.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Pep_JavaIP_7DP_244MinMaxParenthesization {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String exp = scn.nextLine();
		
		Pair p = solve(exp, 0, exp.length() - 1, new Pair[exp.length() + 1][exp.length() + 1]);
		System.out.println(p.max);
		System.out.println(p.min);
	}
	
	private static class Pair {
		int min;
		int max;
		
		Pair (int min, int max){
			this.min = min;
			this.max = max;
		}
	}
	
	private static Pair solve(String exp, int i, int j, Pair[][] qb){
		if(i == j){
			int val = exp.charAt(i) - '0';
			return new Pair(val, val);
		}
		
		if(qb[i][j] != null){
			return qb[i][j];
		}
		
		Pair mp = new Pair(Integer.MAX_VALUE, Integer.MIN_VALUE);
		for(int cp = i + 1; cp <= j - 1; cp++){
			char ch = exp.charAt(cp);
			if(ch == '+' || ch == '*'){
				Pair lp = solve(exp, i, cp - 1, qb);
				Pair rp = solve(exp, cp + 1, j, qb);
				
				mp.min = Math.min(mp.min, ch == '+' ? lp.min + rp.min: lp.min * rp.min);
				mp.max = Math.max(mp.max, ch == '+' ? lp.max + rp.max: lp.max * rp.max);
			}
		}
		
		qb[i][j] = mp;
		return mp;
	}

}

// https://www.geeksforgeeks.org/minimum-maximum-values-expression/
/* Test case 1 
1+2*3+4*5
105
27
*/

/* Test case 2 
5*3+8*9
495
87
*/