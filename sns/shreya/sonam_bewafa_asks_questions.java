package SnS;

import java.util.Scanner;

public class sonam_bewafa_asks_questions {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int test = scn.nextInt();
		for (int t = 0; t < test; t++) {
			int n = scn.nextInt();
			int q = scn.nextInt();
			long[] interval = new long[2 * n];
			for (int i = 0; i < 2 * n; i++) {
				interval[i] = scn.nextLong();
			}
			long[] queries = new long[q];

			long[] groups = new long[n];
			int j = 0;
			for (int i = 1; i < 2 * n; i += 2) {
				groups[j] = interval[i] - interval[i - 1] + 1;
				if (i / 2 != 0) {
					groups[j] += groups[j - 1];
				}
				j++;
			}
			for (int i = 0; i < q; i++) {
				queries[i] = scn.nextLong();
				System.out.print(findRank(groups, interval, queries[i]) + " ");
			}
			System.out.println();
		}

	}

	public static long findRank(long[] groups, long[] interval, long query) {

		int low = 0;
		int high = groups.length - 1;
		int ans = groups.length - 1;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (groups[mid] == query) {
				ans = mid;
				break;
			} else if (groups[mid] < query) {
				low = mid + 1;
			} else {
				high = mid - 1;
				ans = mid;
			}
		}

		long pos = ans > 0 ? query - groups[ans - 1] : query;
		return pos + interval[2 * ans] - 1l;
	}
}
