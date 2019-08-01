package SnS;

import java.util.Arrays;
import java.util.Scanner;

public class the_probelem_of_identical_arrays {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int tc = scn.nextInt();
		for (int j = 0; j < tc; j++) {
			int n = scn.nextInt();
			int[] arr1 = new int[n];
			int[] arr2 = new int[n];
			for (int i = 0; i < n; i++) {
				arr1[i] = scn.nextInt();
			}
			for (int i = 0; i < n; i++) {
				arr2[i] = scn.nextInt();
			}

			Arrays.sort(arr1);
			Arrays.sort(arr2);

			int flag = 1;
			for (int i = 0; i < n; i++) {
				if (arr1[i] != arr2[i]) {
					flag = 0;
					break;
				}
			}
			System.out.println(flag);
		}
	}

}
