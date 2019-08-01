package pep_sns;

import java.util.Arrays;

public class chocolate_distribution_problem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {3, 4, 1, 9, 56, 7, 9, 12}; //{ 7, 3, 2, 4, 9, 12, 56 };
		int m = 5; //3
		Arrays.sort(arr);
		int diff = Integer.MAX_VALUE;
		int r = m - 1; // no of elements in each subarray acc to index
		for (int i = 0; (i + r) < arr.length; i++) {
			int currdiff = arr[i + m - 1] - arr[i];
			if (currdiff < diff)
				diff = currdiff;
		}
		System.out.println(diff);
	}

}
