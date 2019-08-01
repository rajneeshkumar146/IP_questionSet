package OrderStatsHeapHash;

import java.util.Scanner;

public class Pep_JavaIP_12OrderStatsHeapHash_402PancakeSorting {

	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		int[] arr = new int[scn.nextInt()];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}
		
		for(int i=1; i<arr.length; i++) {
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
