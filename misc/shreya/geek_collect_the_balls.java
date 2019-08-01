package misc;

import java.util.Scanner;

public class geek_collect_the_balls {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int test = scn.nextInt();

		for (int t = 0; t < test; t++) {
			int n = scn.nextInt();
			int m = scn.nextInt();
			int[] arr1 = new int[n];
			int[] arr2 = new int[m];
			for (int i = 0; i < n; i++) {
				arr1[i] = scn.nextInt();
			}

			for (int i = 0; i < m; i++) {
				arr2[i] = scn.nextInt();
			}

			int res = findMaxBalls(arr1, arr2);
			System.out.println(res);
		}
	}

	public static int findMaxBalls(int[] arr1, int arr2[]) {

		int i = 0;
		int j = 0;

		int s1 = 0;
		int s2 = 0;

		int sum = 0;

		while (i < arr1.length && j < arr2.length) {

			if (arr1[i] == arr2[j]) {
				sum += Math.max(s1, s2);
				sum += arr1[i];

				if (j + 1 < arr2.length && arr1[i] == arr2[j + 1]) {
					j++;
				} else if (i + 1 < arr1.length && arr1[i + 1] == arr2[j]) {
					i++;
				} else {
					i++;
					j++;
				}

				s1 = 0;
				s2 = 0;
			} else if (arr1[i] < arr2[j]) {
				s1 += arr1[i];
				i++;
			} else {
				s2 += arr2[j];
				j++;
			}
		}

		while (i < arr1.length) {
			s1 += arr1[i++];
		}

		while (j < arr2.length) {
			s2 += arr2[j++];
		}

		sum += Math.max(s1, s2);
		return sum;
	}
}
