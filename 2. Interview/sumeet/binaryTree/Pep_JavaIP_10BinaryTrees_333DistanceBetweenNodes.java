package interview.binaryTree;

import java.util.Scanner;

public class Pep_JavaIP_10BinaryTrees_333DistanceBetweenNodes {
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
		int d1 = scn.nextInt();
		int d2 = scn.nextInt();
		// display(root);

		lca(root, d1, d2, 0);
		System.out.println(d1Depth + d2Depth - 2 * lcaDepth);
	}

	static Node lca;
	static int d1Depth;
	static int d2Depth;
	static int lcaDepth;
	private static boolean lca(Node node, int d1, int d2, int level) {
		if(node == null){
			return false;
		}
		
		boolean self = false;
		
		if(node.data == d1){
			d1Depth = level;
			self = true;
		}
		if(node.data == d2){
			d2Depth = level;
			self = true;
		}
		
		
		boolean left = lca(node.left, d1, d2, level + 1);
		boolean right = lca(node.right, d1, d2, level + 1);

		// moment of reckoning
		// both child found something
		// one child or self found something
		if ((left == true && right == true) ||
			(left == true && self == true) ||
			(self == true && right == true)){
			if (lca == null) {
				lca = node;
				lcaDepth = level;
			}
		}

		return self || left || right;
	}

}
/* Test case 1 
12 
1 2 3 4 5 6 7 8 9 10 11 12 
4 11
3
*/

/* Test case 2 
12 
1 2 3 -1 4 5 -1 -1 -1 6 7 8
7 8
6
*/

/* Test case 3 
12 
1 2 3 4 -1 -1 5 6 7 -1 -1 -1
2 7
2
*/