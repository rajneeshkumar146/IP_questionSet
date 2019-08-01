package Tree;

import java.util.Scanner;

public class Preorder_Traversal_and_BST {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		while (t-- > 0) {
			int[] pre = new int[scn.nextInt()];
			for (int i = 0; i < pre.length; i++) {
				pre[i] = scn.nextInt();
			}

			preOder(pre);
		}
	}

	static int index = 0;

	
	// same code run in c++ language.
	public static void preOder(int[] pre) {
		index = 0;
		preOder(pre, Integer.MIN_VALUE, Integer.MAX_VALUE);
		if (index == pre.length)
			System.out.println(1);
		else
			System.out.println(0);

	}

	public static void preOder(int[] pre, int min, int max) {
		if (index >= pre.length || pre[index] > max || pre[index] < min)
			return;

		int val = pre[index];
		index++;
		preOder(pre, min, val);
		preOder(pre, val, max);

	}
}
