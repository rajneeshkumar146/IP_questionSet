package BackTracking;

import java.util.Scanner;

public class Divisibility {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		for (int z = 0; z < t; z++) {
			int n = scn.nextInt();
			int[] arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = scn.nextInt();
			}
			long k = scn.nextLong();
			long ans = solve(1, 0, arr, 0, k);
			System.out.println(ans);
		}
	}

	private static long solve(long curr, int cnt, int a[], int next, long k) {
		long ans = 0;
		if (next < a.length) {
			ans = solve(curr, cnt, a, next + 1, k);
			curr = lcm(curr, a[next]);
			cnt++;
			long tmp = k / curr;
			if (cnt % 2 == 0)
				ans += -tmp;
			else
				ans += tmp;
			ans += solve(curr, cnt, a, next + 1, k);
		}
		// System.out.println(curr + " " + cnt + " " + next + " " + ans);
		return ans;
	}

	private static long gcd(long a, long b) {
		return b == 0 ? a : gcd(b, a % b);
	}

	private static long lcm(long a, int b) {
		return (a * b) / gcd(a, b);
	}

}
