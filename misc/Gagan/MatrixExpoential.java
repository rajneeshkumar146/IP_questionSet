package misc;

import java.util.Scanner;

public class MatrixExpoential {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		int testCase = s.nextInt();
		int mod = 1000000000 + 7;
		for (int i = 0; i < testCase; i++) {
			long n = s.nextLong();

			if (n == 1) {
				System.out.println(0);
				continue;
			}
			if (n == 2) {
				System.out.println(1);
				continue;
			}

			long[][] f = { { 0, 1, 1 }, { 1, 0, 0 }, { 0, 1, 0 } };
			power(f, n - 2);
			System.out.println(((f[0][0] % mod) + (f[0][2] % mod)) % mod);

		}

	}

	public static void power(long[][] f, long n) {

		long[][] m = { { 0, 1, 1 }, { 1, 0, 0 }, { 0, 1, 0 } };

		if (n == 1) {
			return;
		}

		power(f, n / 2);
		multiply(f, f);
		if (n % 2 != 0) {
			multiply(f, m);
		}

	}

	private static void multiply(long[][] f, long[][] f1) {

		int mod = 1000000000 + 7;
		long[][] ans = new long[f.length][f1[0].length];

		for (int i = 0; i < f.length; i++) {
			for (int j = 0; j < f1[0].length; j++) {
				ans[i][j] = 0;
				for (int k = 0; k < f[0].length; k++) {
					ans[i][j] = (ans[i][j]) % mod + ((f[i][k]) % mod * (f[k][j]) % mod) % mod;
				}
			}
		}

		for (int i = 0; i < ans.length; i++) {
			for (int j = 0; j < ans[0].length; j++) {
				f[i][j] = ans[i][j];
			}
		}

	}

}
