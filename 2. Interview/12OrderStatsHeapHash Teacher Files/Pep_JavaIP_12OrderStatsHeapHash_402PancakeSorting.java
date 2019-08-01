package OrderStatsHeapHash;

import java.util.Scanner;

public class Pep_JavaIP_12OrderStatsHeapHash_402PancakeSorting {
/**
 * Assuming flip operation take O(1) time.Apply insertion sort idea, key moves from 1 to n-1
 * Put key at correct position
 */
	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		int[] arr = new int[scn.nextInt()];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}
		//Insertion sort loop
		for(int i=1; i<arr.length; i++) {
			// Find index of ceiling of arr[i] in arr[0..i-1] using binary search
			int j=solve(arr, arr[i], 0, i-1);
			
			if (j != -1)
	        {
	            // Put arr[i] before arr[j] using following four flip operations
	            flip(arr,0, j-1);
	            flip(arr,0, i-1);
	            flip(arr,0, i);
	            flip(arr, 0,j);
	        }
			
		}
		
		for(int val : arr) {
			System.out.print(val+" ");
		}
	}
	/* A Binary Search based function to get index of ceiling of x in
   	   arr[low..high] */
	private static int solve(int[] arr, int ceiling_number, int lo, int hi) {
		if (ceiling_number < arr[lo]) {
			return lo;
		}
		if (ceiling_number > arr[hi]) {
			return -1;
		}
		int mid = (lo + hi) / 2;
		if (arr[mid] == ceiling_number) {
			return arr[mid];
		} else if (arr[mid] > ceiling_number) {
			if (mid - 1 >= lo && arr[mid - 1] < ceiling_number) {
				return mid;
			} else {
				return solve(arr, ceiling_number, lo, mid - 1);
			}
		} else {
			if (mid + 1 <= hi && arr[mid + 1] >= ceiling_number) {
				return mid + 1;
			} else {
				return solve(arr, ceiling_number, mid + 1, hi);
			}
		}


	}
	
	private static void flip(int[] arr, int i, int pos) {
		int left = i;
		int right = pos;
		while (left < right) {
			swap(left, right, arr);
			left++;
			right--;
		}

	}
	
	private static void swap(int j, int pivot, int[] arr) {
		int temp = arr[j] ^ arr[pivot];
		arr[j] ^= temp;
		arr[pivot] ^= temp;
	}


}
/**
* Test case
6
1 5 15 20 25 8
``````````````````
1 8 5 15 20 25

9
9 8 7 6 4 5 2 3 1
`````````````````
1 2 3 4 5 6 7 8 9

7
6 -2 1 2 3 4 5
```````````````````
-2 1 2 3 4 5 6

 * Source:https://www.geeksforgeeks.org/a-pancake-sorting-question/
 */
