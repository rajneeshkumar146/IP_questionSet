package interview.arrays;

import java.util.Scanner;

public class Pep_JavaIP_1Arrays_3Equilibrium_point {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		int N = scn.nextInt();
		int[] arr = new int[N];
		for (int j = 0; j < N; j++) {
			arr[j] = scn.nextInt();
		}
		System.out.println(equilibrium(arr));
	}

	public static int equilibrium(int arr[]) {
		int totalsum = 0;
		int left = 0;
		// Find sum of the whole array
		for (int i = 0; i < arr.length; ++i)
			totalsum += arr[i];

		for (int i = 0; i < arr.length; ++i) {
			totalsum -= arr[i];
			// totalsum is now right sum for index i

			if (left == totalsum)
				return i;

			left += arr[i];
		}

		/* If no equilibrium index found, then return 0 */
		return -1;
	}
}
