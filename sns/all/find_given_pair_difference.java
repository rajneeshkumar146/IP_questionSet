package pep_sns;

import java.util.Arrays;

public class find_given_pair_difference {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 6;
		int range = 78;
		int[] arr = { 5, 20, 3, 2, 5, 80 };
		Arrays.sort(arr);
		int i = 0, j = 1;
		boolean flag = false;
		while (i < arr.length && j < arr.length) {
			if (i != j && arr[j] - arr[i] == range) {
				flag = true;
				break;
			} else if (arr[j] - arr[i] < range)
				j++;
			else
				i++;
		}
		if (!flag)
			System.out.println("-1");
		else
			System.out.println("1");

	}

}
