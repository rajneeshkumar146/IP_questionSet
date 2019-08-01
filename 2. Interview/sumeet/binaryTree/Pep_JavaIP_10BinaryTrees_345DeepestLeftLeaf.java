package interview.binaryTree;

import java.util.LinkedList;
import java.util.Scanner;

public class Pep_JavaIP_10BinaryTrees_345DeepestLeftLeaf {
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

		deepestLeftLeaf(root, false, 0);
		System.out.println(dll.data);
	}

	private static Node dll = null;
	private static int maxDepth = Integer.MIN_VALUE;
	
	private static void deepestLeftLeaf(Node node, boolean ilc, int depth){
		if(node == null){
			return;
		}
		
		// if it is a left leaf
		if(node.left == null && node.right == null && ilc){
			// if it is deeper, update
			if(depth > maxDepth){
				maxDepth = depth;
				dll = node;
			}
		}
		
		// going deep on left side
		deepestLeftLeaf(node.left, true, depth + 1);
		// going deep on right side
		deepestLeftLeaf(node.right, false, depth + 1);
	}
}
/* Test case 1 
12 
1 2 3 4 5 6 7 8 9 10 11 12 
8
*/

/* Test case 2 
12 
1 2 3 -1 4 5 -1 -1 -1 6 7 8
6
*/

/* Test case 3 
12 
1 2 3 4 -1 -1 5 6 7 -1 -1 -1
6
*/

/* Test case 4
12 
1 2 3 4 -1 -1 5 -1 7 -1 -1 -1
6
*/