package BackTracking;

import java.util.Scanner;

public class Power_of_Numbers {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		for (int z = 0; z < t; z++) {
			int x = scn.nextInt();
			int temp = x;
			int n = 0;
			while (temp != 0) {
				int rem = temp % 10;
				temp = temp / 10;
				n = n * 10 + rem;
			}
			System.out.println(xpown(x, n));
		}
	}

	public static long xpown(long x, long n) {
		long res = 1;
		while (n > 0) {
			if (n % 2 != 0) {
				res = (res * x) % 1000000007;
				n--;
			} else {
				x = (x * x) % 1000000007;
				n = n / 2;
			}
		}
		return res;
	}
}
