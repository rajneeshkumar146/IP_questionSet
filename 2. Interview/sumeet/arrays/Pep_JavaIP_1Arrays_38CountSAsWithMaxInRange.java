package interview.arrays;

import java.util.Scanner;

public class Pep_JavaIP_1Arrays_38CountSAsWithMaxInRange {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		int[] arr = new int[scn.nextInt()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}
		int lo = scn.nextInt();
		int hi = scn.nextInt();

		int count = solve(arr, lo, hi);
		System.out.println(count);
	}

	// Sample test case
	// n = 14
	// arr = 2 3 9 4 5 10 18 1 2 3 7 0 1 8
	// lo = 5, hi = 12
	private static int solve(int[] arr, int lo, int hi) {
		int count = 0;

		int inc = 0;
		int exc = 0;
		for(int i = 0; i < arr.length; i++){
			if(arr[i] < lo){
				// both inclusion and exclusion sub-array grows
				inc++;
				exc++;
			} else if(arr[i] >= lo && arr[i] <= hi){
				// collect the data from old exclusion sub-arrays
				count -= countElementsInSA(exc);
				
				// inclusion sub-array continues to grow, exclusion sub-array restarts
				inc++;
				exc = 0;
			} else {
				// collect the data from old inclusion and exclusion sub-arrays.
				count += countElementsInSA(inc);
				count -= countElementsInSA(exc);
				
				// a new exclusion and inclusion sub-array starts
				inc = 0;
				exc = 0;
			}
		}
		
		count += countElementsInSA(inc);
		count -= countElementsInSA(exc);

		return count;
	}

	public static int countElementsInSA(int n) {
		return n * (n + 1) / 2;
	}

}
