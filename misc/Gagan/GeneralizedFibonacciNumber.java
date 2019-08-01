package misc;

import java.util.Scanner;

public class GeneralizedFibonacciNumber {

	public static void main(String[] args) {

//		Scanner s = new Scanner(System.in);
//		int testCase = s.nextInt();
//		for (int i = 0; i < testCase; i++) {
//			int a = s.nextInt();
//			int b = s.nextInt();
//			int c = s.nextInt();
//			int n = s.nextInt();
//			int m = s.nextInt();
//			if (n == 1 || n == 2) {
//				System.out.println(1);
//				continue;
//			}
//			long[][] f = { { a, b, c }, { 1, 0, 0 }, { 0, 1, 0 } };
//			power(a, b, c, f, n - 2, m);
//			System.out.println(((f[0][0] % m) + (f[0][1] % m) + (f[0][2] % m)) % m);
//
//		}

		System.out.println(9 ^ 8);

	}

	public static void power(int a, int b, int c, long[][] f, long n, int mod) {

		long[][] m = { { a, b, c }, { 1, 0, 0 }, { 0, 1, 0 } };

		if (n == 1) {
			return;
		}

		power(a, b, c, f, n / 2, mod);
		multiply(f, f, mod);
		if (n % 2 != 0) {
			multiply(f, m, mod);
		}

	}

	private static void multiply(long[][] f, long[][] f1, int mod) {

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
