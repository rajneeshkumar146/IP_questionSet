package interview.binaryTree;

import java.util.LinkedList;
import java.util.Scanner;

public class Pep_JavaIP_10BinaryTrees_355RemoveNodesOnPathSmallerThanK {
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
		int k = scn.nextInt();
		
		Node root = nodes[0];
//		display(root);

		root = removeNodesOnSmallerPath(root, 0, k);
		display(root);
	}

	private static Node removeNodesOnSmallerPath(Node node, int level, int k){
		if(node == null){
			return null;
		}
		
		node.left = removeNodesOnSmallerPath(node.left, level + 1, k);
		node.right = removeNodesOnSmallerPath(node.right, level + 1, k);
		
		if(node.left == null && node.right == null && level <= k){
			// in post order if its chain is to be removed, the node would have become leaf by now
			// because the chain below already stands deleted.
			return null;
		}
		
		return node;
	}

}
/* Test case 1 
12 
1 2 3 -1 4 5 10 -1 -1 6 7 8
2
2 <= 1 => 3
. <= 2 => 4
6 <= 4 => 7
. <= 6 => .
. <= 7 => .
5 <= 3 => .
8 <= 5 => .
. <= 8 => .
*/

/* Test case 2 
12 
1 2 3 11 4 5 10 -1 -1 6 7 8
2
2 <= 1 => 3
. <= 2 => 4
6 <= 4 => 7
. <= 6 => .
. <= 7 => .
5 <= 3 => .
8 <= 5 => .
. <= 8 => .
*/

