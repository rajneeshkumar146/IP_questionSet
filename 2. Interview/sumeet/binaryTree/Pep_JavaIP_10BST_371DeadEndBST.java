package interview.binaryTree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class Pep_JavaIP_10BST_371DeadEndBST {
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

		root = nodes[0];
		bstDeadEnd(root, 1, Integer.MAX_VALUE);
		if(deadEnd == null){
			System.out.println("Not Found");
		} else {
			System.out.println(deadEnd.data);
		}
	}
	
	static Node deadEnd = null;
	private static boolean bstDeadEnd(Node node, int min, int max){
		if(node.left == null && node.right == null){
			if(min == max){
				deadEnd = node;
			}
			return min == max;
		} else if(node.left == null){
			return bstDeadEnd(node.right, node.data + 1, max);
		} else if(node.right == null){
			return bstDeadEnd(node.left, min, node.data - 1);
		} else {
			return bstDeadEnd(node.left, min, node.data - 1) ||
				   bstDeadEnd(node.right, node.data + 1, max);
		}
	}
}

// https://www.geeksforgeeks.org/check-whether-bst-contains-dead-end-not/
/*Test Case 1
8
8 5 9 2 7 -1 -1 1
1
*/

/*Test Case 2
7
8 7 10 2 -1 9 13
9
*/

/*Test Case 3
7
50 25 75 12 37 62 87
Not Found
*/