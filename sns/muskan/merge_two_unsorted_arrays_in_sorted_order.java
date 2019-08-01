package pep_sns;

import java.util.Arrays;

public class merge_two_unsorted_arrays_in_sorted_order {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 4;
		int m = 5;
		int[] arr1 = {10, 5, 15, 6};
		int[] arr2 = {20, 3, 2, 4, 9};
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		int[] arr3 = new int[m + n];
		int i = 0;
		int j = 0;
		int k = 0;
		while (i < n && j < m) {
			if (arr1[i] < arr2[j]) {
				arr3[k] = arr1[i];
				i++;
			} else {
				arr3[k] = arr2[j];
				j++;
			}
			k++;
		}
		while (i < n) {
			arr3[k] = arr1[i];
			i++;
			k++;
		}

		while (j < m) {
			arr3[k] = arr2[j];
			j++;
			k++;
		}
		for (int val : arr3) {
			System.out.print(val + " ");
		}
		System.out.println();

	}

}
