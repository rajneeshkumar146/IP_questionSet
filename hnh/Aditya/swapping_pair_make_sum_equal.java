package may28;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class swapping_pair_make_sum_equal {
	public static void main(String[] args) {

		// sum1 - x + y = sum2 - y + x
		// 2(y - x) = sum2 - sum1
		// 2(y - x) = diff
		// y = x + diff/2

		Scanner scn = new Scanner(System.in);

		int t = scn.nextInt();

		for (int tc = 0; tc < t; tc++) {

			int n = scn.nextInt();
			int m = scn.nextInt();

			int sum1 = 0;
			int sum2 = 0;

			HashSet<Integer> arr1 = new HashSet<>();
			HashSet<Integer> arr2 = new HashSet<>();

			for (int i = 0; i < n; i++) {
				int val = scn.nextInt();
				arr1.add(val);
				sum1 += val;
			}

			for (int i = 0; i < m; i++) {
				int val = scn.nextInt();
				arr2.add(val);
				sum2 += val;
			}

			int diff;
			if (sum1 > sum2) {
				diff = sum1 - sum2;
			} else {
				diff = sum2 - sum1;
			}

			if (diff % 2 == 1) {
				System.out.println(-1);
				break;
			}

			diff /= 2;

			HashSet<Integer> largersumarr = sum1 > sum2 ? arr1 : arr2;
			HashSet<Integer> smallersumarr = sum1 < sum2 ? arr1 : arr2;

			int cap = 0;
			for (int val : smallersumarr) {
				if (cap == smallersumarr.size()) {
					System.out.println(-1);
					break;
				}
				if (largersumarr.contains(val + diff)) {
					System.out.println(1);
				}
				cap++;
			}

		}

	}

}
