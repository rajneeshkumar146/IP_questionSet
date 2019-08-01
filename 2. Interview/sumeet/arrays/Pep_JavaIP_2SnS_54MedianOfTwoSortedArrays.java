package interview.arrays;

import java.util.Scanner;

public class Pep_JavaIP_2SnS_54MedianOfTwoSortedArrays {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		int t = scn.nextInt();
		while (t-- > 0) {
			int[] one = new int[scn.nextInt()];
			for (int i = 0; i < one.length; i++) {
				one[i] = scn.nextInt();
			}

			int[] two = new int[scn.nextInt()];
			for (int i = 0; i < two.length; i++) {
				two[i] = scn.nextInt();
			}

			int median = solve(one, 0, one.length - 1, two, 0, two.length - 1, 0, 0);
			System.out.println(median);
		}
	}

	public static int solve(int[] one, int olo, int ohi, int[] two, int tlo, int thi, int smaller, int larger) {
		if ((one.length + two.length) % 2 == 1) {
			int eqbm = (one.length + two.length - 1) / 2;
			if (larger == eqbm) {
				return Math.max(one[ohi], two[thi]);
			} else if (smaller == eqbm) {
				return Math.min(one[olo], two[tlo]);
			}
		} else {
			int eqbm = (one.length + two.length - 2) / 2;
			if (larger == eqbm) {
				return (one[ohi] + two[thi]) / 2;
			} else if (smaller == eqbm) {
				return (one[olo] + two[tlo]) / 2;
			}
		}

		int omid = (olo + ohi) / 2;
		int tmid = (tlo + thi) / 2;
		if (one[omid] < two[tmid]) {
			return solve(one, omid, ohi, two, tlo, tmid, smaller + omid - olo, larger + thi - tmid);
		} else if (two[tmid] < one[omid]) {
			return solve(one, olo, omid, two, tmid, thi, smaller + tmid - tlo, larger + ohi - omid);
		} else {
			return one[omid];
		}
	}

}
