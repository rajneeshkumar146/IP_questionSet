package interview.arrays;

import java.util.Scanner;

public class Pep_JavaIP_2SnS_56CommonElements {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		int[] one = new int[scn.nextInt()];
		for (int i = 0; i < one.length; i++) {
			one[i] = scn.nextInt();
		}

		int[] two = new int[scn.nextInt()];
		for (int i = 0; i < two.length; i++) {
			two[i] = scn.nextInt();
		}

		int[] three = new int[scn.nextInt()];
		for (int i = 0; i < three.length; i++) {
			three[i] = scn.nextInt();
		}

		solve(one, two, three);
	}

	private static void solve(int[] one, int[] two, int[] three) {
		int i = 0, j = 0, k = 0;

		// merge type strategy from merge sort
		while (i < one.length && j < two.length && k < three.length) {
			if (one[i] == two[j] && two[j] == three[k]) {
				System.out.print(one[i] + " ");
				i++;
				j++;
				k++;
			} else if (one[i] < two[j]) { // one of the smaller increases
				i++;
			} else if (two[j] < three[i]) { // one of the smaller increases
				j++;
			} else { // one of the smaller increases
				k++;
			}
			// the check above provides certainity that either i or j or k (one in each case)
			// is one of the two smaller elements.
		}
	}
}
