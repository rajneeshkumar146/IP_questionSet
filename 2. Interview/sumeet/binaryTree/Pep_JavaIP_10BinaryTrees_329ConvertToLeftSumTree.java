package interview.binaryTree;

import java.util.Scanner;

public class Pep_JavaIP_10BinaryTrees_329ConvertToLeftSumTree {
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

		convertToLeftSumTree(root);
		display(root);
	}

	private static int convertToLeftSumTree(Node node){
		if(node == null){
			return 0;
		}
		
		int lsum = convertToLeftSumTree(node.left);
		int rsum = convertToLeftSumTree(node.right);
		int sum = node.data + lsum + rsum;

		// replacing with sum of itself and left subtree
		node.data = lsum + node.data;
		
		// but returning the whole sum as well.
		return sum;
	}
}

/* Test case 1 
12 
1 2 3 4 5 6 7 8 9 10 11 12 
23 <= 50 => 21
12 <= 23 => 15
8 <= 12 => 9
. <= 8 => .
. <= 9 => .
10 <= 15 => 11
. <= 10 => .
. <= 11 => .
18 <= 21 => 7
12 <= 18 => .
. <= 12 => .
. <= 7 => .
*/

/* Test case 2 
12 
1 2 3 -1 4 5 -1 -1 -1 6 7 8
2 <= 20 => 16
. <= 2 => 10
6 <= 10 => 7
. <= 6 => .
. <= 7 => .
13 <= 16 => .
8 <= 13 => .
. <= 8 => .
*/