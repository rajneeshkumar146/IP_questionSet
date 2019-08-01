package pep_sns;

import java.util.Arrays;

public class part_sort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 7, 8, 5, 9, 3, 4, 5, 2, 6, 1 };
		int a = 9;
		int b = 6;
		if (a > b) {
			a = a + b;
			b = a - b;
			a = a - b;
		}
		Arrays.sort(arr, a, b + 1);
		for (int val : arr) {
			System.out.print(val + " ");
		}
		System.out.println();

	}

}
