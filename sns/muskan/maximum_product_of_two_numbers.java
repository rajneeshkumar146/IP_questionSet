package pep_sns;

import java.util.Arrays;

public class maximum_product_of_two_numbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1, 100, 42, 4, 23};
		Arrays.sort(arr);
	     System.out.println(arr[arr.length - 1]*arr[arr.length - 2]);

	}

}
