package BackTracking;

import java.util.Scanner;

public class Express_as_sum_of_power_of_natural_numbers {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		for (int i = 0; i < t; i++) {
			int x = scn.nextInt();
			int n = scn.nextInt();

			int ans = natural(x, n, 1);
			System.out.println(ans);
		}
	}

	private static int natural(int x, int n, int cnum) {
		int val = x - (int) Math.pow(cnum, n);
		if (val == 0) {
			return 1;
		}
		if (val < 0) {
			return 0;
		}
		int ans1 = natural(val, n, cnum + 1);
		int ans2 = natural(x, n, cnum + 1);
		return ans1 + ans2;
	}
}
