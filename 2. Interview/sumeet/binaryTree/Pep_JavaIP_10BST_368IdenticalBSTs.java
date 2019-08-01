package interview.binaryTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class Pep_JavaIP_10BST_368IdenticalBSTs {
	private static class Node {
		int data;
		Node left;
		Node right;

		Node(int data, Node left, Node right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}
	}

	public static void display(Node node) {
		if (node == null) {
			return;
		}

		String str = "";

		str += node.left == null ? "." : node.left.data;
		str += " => " + node.data + " <= ";
		str += node.right == null ? "." : node.right.data;

		System.out.println(str);

		display(node.left);
		display(node.right);
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();

		int[] one = new int[n];
		for (int i = 0; i < one.length; i++) {
			one[i] = scn.nextInt();
		}

		int[] two = new int[n];
		for (int i = 0; i < two.length; i++) {
			two[i] = scn.nextInt();
		}

		System.out.println(identical(one, 0, two, 0, Integer.MIN_VALUE, Integer.MAX_VALUE));
	}

	private static boolean identical(int[] one, int ovidx, int[] two, int tvidx, int min, int max) {
		int oidx = -1;
		for (int i = ovidx; i < one.length; i++) {
			if (one[i] > min && one[i] < max) {
				oidx = i;
				break;
			}
		}

		int tidx = -1;
		for (int i = tvidx; i < two.length; i++) {
			if (two[i] > min && two[i] < max) {
				tidx = i;
				break;
			}
		}

		if (oidx == -1 ^ tidx == -1) {
			return false;
		} else if (oidx == -1 && tidx == -1) {
			return true;
		} else if (one[oidx] != two[tidx]) {
			return false;
		} else {
			return identical(one, oidx + 1, two, tidx + 1, min, one[oidx])
					&& identical(one, oidx + 1, two, tidx + 1, one[oidx], max);
		}
	}

}

// https://www.geeksforgeeks.org/check-for-identical-bsts-without-building-the-trees/
/*Test Case 1 
4 
2 4 3 1 
2 1 4 3
true
*/

/*Test Case 2 
9
8 3 6 1 4 7 10 14 13
8 10 14 3 6 4 1 7 13
true
*/

/*Test Case 3 
9
8 3 6 1 4 7 10 14 13
8 10 1 3 6 13 14 7 4
false
*/
