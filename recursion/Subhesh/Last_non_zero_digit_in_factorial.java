package BackTracking;

import java.util.Scanner;

public class Last_non_zero_digit_in_factorial {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		for (int z = 0; z < t; z++) {
			int n = scn.nextInt();
			System.out.println(LastNonZero(n));
		}
	}

	static int[] arr = { 1, 1, 2, 6, 4 };

	private static int LastNonZero(int n) {
		if (n == 0) {
			return 1;
		}

		int x = n / 5;
		int y = n % 5;
		int tillnow = LastNonZero(x);
		int pow1 = (int) Math.pow(2, x);
		int prd = pow1 * tillnow * arr[y];

		while (prd % 10 == 0) {
			prd = prd / 10;
		}
		return prd % 10;
	}
}
