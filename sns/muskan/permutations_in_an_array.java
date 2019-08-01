package pep_sns;

import java.util.Arrays;

public class permutations_in_an_array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 3;
		int k = 10;
		int[] arr1 = { 2, 1, 3 };
		int[] arr2 = { 7, 8, 9 };

		boolean flag = false;
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		for (int i = 0; i < n; i++) {
			if (arr1[i] + arr2[n - i - 1] < k) {
				flag = true;
				break;
			}
		}
		if (flag == true) {
			System.out.println("0");
		} else {
			System.out.println("1");
		}
	}

}
