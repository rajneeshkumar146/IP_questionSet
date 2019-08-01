package pep_sns;

import java.util.Arrays;

public class maximum_possible_sum_of_products {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int n = 3;
		int[] arr1 = { 1, 2, 3 };
		int[] arr2 = { 4, 5, 1 };
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		long sop = 0;
		for (int i = 0; i < n; i++) {
			sop += arr1[i] * arr2[i];
		}
		System.out.println(sop);

	}

}
