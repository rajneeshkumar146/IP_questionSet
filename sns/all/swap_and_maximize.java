package SnS;

import java.util.Arrays;
import java.util.Scanner;

public class swap_and_maximize {

	public static void main (String[] args) {
		Scanner scn = new Scanner(System.in);
		int test = scn.nextInt();
		for (int t = 0; t < test; t++) {
			int n = scn.nextInt();
			int[] arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = scn.nextInt();
			}
			Arrays.sort(arr);
			int res=0;
			for (int i = 0; i < arr.length/2; i++) {
				res -=(2*arr[i]);
				res +=(2*arr[arr.length-1-i]);
			}
			System.out.println(res);
		}

	}
}
