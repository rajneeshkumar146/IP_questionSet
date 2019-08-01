package BackTracking;

import java.util.Scanner;

public class Largest_number_in_K_swaps {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		for (int z = 0; z < t; z++) {
			int k = scn.nextInt();
			String st = scn.next();
			StringBuilder sb = new StringBuilder(st);
			ans = st;
			swaps(k, sb, st.length());
			System.out.println(ans);
		}
	}

	static String ans;

	private static void swaps(int k, StringBuilder st, int n) {
		if (k == 0) {
			return;
		}
		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				if (st.charAt(i) < st.charAt(j)) {
					swapping(st, i, j);
					String temp = st.toString();
					if (temp.compareTo(ans) > 0) {
						ans = temp;
					}
					swaps(k - 1, st, n);
					swapping(st, i, j);
				}
			}
		}
	}

	private static void swapping(StringBuilder st, int i, int j) {
		char temp = st.charAt(i);
		st.setCharAt(i, st.charAt(j));
		st.setCharAt(j, temp);
	}
}
