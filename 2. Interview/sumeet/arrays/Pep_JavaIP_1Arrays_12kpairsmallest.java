package interview.arrays;

import java.util.Scanner;

public class Pep_JavaIP_1Arrays_12kpairsmallest {
	public static void main(String[] args) {
		// Geeks

		// Hackerrank
		Scanner scn = new Scanner(System.in);
		int[] one = new int[scn.nextInt()];
		for (int i = 0; i < one.length; i++) {
			one[i] = scn.nextInt();
		}
		
		int[] two = new int[scn.nextInt()];
		for (int i = 0; i < two.length; i++) {
			two[i] = scn.nextInt();
		}
		
		int k = scn.nextInt();
		solve(one, two, k);
	}

	private static void solve(int[] one, int[] two, int k) {
		// keys are one's indices, values are two's indices
		int[] idxMap = new int[one.length];

		for (int i = 0; i < k; i++) {
			int min = Integer.MAX_VALUE;
			int oneIdx = -1;
			int twoIdx = -1;

			for (int j = 0; j < idxMap.length; j++) {
				if (idxMap[j] == two.length) {
					continue;
				}

				if (one[j] + two[idxMap[j]] < min) {
					min = one[j] + two[idxMap[j]];
					oneIdx = j;
					twoIdx = idxMap[j];
				}
			}

			idxMap[oneIdx]++;
			System.out.print("(" + one[oneIdx] + " " + two[twoIdx] + ") ");
		}
	}
}
