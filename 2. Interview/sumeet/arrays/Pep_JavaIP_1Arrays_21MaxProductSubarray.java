package interview.arrays;

import java.util.Scanner;

public class Pep_JavaIP_1Arrays_21MaxProductSubarray {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int[] arr = new int[scn.nextInt()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}

		solve(arr);
	}

	private static void solve(int[] arr) {
		int min = 1;
		int max = 1;
		int omax = Integer.MIN_VALUE;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 0) { // split the sequences at the 0's
				min = 1; // setting the product default value because 0 means start of a new sequence
				max = 1; // setting the product default value because 0 means start of a new sequence
				omax = omax < 0? 0: omax; // if omax is negative till now and you find a 0, it becomes a 0.
				continue;
			}

			int f1 = arr[i]; // may contribute to both min and max
			int f2 = arr[i] * min; // may contribute to both min and max
			int f3 = arr[i] * max; // may contribute to both min and max

			// every number has 3 choices, to start its own or append at the back of previous min or max
			min = Math.min(f1, Math.min(f2, f3));
			max = Math.max(f1, Math.max(f2, f3));

			if (max > omax) {
				omax = max;
			}
		}
		
		System.out.println(omax);
	}
}
