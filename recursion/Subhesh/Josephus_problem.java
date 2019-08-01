package BackTracking;

import java.util.Scanner;

public class Josephus_problem {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		for (int z = 0; z < t; z++) {
			int n = scn.nextInt();
			int k = scn.nextInt();
			System.out.println(death(n, k));
		}
	}

	private static int death(int n, int k) {
		if (n == 1) {
			return 1;
		}
		return ((death(n - 1, k) + k - 1) % n + 1);
	}
}
