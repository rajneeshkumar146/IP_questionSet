package SnS;

import java.util.Scanner;

public class smallest_greater_element_in_whole_array {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int test = scn.nextInt();
		for (int t = 0; t < test; t++) {
			int n = scn.nextInt();
			int[] arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = scn.nextInt();
			}

			for (int i = 0; i < arr.length; i++) {
				int diff = Integer.MAX_VALUE;
				int nl = Integer.MIN_VALUE;
				for (int j = 0; j < arr.length; j++) {
					if (i != j) {
						int val = arr[j] - arr[i];
						if (arr[i] < arr[j] && val < diff) {
							nl = arr[j];
							diff = val;
						}
					}
				}
				if (nl == Integer.MIN_VALUE) {
					System.out.print("_ ");
				} else {
					System.out.print(nl + " ");
				}
			}

			System.out.println();
		}
	}
}
