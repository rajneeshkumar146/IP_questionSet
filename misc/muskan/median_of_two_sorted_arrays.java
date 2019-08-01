package pep_misc;

import java.util.Arrays;

public class median_of_two_sorted_arrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int r = 3, c = 3;
		int arr[][] = { { 1, 3, 5 }, { 2, 6, 9 }, { 3, 6, 9 } };

		int min = 0;
		int max = 0;
		for (int i = 0; i < r; i++) {
			min = Math.min(min, arr[i][0]);
			max = Math.max(max, arr[i][c - 1]);
		}
		while (min < max) {
			int mid = min + (max - min) / 2;
			int foundat = 0;
			int smaller = 0;
			int half = (r * c + 1) / 2;
			for (int i = 0; i < r; i++) {
				foundat = Arrays.binarySearch(arr[i], mid);
				if (foundat < 0) {
					foundat = -foundat - 1;
				} else {
					while (foundat < c && arr[i][foundat] == mid) {
						foundat++;
					}
				}
				smaller += foundat;
			}
			if (smaller < half) {
				min = mid + 1;
			} else {
				max = mid;
			}
		}
		System.out.println(min);

	}
}
