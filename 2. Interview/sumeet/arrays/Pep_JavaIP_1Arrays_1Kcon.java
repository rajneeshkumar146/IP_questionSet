package interview.arrays;

import java.util.Scanner;

public class Pep_JavaIP_1Arrays_1Kcon {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		int n = scn.nextInt();
		int k = scn.nextInt();

		int[] arr = new int[n];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}

		System.out.println(kconcat(arr, k));
	}

	private static long kconcat(int[] arr, int k) {
		long rv = 0;

		long sum = 0;
		for (int val : arr) {
			sum += val;
		}

		if (k == 1) {
			rv = kadanesModified(arr, 1);
		} else if (sum >= 0) {
			rv = handleSumGreaterThan0(arr, k, sum);
		} else if (sum < 0) {
			rv = kadanesModified(arr, 2);
		}

		return rv;
	}

	private static long handleSumGreaterThan0(int[] arr, int k, long sum) {
		long prefixSum = 0;
		long peakFromLeft = Long.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			prefixSum += arr[i];
			if (prefixSum > peakFromLeft) {
				peakFromLeft = prefixSum;
			}
		}

		long suffixSum = 0;
		long peakFromRight = Long.MIN_VALUE;
		for (int i = arr.length - 1; i >= 0; i--) {
			suffixSum += arr[i];
			if (suffixSum > peakFromRight) {
				peakFromRight = suffixSum;
			}
		}

		return peakFromRight + (k - 2) * sum + peakFromLeft;
	}

	private static long kadanesModified(int[] arr, int k) {
		long csum = arr[0];
		long osum = arr[0];

		int numRuns = k > 1 ? 2 : 1;
		for (int i = 1; i < numRuns * arr.length; i++) {
			if (csum >= 0) {
				csum += arr[i % arr.length];
			} else {
				csum = arr[i % arr.length];
			}

			if (csum >= osum) {
				osum = csum;
			}
		}

		return osum;
	}
}
