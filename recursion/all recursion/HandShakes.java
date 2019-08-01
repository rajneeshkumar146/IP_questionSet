package BackTracking;

import java.util.Scanner;

public class HandShakes {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		for (int z = 0; z < t; z++) {
			int n = scn.nextInt();
			System.out.println(Hand(n/2, new int[31]));
		}
	}

	private static int Hand(int n, int[] arr) {
		if (n <= 1) {
			return 1;
		}
		if (arr[n] != 0) {
			return arr[n];
		}
		int res = 0;
		for (int i = 0; i < n; i++) {
			int hand1 = Hand(i, arr);
			int hand2 = Hand(n - i - 1, arr);
			res += (hand1 * hand2);
		}
		arr[n] = res;
		return res;
	}
}
