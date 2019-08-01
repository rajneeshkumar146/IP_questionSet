package pep_sns;

import java.util.Arrays;

public class minimum_subsets_with_consecutive_numbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 100, 56, 5, 6, 102, 58, 101, 57, 7, 103 };
		int count = 1;
		Arrays.sort(arr);
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i + 1] != arr[i] + 1) {
				count++;
			}
		}
		System.out.println(count);

	}

}
