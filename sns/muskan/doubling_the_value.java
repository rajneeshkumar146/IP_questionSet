package pep_sns;

import java.util.Arrays;

public class doubling_the_value {

	public static void main(String[] args) {
		//given sorted array
		
		int n = 5;
		long x = 2;
		long[] arr = { 1, 2, 3, 4, 8 };

		for (int i = 0; i < n; i++) {
			if (arr[i] == x) {
				x = x * 2;
			}
		}
		System.out.println(x);
		
		//if not sorted, sort and use binary search repeatedly
		long max = Integer.MIN_VALUE;
		for(long val: arr)
			max = Math.max(max, val);
		while(x < max) {
			Arrays.sort(arr);
			int left = 0; 
			int right = arr.length;
			while(left <= right) {
				int mid = (left + right) / 2;
				if(arr[mid] == x) {
					x = x*2;
					break;
				}
				if(arr[mid] < x) {
					left = mid + 1;
				}else {
					right = mid - 1;
				}
			}
		}
		System.out.println(x);
	}
}
