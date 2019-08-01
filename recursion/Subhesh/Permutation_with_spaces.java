package BackTracking;

import java.util.Scanner;

public class Permutation_with_spaces {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		for (int z = 0; z < t; z++) {
			String st1 = scn.next();
			char[] st = new char[st1.length()];
			for (int i = 0; i < st1.length(); i++) {
				st[i] = st1.charAt(i);
			}
			perm(st);
		}
	}

	private static void perm(char[] st) {
		int pow = (int) Math.pow(2, st.length - 1);

		for (int i = 0; i < pow; i++) {
			System.out.print("(");
			for (int j = st.length - 2; j >= 0; j--) {
				System.out.print(st[st.length - j - 2]);
				if (((1 << j) & i) == 0) {
					System.out.print(" ");
				}
			}
			System.out.print(st[st.length - 1] + ")");
		}
		System.out.println();
	}
}
