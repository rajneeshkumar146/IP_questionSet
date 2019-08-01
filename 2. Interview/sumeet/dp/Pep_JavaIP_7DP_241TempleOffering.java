package interview.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Pep_JavaIP_7DP_241TempleOffering {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i < n; i++){
			arr[i] = scn.nextInt();
		}
		System.out.println(solve(arr));
	}
	
	// alternate - ddiidid
	private static int solve(int[] arr){
		int[] leftStrg = new int[arr.length];
		int[] rightStrg = new int[arr.length];

		leftStrg[0] = 1;
		for(int i = 1; i < arr.length; i++){
			if(arr[i - 1] < arr[i]){
				leftStrg[i] = leftStrg[i - 1] + 1;
			} else {
				leftStrg[i] = 1;
			}
		}
		
		rightStrg[arr.length - 1] = 1;
		for(int i = arr.length - 2; i >= 0; i--){
			if(arr[i + 1] < arr[i]){
				rightStrg[i] = rightStrg[i + 1] + 1;
			} else {
				rightStrg[i] = 1;
			}
		}
		
		int res = 0;
		for(int i = 0; i < arr.length; i++){
			res += Math.max(leftStrg[i], rightStrg[i]);
		}
		
		return res;
	}

}

// https://www.geeksforgeeks.org/temple-offerings/
/* Test case 1 
3
1 2 2
4
*/

/* Test case 2 
6
1 4 3 6 2 1
10
*/