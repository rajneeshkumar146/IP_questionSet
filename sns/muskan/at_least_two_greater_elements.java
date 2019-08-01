package pep_sns;

import java.util.Arrays;

public class at_least_two_greater_elements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {7, -2, 3, 4, 9, -1};
		except2largest(arr);
	}
	
	public static void except2largest(int[] arr) {
		Arrays.sort(arr);
		for(int i=0; i<arr.length - 2; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

}
