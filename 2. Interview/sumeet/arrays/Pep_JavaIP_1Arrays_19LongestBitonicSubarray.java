package interview.arrays;

import java.util.Scanner;

public class Pep_JavaIP_1Arrays_19LongestBitonicSubarray {

	public static void main(String[] args) {
		// Geeks
		/*
		 * Scanner scn = new Scanner(System.in); int t = scn.nextInt();
		 * 
		 * while (t-- > 0) { int[] arr = new int[scn.nextInt()]; for (int i = 0;
		 * i < arr.length; i++) { arr[i] = scn.nextInt(); }
		 * 
		 * System.out.println(solve(arr)); }
		 */

		// Hackerrank
		Scanner scn = new Scanner(System.in);
		int[] arr = new int[scn.nextInt()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}

		solve(arr);
	}

	private static int solve(int[] arr) {
		if (arr.length == 0) {
			System.out.println();
			return 0;
		} else if (arr.length == 1) {
			System.out.println(arr[0]);
			return 1;
		}

		// 0 is up, 1 is down, 2 is level
		int cdir = arr[1] > arr[0] ? 0 : arr[1] < arr[0] ? 1 : 2; 
		int csp = cdir == 0 ? 0 : cdir == 1 ? 0 : 1;
		int cep = 1;
		int osp = csp;
		int oep = cep;

		for (int i = 2; i < arr.length; i++) {
			int ndir = arr[i] > arr[i - 1] ? 0 : arr[i] < arr[i - 1] ? 1 : 2;

			if (ndir == 2) {
				csp = cep = i;
			} else if ((cdir == 0 && ndir == 0) || (cdir == 0 && ndir == 1) || (cdir == 1 && ndir == 1)) {
				cep = i;
			} else if ((cdir == 1 && ndir == 0) || (cdir == 2 && ndir == 0) || (cdir == 2 && ndir == 1)) {
				csp = i - 1;
				cep = i;
			}

			cdir = ndir;
			if (cep - csp >= oep - osp) {
				osp = csp;
				oep = cep;
			}
		}

		for (int i = osp; i <= oep; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();

		return oep - osp + 1;

	}

}
