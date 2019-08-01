package SnS;

import java.util.Scanner;

public class the_painters_partition_probelem {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int test = scn.nextInt();
		for (int t = 0; t < test; t++) {
			int p = scn.nextInt();
			int n = scn.nextInt();
			int[] arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = scn.nextInt();
			}
			int res = findPaintersPartitions(arr, p);
			System.out.println(res);
		}
	}

	public static int sumOfRange(int[] arr, int start, int end) {

		int sum = 0;
		for (int i = start; i <= end; i++) {
			sum += arr[i];
		}
		return sum;
	}

	public static int findPaintersPartitions(int[] arr, int k) {

		int[][] strg = new int[k + 1][arr.length + 1];

		for (int i = 0; i < strg.length; i++) {

			for (int j = 0; j < strg[0].length; j++) {
				if (i == 0 || j == 0) {
					strg[i][j] = 0;
				} else if (i == 1) {
					strg[i][j] = sumOfRange(arr, 0, j - 1);
				} else if (j == 1) {
					strg[i][j] = arr[0];
				} else {
					int min = Integer.MAX_VALUE;

					for (int p = 1; p <= j; p++) {
						min = Math.min(min, Math.max(strg[i - 1][p], sumOfRange(arr, p, j - 1)));
					}
					strg[i][j] = min;
				}

			}

		}

		return strg[k][arr.length];

	}

}
