package pep_sns;

import java.util.Arrays;

//MAXIMIZE ∑ARR[I]*I OF AN ARRAY

public class maximize_sum_arri_i_of_an_array {

	public static void main(String[] args) {
		int n = 5;
		int[] arr = { 5, 3, 2, 4, 1 };
		Arrays.sort(arr);
		long sum = 0;
		for (int i = 0; i < n; i++) {
			sum += arr[i] * i;
		}
		long mod = (long) Math.pow(10, 9) + (long) 7;
		System.out.println(sum % mod);
	}

}
