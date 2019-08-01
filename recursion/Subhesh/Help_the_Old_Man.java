package BackTracking;

import java.util.Scanner;

public class Help_the_Old_Man {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		for (int i = 0; i < t; i++) {
			int n = scn.nextInt();
			int move = scn.nextInt();

			Help(1, 2, 3, n, move);
		}
	}

	static int count = 0;

	private static void Help(int src, int helper, int dest, int n, int move) {
		if (n == 0) {
			return;
		}

		Help(src, dest, helper, n - 1, move);
		count++;
		if (count == move) {
			System.out.println(src + " " + dest);
		}
		Help(helper, src, dest, n - 1, move);
	}
}