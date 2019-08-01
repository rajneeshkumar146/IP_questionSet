package interview.dp;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Pep_JavaIP_7DP_221WordWrap {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int[] arr = new int[scn.nextInt()];
		for(int i = 0; i < arr.length; i++){
			arr[i] = scn.nextInt();
		}
		int m = scn.nextInt();
		
		solve(arr, m)	;
	}
	
	private static void solve(int[] arr, int m){
		int[] psum = new int[arr.length];
		psum[0] = arr[0];
		for(int i = 1; i < arr.length; i++){
			psum[i] = arr[i] + psum[i - 1];
		}
		
		Integer[][] lineCost = new Integer[arr.length][arr.length];
		for(int gap = 0; gap < arr.length; gap++){
			for(int i = 0, j = i + gap; j < arr.length; i++, j++){
				int extra = m - psum[j] + (i > 0? psum[i - 1]: 0) - gap;
				extra = extra >= 0 && j == arr.length - 1? 0: extra; // extra spaces after last word doesn't add to cost
				
				if(extra >= 0){
					lineCost[i][j] = extra * extra;
				}
			}
		}
		
		// something like lis
		Integer[] cost = new Integer[arr.length];
		Integer[] prev = new Integer[arr.length];
		for(int i = 0; i < arr.length; i++){
			cost[i] = lineCost[0][i]; // solving for i -> optimal cost for words till i
			for(int j = 0; j < i; j++){ // candidates from 0 to i - 1
				if(cost[j] != null && 
				   lineCost[j + 1][i] != null){
					if(cost[i] == null ||
					   cost[j] + lineCost[j + 1][i] < cost[i]){
						cost[i] = cost[j] + lineCost[j + 1][i];
						prev[i] = j;
					}
				}
			}
		}
		
		LinkedList<String> stack = new LinkedList<>(); 
		Integer i = prev.length - 1;
		while(i != null){
			stack.addFirst((prev[i] != null? prev[i] + 1: 0) + " to " + i);
			i = prev[i];
		}
		
		System.out.println(stack);
	}
}

// https://www.geeksforgeeks.org/dynamic-programming-set-18-word-wrap/
/* Test case 1 
4
3 2 2 5
6
[0 to 0, 1 to 2, 3 to 3]
*/

/* Test case 2 
7
5 3 5 8 4 4 7
15
[0 to 2, 3 to 4, 5 to 6]
*/
