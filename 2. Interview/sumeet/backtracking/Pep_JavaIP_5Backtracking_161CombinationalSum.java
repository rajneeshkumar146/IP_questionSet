package interview.backtracking;

import java.util.Scanner;

public class Pep_JavaIP_5Backtracking_161CombinationalSum {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int[] arr = new int[scn.nextInt()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}
		int target = scn.nextInt();
		solve(arr, target, "", 0);
	}

	public static void solve(int[] arr, int target, String ssf, int lindxused) {
		if (target < 0) {
			return;
		}
		if (target == 0) {
			System.out.println(ssf);
			return;
		}
		// System.out.println(target+" "+sum);
		for (int i = lindxused; i < arr.length; i++) {
			solve(arr, target - arr[i], ssf + "" + arr[i] + " ", i);
		}
	}
}
