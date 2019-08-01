package pep_sns;

import java.util.Arrays;

public class find_closest_pair_from_two_arrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int m = 4;
		int n = 4;
		int[] arr1 = { 1, 4, 5, 7};
		int[] arr2 = { 10, 20, 30, 40 };
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		int sum = 32;
		int left = 0;
		int right = n - 1;
		int li = 0;
		int ri = 0;
		int diff = Integer.MAX_VALUE;
		while (left < m && right >= 0) {
			int currdiff = Math.abs(arr1[left] + arr2[right] - sum);
			if (currdiff < diff) {
				diff = currdiff;
				li = left;
				ri = right;
			}
			if (arr1[left] + arr2[right] < sum) {
				left++;
			} else {
				right--;
			}
		}
		System.out.println(arr1[li] + " " + arr2[ri]);
	}

}
