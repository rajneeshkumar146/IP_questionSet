package interview.backtracking;

import java.util.Scanner;

public class Pep_JavaIP_5Backtracking_169LargestNumberwithKswaps {
	static String max;

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		int k = scn.nextInt();
		max = str;
		findMaximum(str, k);
		System.out.println(max);
	}

	public static void findMaximum(String str, int k) {
		if (k == 0) {
			return;
		}

		for (int i = 0; i < str.length() - 1; i++) {
			for (int j = i + 1; j < str.length(); j++) {
				if (str.charAt(i) < str.charAt(j)) {
					str = swap(str, i, j);

					if (Integer.parseInt(str) > Integer.parseInt(max)) {
						max = str;
					}

					findMaximum(str, k - 1);
					str = swap(str, i, j);
				}
			}
		}
	}

	public static String swap(String str, int i, int j) {
		char chi = str.charAt(i);
		char chj = str.charAt(j);
		
		String left = str.substring(0, i);
		String middle = str.substring(i + 1, j);
		String right = str.substring(j + 1);

		return left + chj + middle + chi + right;
	}
}
