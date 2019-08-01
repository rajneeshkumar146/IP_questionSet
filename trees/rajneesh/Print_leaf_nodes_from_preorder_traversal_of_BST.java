package Tree;

import java.util.Scanner;

public class Print_leaf_nodes_from_preorder_traversal_of_BST {
	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		solve();
	}

	// method1=====================================================================

	public static void solve() {
		int t = scn.nextInt();
		while (t-- > 0) {
			int[] arr = new int[scn.nextInt()];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = scn.nextInt();
			}
			idx = 0;
			preOder(arr, Integer.MIN_VALUE, Integer.MAX_VALUE);
			System.out.println();
		}
	}

	static int idx = 0;

	public static boolean preOder(int[] arr, int min, int max) {
		if (idx >= arr.length)
			return false;

		int ele = arr[idx];
		if (ele > min && ele < max) {
			idx++;

			boolean left = preOder(arr, min, ele);
			boolean right = preOder(arr, ele, max);

			if ((!left) && (!right)) {
				System.out.print(ele + " ");
			}
			return true;
		}
		return false;
	}

	// method2.========================================================================

}
