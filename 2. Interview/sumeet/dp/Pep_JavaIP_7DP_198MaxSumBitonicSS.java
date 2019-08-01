package interview.dp;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Pep_JavaIP_7DP_198MaxSumBitonicSS {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int[] arr = new int[scn.nextInt()];
		for(int i = 0; i < arr.length; i++){
			arr[i] = scn.nextInt();
		}
		
		System.out.println(maxsumbitonic(arr));
	}
	
	private static int maxsumbitonic(int[] arr){
		Integer[] msis = new Integer[arr.length];
		
		msis[0] = arr[0];
		for(int i = 1; i < arr.length; i++){
			msis[i] = arr[i];
			
			for(int j = 0; j < i; j++){
				if(arr[j] < arr[i]){
					if(msis[j] + arr[i] > msis[i]){
						msis[i] = msis[j] + arr[i];
					}
				}
			}
		}
		
		Integer[] msds = new Integer[arr.length];
		
		msds[arr.length - 1] = arr[arr.length - 1];
		for(int i = arr.length - 1; i >= 0; i--){
			msds[i] = arr[i];
			
			for(int j = i + 1; j < arr.length; j++){
				if(arr[j] < arr[i]){
					if(msds[j] + arr[i] > msds[i]){
						msds[i] = msds[j] + arr[i];
					}
				}
			}
		}
		
		int res = Integer.MIN_VALUE;
		for(int i = 0; i < arr.length; i++){
			if(msis[i] + msds[i] - arr[i] > res){
				res = msis[i] + msds[i] - arr[i];
			}
		}
		return res;
	}

}

// https://www.geeksforgeeks.org/maximum-sum-bi-tonic-sub-sequence/
/* Test case 1 
9
1 15 51 45 33 100 12 18 9 
194
*/

/* Test case 2 
6 
80 60 30 40 20 10
210
*/