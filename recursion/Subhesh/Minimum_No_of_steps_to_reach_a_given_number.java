package BackTracking;

import java.util.Scanner;

public class Minimum_No_of_steps_to_reach_a_given_number {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		for (int z = 0; z < t; z++) {
			int dest = scn.nextInt();
			dest = Math.abs(dest);
//			System.out.println(steps(0, dest, 0));
			System.out.println(stepsiter(0, dest));
		}
	}

	private static int steps(int src, int dest, int moveno) {
		if (Math.abs(src) > dest) {
			return Integer.MAX_VALUE;
		}
		if (Math.abs(src) == dest) {
			return moveno;
		}

		int pos = steps(src + moveno + 1, dest, moveno + 1);
		int neg = steps(src - moveno - 1, dest, moveno + 1);
		return Math.min(pos, neg);
	}

	private static int stepsiter(int src, int dest) {
		int sum = 0;
		int step = 0;
		while (sum < dest) {
			step++;
			sum += step;
		}
		if (sum == dest) {
		} else {
			int diff = sum - dest;
			if (diff % 2 == 1) {
				step++;
				diff = diff + step;
				if (diff % 2 == 1) {
					step++;
				}
			}
		}
		return step;
	}
}
