package pep_sns;

import java.util.Arrays;

public class minimum_difference_among_k {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {10, 100, 300, 200, 1000, 20, 30};
		// {2, 107, 3, 7, 5, 100, 109, 101, 9, 102};
		int n = arr.length;
		int k = 3;
		Arrays.sort(arr);
		int diff = Integer.MAX_VALUE;
		for (int i = 0; i < n - k + 1; i++) {
			diff = Math.min(diff, arr[i + k - 1] - arr[i]);
		}
		System.out.println(diff);
	}
}
