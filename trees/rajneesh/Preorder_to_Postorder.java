package Tree;

import java.util.Scanner;

public class Preorder_to_Postorder {

	static int preIndex = 0;

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		while (t-- > 0) {
			int[] pre = new int[scn.nextInt()];
			for (int i = 0; i < pre.length; i++) {
				pre[i] = scn.nextInt();
			}

			postfrompre(pre);
		}
	}

	public static void postfrompre(int[] pre) {
		findPostOrderUtil(pre, pre.length, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private static void findPostOrderUtil(int pre[], int n, int minval, int maxval) {
		if (preIndex >= pre.length || pre[preIndex] > maxval || pre[preIndex] < minval)
			return;

		int val = pre[preIndex];
		preIndex++;
		findPostOrderUtil(pre, n, minval, val);
		findPostOrderUtil(pre, n, val, maxval);
		System.out.print(val + " ");
	}

}
