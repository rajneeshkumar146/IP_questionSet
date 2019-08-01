package interview.binaryTree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class Pep_JavaIP_10BST_386SetParentPointer {
	private static class Node {
		int data;
		Node left;
		Node right;
		Node parent;

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
		str += " => " + node.data +  ("[" + (node.parent != null? node.parent.data: "null") + "]") + " <= ";
		str += node.right == null ? "." : node.right.data;

		System.out.println(str);

		display(node.left);
		display(node.right);
	}

	public static void main(String[] args) {
		Node root = null;

		Scanner scn = new Scanner(System.in);

		int[] arr = new int[scn.nextInt()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}

		Node[] nodes = new Node[arr.length];
		int size = 0;
		for (int i = 0; i < nodes.length; i++) {
			if (arr[i] != -1) {
				nodes[i] = new Node(arr[i], null, null);
				size++;

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

		root = nodes[0];
		setParent(root, null);
		display(root);
	}
	
	private static void setParent(Node node, Node parent){
		if(node == null){
			return;
		}
		
		node.parent = parent;
		setParent(node.left, node);
		setParent(node.right, node);
	}
}

// https://www.geeksforgeeks.org/binary-search-tree-insert-parent-pointer/
/*Test Case 1
11
50 25 75 12 37 62 87 -1 -1 30 40
25 => 50[null] <= 75
12 => 25[50] <= 37
. => 12[25] <= .
30 => 37[25] <= 40
. => 30[37] <= .
. => 40[37] <= .
62 => 75[50] <= 87
. => 62[75] <= .
. => 87[75] <= .
*/

/*Test Case 2
12
50 25 75 12 37 62 87 -1 -1 -1 -1 51
25 => 50[null] <= 75
12 => 25[50] <= 37
. => 12[25] <= .
. => 37[25] <= .
62 => 75[50] <= 87
51 => 62[75] <= .
. => 51[62] <= .
. => 87[75] <= .
*/
