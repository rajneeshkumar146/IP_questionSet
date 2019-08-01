package interview.arrays;

import java.util.Scanner;

public class Pep_JavaIP_1Arrays_9TrappingRainWater {
	public static void main(String[] args) {
		// Geeks
		/*	
 		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();

		while (t-- > 0) {
			int[] arr = new int[scn.nextInt()];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = scn.nextInt();
			}

			solve(arr);
		}
 		*/
		
		// Hackerrank
		Scanner scn = new Scanner(System.in);
		int[] arr = new int[scn.nextInt()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}

		solve(arr);
	}

	private static void solve(int[] arr) {
		int peakValue = Integer.MIN_VALUE;
		int peakValueIdx = -1;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > peakValue) {
				peakValue = arr[i];
				peakValueIdx = i;
			}
		}

		// left to right
		int sumArea = 0;
		int peakSoFar = Integer.MIN_VALUE;
		int countSubmerged = 0;
		int submergedArea = 0;
		for (int i = 0; i <= peakValueIdx; i++) {
			if (arr[i] >= peakSoFar) {
				sumArea += peakSoFar * countSubmerged - submergedArea;
				peakSoFar = arr[i];
				countSubmerged = 0;
				submergedArea = 0;
			} else {
				countSubmerged++;
				submergedArea += arr[i] * 1;
			}
		}

		// right to left
		peakSoFar = Integer.MIN_VALUE;
		countSubmerged = 0;
		submergedArea = 0;
		for (int i = arr.length - 1; i >= peakValueIdx; i--) {
			if (arr[i] >= peakSoFar) {
				sumArea += peakSoFar * countSubmerged - submergedArea;
				peakSoFar = arr[i];
				countSubmerged = 0;
				submergedArea = 0;
			} else {
				countSubmerged++;
				submergedArea += arr[i] * 1;
			}
		}

		System.out.println(sumArea);
	}
}
