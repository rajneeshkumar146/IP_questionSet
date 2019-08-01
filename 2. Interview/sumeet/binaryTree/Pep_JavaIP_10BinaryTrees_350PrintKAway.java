package interview.binaryTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Pep_JavaIP_10BinaryTrees_350PrintKAway {
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
		Node root = null;

		Scanner scn = new Scanner(System.in);
		int k = scn.nextInt();
		int data = scn.nextInt();

		int[] arr = new int[scn.nextInt()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}

		Node[] nodes = new Node[arr.length];
		for (int i = 0; i < nodes.length; i++) {
			if (arr[i] != -1) {
				nodes[i] = new Node(arr[i], null, null);

				if (i > 0) {
					int pi = (i - 1) / 2;

					if (i == 2 * pi + 1) {
						nodes[pi].left = nodes[i];
					} else {
						nodes[pi].right = nodes[i];
					}
				}
			}
		}

		// display(nodes[0]);
		printKAway(nodes[0], k, data);
	}

	private static int printKAway(Node node, int k, int data) {
		if (node == null) {
			return -1;
		}

		if (node.data == data) {
			printKDown(node, k);
			return 0;
		}

		int dl = printKAway(node.left, k, data);
		if (dl != -1) {
			if (1 + dl == k) {
				System.out.print(node.data + " ");
			} else {
				printKDown(node.right, k - dl - 2);
			}

			return dl + 1;
		}

		int dr = printKAway(node.right, k, data);
		if (dr != -1) {
			if (1 + dr == k) {
				System.out.print(node.data + " ");
			} else {
				printKDown(node.left, k - dr - 2);
			}

			return dr + 1;
		}

		return -1;
	}

	private static void printKDown(Node node, int k) {
		if (node == null) {
			return;
		}

		if (k == 0) {
			System.out.print(node.data + " ");
			return;
		}

		printKDown(node.left, k - 1);
		printKDown(node.right, k - 1);
	}
}

//https://www.geeksforgeeks.org/print-nodes-distance-k-given-node-binary-tree/
/*Test Case 1
2 6
12
1 2 3 -1 4 5 -1 -1 -1 6 7 8
7 2 
*/

/*Test Case 2
3 3
15
1 2 3 4 5 6 7 8 9 10 11 12 13 14 15
4 5 
*/
