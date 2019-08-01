package pep_sns;

import java.util.Arrays;

public class minimize_sum_of_alternate_product {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 9, 2, 8, 4, 5, 7, 6, 0 };
		int n = arr.length;
		Arrays.sort(arr);
		long sop = 0;
		for (int i = 0, j = n - 1; i <= n - 1 && i <= j; i++, j--) {
			sop += arr[i] * arr[j];
		}
		System.out.println(sop);


	}

}
