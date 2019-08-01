package interview.dp;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Pep_JavaIP_7DP_207OptimalBinarySearch {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] keys = new int[n];
		int[] freq = new int[n];
		for(int i = 0; i < n; i++){
			keys[i] = scn.nextInt();
			freq[i] = scn.nextInt();
		}
		
		System.out.println(solve(keys, freq));
	}
	
	private static class Pair implements Comparable<Pair> {
		int key;
		int freq;
		
		Pair(int key, int freq){
			this.key = key;
			this.freq = freq;
		}

		@Override
		public int compareTo(Pair o) {
			return this.key - o.key;
		}
	}
	
	private static int solve(int[] keys, int[] freq){
		Pair[] pairs = new Pair[keys.length];
		for(int i = 0; i < keys.length; i++){
			pairs[i] = new Pair(keys[i], freq[i]);
		}
		
		Arrays.sort(pairs); // in order to create bsts
		
		int[] freqSum = new int[pairs.length];
		freqSum[0] = pairs[0].freq;
		for(int i = 1; i < pairs.length; i++){
			freqSum[i] = freqSum[i - 1] + pairs[i].freq;
		}
		
		int[][] count = new int[keys.length + 1][keys.length + 1];
		for(int gap = 0; gap < keys.length; gap++){
			for(int i = 0, j = i + gap; j < keys.length; i++, j++){
				int min = Integer.MAX_VALUE;
				for(int root = i; root <= j; root++){
					int cost = (root > i? count[i][root - 1]: 0) + // people on left
							   (root < j? count[root + 1][j]: 0) + // people on right
							   freqSum[j] - (i > 0? freqSum[i - 1]: 0); // cost for root as root (searching all levels down)
					
					if(cost < min){
						min = cost;
					}
				}
				
				count[i][j] = min;
			}
		}
	
		return count[0][pairs.length - 1];
	}
}

// https://www.geeksforgeeks.org/dynamic-programming-set-24-optimal-binary-search-tree/
/* Test case 1 
3
10 34
12 8
20 50
142
*/

/* Test case 2 
2
10 34
12 50
118
*/
