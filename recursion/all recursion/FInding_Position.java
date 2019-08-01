package BackTracking;

import java.util.Scanner;

public class FInding_Position {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		for (int z = 0; z < t; z++) {
			int n = scn.nextInt();
			position(n);
		}
	}

	private static void position(int n) {
		int ans = 2;
		while (ans <= n) {
			ans = ans * 2;
		}
		System.out.println(ans / 2);
	}
}
