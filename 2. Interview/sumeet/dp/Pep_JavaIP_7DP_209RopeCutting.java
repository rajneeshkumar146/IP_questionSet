package interview.dp;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Pep_JavaIP_7DP_209RopeCutting {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		
		for(int c = 1; c <= n; c++){
			System.out.print(solve(c) + " ");
			System.out.print(solve2(c) + " ");
			
			for(int i = 1; i <= c / 2; i++){
				brute(c - i, i);
			}
			System.out.println(max);
		}
	}
	
	private static int solve(int n){
		int[] f = new int[n + 1];
		
		for(int i = 1; i < f.length; i++){
			for(int j = 1; j <= i/2; j++){
				f[i] = Math.max(f[i], j * (i - j));
				f[i] = Math.max(f[i], j * f[i - j]);
			}
		}
		
		return f[n];
	}
	
	private static int solve2(int n){
		int[] f = new int[n + 1];
		
		for(int i = 1; i < f.length; i++){
			for(int j = 1; j <= i/2; j++){
				f[i] = Math.max(f[i], j * (i - j));
				f[i] = Math.max(f[i], j * f[i - j]);
				f[i] = Math.max(f[i], f[j] * f[i - j]);
			}
		}
		
		return f[n];
	}
	
	static int max = Integer.MIN_VALUE;
	private static void brute(int n, int psf){
		if(n == 1){
			max = Math.max(max, psf);
			return;
		}
		
		max = Math.max(max, psf * n);
		for(int i = 1; i <= n/2; i++){
			brute(n - i, psf * i);
		}
	}
}

// https://www.geeksforgeeks.org/dynamic-programming-set-36-cut-a-rope-to-maximize-product/
/* Test case 1 
10
36
*/

/* Test case 2 
5
6
*/