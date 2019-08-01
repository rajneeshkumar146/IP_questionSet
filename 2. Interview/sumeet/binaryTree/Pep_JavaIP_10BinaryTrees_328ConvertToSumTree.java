package interview.binaryTree;

import java.util.Scanner;

public class Pep_JavaIP_10BinaryTrees_328ConvertToSumTree {
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
		str += " <= " + node.data + " => ";
		str += node.right == null ? "." : node.right.data;

		System.out.println(str);

		display(node.left);
		display(node.right);
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int[] arr = new int[scn.nextInt()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}

		// creation using the level order, seeing it like a heap
		// -1 says there is no node
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
		Node root = nodes[0];
//		display(root);

		convertToSumTree(root);
		display(root);
	}

	private static int convertToSumTree(Node node){
		if(node == null){
			return 0;
		}
		
		int lsum = convertToSumTree(node.left);
		int rsum = convertToSumTree(node.right);
		int sum = node.data + lsum + rsum;

		// replacing with sum of children
		node.data = lsum + rsum;
		
		// but returning the whole sum as well.
		return sum;
	}
}

/* Test case 1 
12 
1 2 3 4 5 6 7 8 9 10 11 12 
47 <= 77 => 25
17 <= 47 => 21
0 <= 17 => 0
. <= 0 => .
. <= 0 => .
0 <= 21 => 0
. <= 0 => .
. <= 0 => .
12 <= 25 => 0
0 <= 12 => .
. <= 0 => .
. <= 0 => .
*/

/* Test case 2 
12 
1 2 3 -1 4 5 -1 -1 -1 6 7 8
17 <= 35 => 13
. <= 17 => 13
0 <= 13 => 0
. <= 0 => .
. <= 0 => .
8 <= 13 => .
0 <= 8 => .
. <= 0 => .
*/