package interview.arrays;

import java.util.Arrays;
import java.util.Scanner;

public class Pep_JavaIP_2SnS_57TripletsLessThanEqualToSum {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		int[] arr = new int[scn.nextInt()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}
		int sum = scn.nextInt();

		solve(arr, sum);
	}

	private static void solve(int[] arr, int sum) {
		Arrays.sort(arr);

		int count = 0;
		// iterator moving (i can't go beyond n - 2, has to have space for j and k)
		for (int i = 0; i < arr.length - 2; i++) {
			// the meet in middle trick for j and k
			int j = i + 1;
			int k = arr.length - 1;
			
			while(j < k){
				// too high a sum, reduce k
				if(arr[i] + arr[j] + arr[k] > sum){
					k--;
				} else {
					// if the sum is low for this k (and i, j) 
					// it'll be low for all values of k from j + 1 to k
					count += k - j;
					// trying a higher sum combination of i, j and k.
					j++;
				}
			}
		}
		
		System.out.println(count);
	}
}
