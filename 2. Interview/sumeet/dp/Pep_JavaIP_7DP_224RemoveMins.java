package interview.dp;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Pep_JavaIP_7DP_224RemoveMins {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int[] arr = new int[scn.nextInt()];
		for(int i = 0; i < arr.length; i++){
			arr[i] = scn.nextInt();
		}
		
		System.out.println(solve(arr));
	}
	
	// alternate - use the gap strategy
	private static int solve(int[] arr){ 
		// longest subarray which honors the property has least removals
		
		int len = 0;
		
		for(int i = 0; i < arr.length; i++){
			int min = Integer.MAX_VALUE;
			int max = Integer.MIN_VALUE;
			
			for(int j = i; j < arr.length; j++){
				max = Math.max(max, arr[j]);
				min = Math.min(min, arr[j]);
				
				if(2 * min <= max){
					break; // property can't become true now, future mins will be even smaller and maxes even larger 
				}
				
				len = Math.max(len, j - i + 1);
			}
		}
		
		return arr.length - len;
	}
}

// https://www.geeksforgeeks.org/remove-minimum-elements-either-side-2min-max/
/* Test case 1 
9
4 5 100 9 10 11 12 15 200
4
*/

/* Test case 2 
4
20 4 1 3
3
*/
