package SnS;

import java.util.Arrays;
import java.util.Scanner;

public class the_optimal_selection {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int test = scn.nextInt();
		for (int t = 0; t < test; t++) {
			int n = scn.nextInt();
			int[] arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = scn.nextInt();
			}
			int res = 0;
			Arrays.sort(arr);
			for (int i = 0; i < arr.length; i++) {
				res += arr[i] * i;
			}
			System.out.println(res);
		}

	}
}
