package misc;

import java.util.Scanner;

public class MincutPowerOf5 {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		int testCase = s.nextInt();
		for (int i = 0; i < testCase; i++) {
			String str = s.next();
			int ans = mincuts(str, 0, str.length() - 1, new int[str.length()][str.length()]);
			if (ans == -1) {
				System.out.println(ans);
			} else {
				System.out.println(ans + 1);
			}
		}

	}

	public static int mincuts(String str, int si, int ei, int[][] qb) {

		if (qb[si][ei] != 0) {
			return qb[si][ei];
		}
		if (si == ei && isPowerOf5(str, si, ei)) {
			return 0;
		} else if (si == ei) {
			return -1;
		}
		if (isPowerOf5(str, si, ei)) {
			return 0;
		}

		int min = -1;
		for (int cp = si; cp < ei; cp++) {

			int mincuts1 = mincuts(str, si, cp, qb);
			int mincuts2 = mincuts(str, cp + 1, ei, qb);
			if (mincuts1 == -1 || mincuts2 == -1) {
				continue;
			} else {
				int totalCuts = mincuts1 + mincuts2 + 1;
				if (min == -1) {
					min = totalCuts;
				} else {
					min = Math.min(min, totalCuts);
				}
			}

//			if (mincuts1 == -1 || mincuts2 == -1) {
//				if (min == -1) {
//					min = -1;
//				}
//			}
//
//			else {
//				totalCuts = mincuts1 + mincuts2 + 1;
//				min = (min == -1) ? totalCuts : Math.min(min, totalCuts);
//			}

		}
		qb[si][ei] = min;
		return min;

	}

	private static boolean isPowerOf5(String str, int si, int ei) {

		String str1 = str.substring(si, ei + 1);
		long num = Long.parseLong(str1, 2);

		return chknum(num);

	}

	static boolean chknum(long n) {
		if (n < 125)
			return (n == 1 || n == 5 || n == 25);
		if (n % 125 != 0)
			return false;
		else
			return chknum(n / 125);
	}

}
