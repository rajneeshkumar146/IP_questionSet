package interview.binaryTree;

import java.util.LinkedList;
import java.util.Scanner;

public class Pep_JavaIP_10BinaryTrees_341DoubleTree {
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

		doubleTree(root);
		display(root);
	}

	private static void doubleTree(Node node){
		if(node == null){
			return;
		}
		
		doubleTree(node.left);
		doubleTree(node.right);
		
		// created a node in post order, it points to left and our left points to it
		Node temp = new Node(node.data, node.left, null);
		node.left = temp;
	}

}
/* Test case 1 
3
1 2 3
1 <= 1 => 3
2 <= 1 => .
2 <= 2 => .
. <= 2 => .
3 <= 3 => .
. <= 3 => .

*/

/* Test case 2 
5
1 2 3 4 5
1 <= 1 => 3
2 <= 1 => .
2 <= 2 => 5
4 <= 2 => .
4 <= 4 => .
. <= 4 => .
5 <= 5 => .
. <= 5 => .
3 <= 3 => .
. <= 3 => .
*/