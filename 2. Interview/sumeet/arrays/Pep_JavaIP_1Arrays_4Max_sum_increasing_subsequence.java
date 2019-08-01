package interview.arrays;

import java.util.Arrays;
import java.util.Scanner;

public class Pep_JavaIP_1Arrays_4Max_sum_increasing_subsequence {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}
		
		solve(arr);
	}

	private static void solve(int[] arr) {
		int[] lis = new int[arr.length];
		String[] plis = new String[arr.length];

		Arrays.fill(plis, "");
		lis[0] = arr[0];
		plis[0] = arr[0] + "";

		int omax = 0;
		String opath = "";

		for (int i = 1; i < arr.length; i++) {
			for (int j = 0; j <= i - 1; j++) {
				if (arr[j] < arr[i]) {
					if (lis[j] > lis[i]) {
						lis[i] = lis[j];
						plis[i] = plis[j];
					}
				}
			}

			lis[i] += arr[i];
			plis[i] = plis[i] + " " + arr[i];
			if (lis[i] > omax) {
				omax = lis[i];
				opath = plis[i];
			}

		}

		System.out.println(omax);
		//System.out.println(opath);
	}

}
