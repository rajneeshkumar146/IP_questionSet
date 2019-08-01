package pep_sns;

import java.util.Arrays;

public class minimize_sum_of_product {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr1 = { 6, 1, 9, 5, 4 };
		int[] arr2 = { 3, 4, 8, 2, 4 };
		int n = arr1.length;
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		int i = 0;
		int j = n - 1;
		long sop = 0;
		while (i < n) {
			sop += arr1[i] * arr2[j];
			i++;
			j--;
		}
		System.out.println(sop);

	}

}
