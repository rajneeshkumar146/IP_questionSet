package interview.dp;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Pep_JavaIP_7DP_208MinInsertionsPalindrome {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.nextLine();
		
		System.out.println(solve(str));
	}
	
	private static int solve(String str){
		int[][] f = new int[str.length()][str.length()];
		
		for(int gap = 1; gap < str.length(); gap++){
			for(int i = 0, j = i + gap; j < str.length(); i++, j++){
				if(gap == 1){
					f[i][j] = str.charAt(i) != str.charAt(j)? 1: 0;
				} else {
					if(str.charAt(i) == str.charAt(j)){
						f[i][j] = f[i + 1][j - 1];
					} else {
						f[i][j] = Math.min(f[i + 1][j], f[i][j - 1]) + 1;
					}
				}
			}
		}
		
		return f[0][str.length() - 1];
	}
	

}

// https://www.geeksforgeeks.org/dynamic-programming-set-28-minimum-insertions-to-form-a-palindrome/
/* Test case 1 
abccbc
2
*/

/* Test case 2 
geeks
3
*/