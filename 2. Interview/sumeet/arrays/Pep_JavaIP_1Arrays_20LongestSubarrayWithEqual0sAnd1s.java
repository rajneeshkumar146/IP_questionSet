package interview.arrays;

import java.util.Scanner;

public class Pep_JavaIP_1Arrays_20LongestSubarrayWithEqual0sAnd1s {

	public static void main(String[] args) {
		// Geeks
		/*
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();

		while (t-- > 0) {
			int[] arr = new int[scn.nextInt()];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = scn.nextInt();
			}

			System.out.println(solve(arr));
		}
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
		Integer[] posmap = new Integer[arr.length + 1];
		Integer[] negmap = new Integer[arr.length + 1];
		posmap[0] = -1; // sequence starts from posmap[val] + 1

		int val = 0;
		int osp = 0;
		int oep = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 0) {
				val--;
			} else if (arr[i] == 1) {
				val++;
			}

			if (val >= 0) {
				if (posmap[val] != null) {
					if (i - posmap[val] > oep - osp) {
						osp = posmap[val] + 1; // sequence starts from posmap[val] + 1
						oep = i;
					}
				} else {
					posmap[val] = i;
				}
			} else {
				val = -val;
				if (negmap[val] != null) {
					if (i - negmap[val] > oep - osp) {
						osp = negmap[val] + 1;
						oep = i;
					}
				} else {
					negmap[val] = i;
				}
				val = -val;
			}
		}
		
		if (oep != osp) {
			for(int i = osp; i <= oep; i++){
				System.out.print(arr[i] + " ");
			}
			return oep - osp + 1;
		} else {
			System.out.println("Not Found");
			return 0;
		}
	}

}
