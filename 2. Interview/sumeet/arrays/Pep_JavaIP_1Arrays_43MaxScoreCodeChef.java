package interview.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Pep_JavaIP_1Arrays_43MaxScoreCodeChef {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		int n = scn.nextInt();
		int[][] arr = new int[n][n];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] = scn.nextInt();
			}
			Arrays.sort(arr[i]);
		}

		System.out.println(solve(arr));
	}

	private static long solve(int[][] arr) {
		// pointers for all arrays are pointing to ends
		HashMap<Integer, Integer> pointers = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			pointers.put(i, arr.length - 1);
		}

		long res = arr[arr.length - 1][pointers.get(arr.length - 1)];
		int i = arr.length - 2;
		while (i >= 0) {
			// pick an element from lower array only if it is smaller than
			// element of higher array
			while (arr[i][pointers.get(i)] >= arr[i + 1][pointers.get(i + 1)]) {
				if (pointers.get(i) > 0) {
					pointers.put(i, pointers.get(i) - 1);
				} else {
					// run out of valid elements
					return -1;
				}
			}

			// item selected
			res += arr[i][pointers.get(i)];
			i--;
		}

		return res;
	}

}
