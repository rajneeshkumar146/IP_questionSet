package BackTracking;

import java.util.Scanner;

public class N_Digit_numbers_with_digits_in_increasing_order {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		for (int z = 0; z < t; z++) {
			int n = scn.nextInt();
			increasing(n, 0, "", 1);
			System.out.println();
		}
	}

	private static void increasing(int n, int ccount, String nsf, int beginidx) {
		if (ccount == n) {
			System.out.print(nsf+" ");
			return;
		}
		for (int i = beginidx; i < 10; i++) {
			increasing(n, ccount + 1, nsf + i, i + 1);
		}
	}
}
