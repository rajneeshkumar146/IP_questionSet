package Tree;

import java.util.Scanner;

public class Inorder_Traversal_and_BST {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();

		while (t-- > 0) {
			int[] arr = new int[scn.nextInt()];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = scn.nextInt();
			}

			System.out.println(InoderTraversal_01(arr));
		}
	}

	public static int InoderTraversal_01(int[] arr) {
		int max = arr[0];

		for (int i = 1; i < arr.length; i++) {
			if (max < arr[i]) {
				max = arr[i];
			} else {
				return 0;
			}
		}
		return 1;
	}

}
