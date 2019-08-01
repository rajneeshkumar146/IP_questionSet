package pep_sns;

import java.util.Arrays;
import java.util.HashMap;

public class count_elemments_in_two_array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr1 = { 1, 2, 3, 4, 5, 7 };
		int[] arr2 = { 0, 1, 2, 1, 1, 4 };
		countEleLessThanOrEqual(arr1, arr2, 6, 6);

	}

	public static void countEleLessThanOrEqual(int arr1[], int arr2[], int m, int n) {
		Arrays.sort(arr2);
		for(int i=0; i<arr1.length; i++) {
			int ele = arr1[i];
			int low = 0; 
			int high = arr2.length - 1;
			while(low <= high) {
				int mid = (low + high)/2;
				if(arr2[mid] <= ele) {
					low = mid + 1;
				}else {
					high = mid - 1;
				}
			}
			System.out.print((high + 1) + " ");
		}
	}

}
