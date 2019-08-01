package misc;

import java.util.Scanner;

public class sum_of_xor_of_all_pairs {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int test = scn.nextInt();

		for (int t = 0; t < test; t++) {
			int n = scn.nextInt();
			int[] arr = new int[n];
			long max = Long.MIN_VALUE;
			for (int i = 0; i < n; i++) {
				arr[i] = scn.nextInt();
				max = Math.max(arr[i], max);
			}

			long res = 0;
			for (int k = 0; (1 << k) <= max; k++) {
				long mask = (1 << k);
				int ocount = 0;
				int zcount = 0;
				for (int i = 0; i < n; i++) {
					if ((arr[i] & mask) == mask) {
						ocount++;
					} else {
						zcount++;
					}
				}
				res += (zcount * ocount * mask);
			}
			System.out.println(res);
		}

	}
}
