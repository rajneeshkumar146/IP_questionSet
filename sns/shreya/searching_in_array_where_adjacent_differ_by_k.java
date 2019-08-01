package SnS;

import java.util.Scanner;

public class searching_in_array_where_adjacent_differ_by_k {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int test = scn.nextInt();
		for (int t = 0; t < test; t++) {
			int n = scn.nextInt();
			int k = scn.nextInt();
			int[] arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = scn.nextInt();
			}
			int key = scn.nextInt();
			int i = 0;
			int idx = -1;
			while (i < n) {
				if (arr[i] == key) {
					idx = i;
					break;
				} else {
					int step = Math.abs(key - arr[i]) / k;
					if (step == 0) {
						i++;
					} else {
						i += step;
					}

				}
			}
			System.out.println(idx);
		}
	}

}
