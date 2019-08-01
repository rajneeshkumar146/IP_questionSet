package InternQuestionDP;

import java.util.Scanner;

public class Minimum_number_of_deletions_to_make_a_sorted_sequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		while (t-- > 0) {
			int n = scn.nextInt();
			int a[] = new int[n];
			for (int i = 0; i < n; i++)
				a[i] = scn.nextInt();

			int[] strg = new int[a.length];
			int max = 1;
			strg[0] = 1;
			for (int i = 0; i < a.length; i++) {
				strg[i] = 1;
				for (int j = 0; j < i; j++) {
					if (a[i] > a[j]) {
						strg[i] = Math.max(strg[i], strg[j] + 1);
					}
				}

				max = Math.max(max, strg[i]);
			}
//		for (int c : strg) {
//			System.out.print(c + " ");
//		}
//		System.out.println();
			System.out.println(n - max);

		}
	}
}
