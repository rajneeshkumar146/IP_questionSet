package pep_sns;

import java.util.Arrays;

public class friendly_array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {5, 10, 1, 4, 8, 7};
		int n = 6;
		Arrays.sort(arr);
	     int friends = Math.abs(arr[1] - arr[0]) + Math.abs(arr[n - 1] - arr[n - 2]);
	     for(int i=1; i<n-1; i++){
	         int first = Math.abs(arr[i] - arr[i - 1]);
	         int second = Math.abs(arr[i] - arr[i + 1]);
	         friends += Math.min(first, second);
	     }
	     System.out.println(friends);
	}

}
