package interview.arrays;

import java.util.Arrays;
import java.util.Scanner;

public class Pep_JavaIP_1Arrays_6findpair {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int diff = scn.nextInt();

		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}

		solve(diff, arr);
	}

	private static void solve(int diff, int[] arr) {
		Arrays.sort(arr);

		int start = 0;
		int end = 1;
		boolean found = false;

		while (start < arr.length && end < arr.length) {
			int cdiff = arr[end] - arr[start];

			if (cdiff > diff) {
				start++;
			} else if (cdiff < diff) {
				end++;
			} else {
				if (start != end) {
					System.out.println(arr[start] + " " + arr[end]);
					found = true;
				}
				
				end++;
			}
		}
		
		if(!found) {
			System.out.println(-1);
		}
	}

}
