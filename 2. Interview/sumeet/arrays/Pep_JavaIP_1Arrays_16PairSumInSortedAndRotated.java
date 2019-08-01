package interview.arrays;

import java.util.Scanner;

public class Pep_JavaIP_1Arrays_16PairSumInSortedAndRotated {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int[] arr = new int[scn.nextInt()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}

		solve(arr);
	}

	private static void solve(int[] arr) {
		int sum = 0;
		int iarrisum = 0;

		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
			iarrisum += i * arr[i];
		}

		int omaxsum = iarrisum;
		for (int i = 1; i < arr.length; i++) {
			int riarrisum = iarrisum + (sum - arr.length * arr[arr.length - i]);
			if (riarrisum > omaxsum) {
				omaxsum = riarrisum;
			}
			iarrisum = riarrisum;
		}

		System.out.println(omaxsum);
	}

}
