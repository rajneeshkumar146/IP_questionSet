package BackTracking;

import java.util.Scanner;

public class Count_no_of_disjoint_subset {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		for (int z = 0; z < t; z++) {
			long n = scn.nextLong();
			long pow3 = xpown(3, n); // total no. of choice(set a or set b or no set)
			long minus = xpown(2, n + 1);
			long ans = (pow3 - minus + 1) % 1000000007;
			System.out.println(ans);
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
		return res % 1000000007;
	}
}
