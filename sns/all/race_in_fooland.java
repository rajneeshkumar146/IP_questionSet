package SnS;

import java.util.Arrays;
import java.util.Scanner;

public class race_in_fooland {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int test = scn.nextInt();
		for (int t = 0; t < test; t++) {
			int n = scn.nextInt();
			int total = scn.nextInt();
			int[] arr = new int[2 * n];
			for (int i = 0; i < 2 * n; i++) {
				arr[i] = scn.nextInt();
			}
			boolean[] hurdle = new boolean[total + 1];
			int count = 0;
			for (int i = 0; i < 2 * n; i += 2) {
				for (int j = arr[i]; j <= arr[i + 1]; j++) {
					hurdle[j] = true;
				}
			}

			for (int i = 1; i < hurdle.length; i++) {
				if (!hurdle[i]) {
					count++;
				}
			}
			System.out.println(count);
		}

	}
}
