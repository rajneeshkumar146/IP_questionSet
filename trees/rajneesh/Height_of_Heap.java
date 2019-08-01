package Tree;

import java.util.Scanner;

public class Height_of_Heap {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		while (t-- > 0) {
			int n = scn.nextInt();
			int[] arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = scn.nextInt();
			}
			solve(arr);
		}
	}

	public static void solve(int[] arr) {
		int height = 0;
		int len = arr.length;
		while ((len >> 1) != 0) {
			len = len >> 1;
			height++;
		}
		System.out.println(height);
	}

}
