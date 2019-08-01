package interview.binaryTree;

import java.util.Scanner;

public class Pep_JavaIP_10BinaryTrees_326CreateDoublyLinkedListFromTernaryTree {
	private static class Node {
		int data;
		Node left;
		Node middle;
		Node right;

		Node(int data, Node left, Node middle, Node right) {
			this.data = data;
			this.left = left;
			this.middle = middle;
			this.right = right;
		}
	}

	public static void display(Node node) {
		if (node == null) {
			return;
		}

		String str = "";

		str += node.data + " => ";
		str += node.left == null ? " . " : " " + node.left.data + " ";
		str += node.middle == null ? " . " : " " + node.middle.data + " ";
		str += node.right == null ? " . " : " " + node.right.data + " ";

		System.out.println(str);

		display(node.left);
		display(node.middle);
		display(node.right);
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int[] arr = new int[scn.nextInt()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}

		// creation using the level order, seeing it like a heap (with 3 nodes)
		// -1 says there is no node
		Node[] nodes = new Node[arr.length];
		for (int i = 0; i < nodes.length; i++) {
			if (arr[i] != -1) {
				nodes[i] = new Node(arr[i], null, null, null);

				if (i > 0) {
					int pi = (i - 1) / 3;

					if (i == 3 * pi + 1) {
						nodes[pi].left = nodes[i];
					} else if (i == 3 * pi + 2) {
						nodes[pi].middle = nodes[i];
					} else {
						nodes[pi].right = nodes[i];
					}
				}
			}
		}
		Node root = nodes[0];
//		display(root);

		createDLL(root);
		displayDLL();
	}

	static Node head;
	static Node tail;

	// method to display the linked list
	private static void displayDLL() {
		Node temp;
		for (temp = head; temp != null; temp = temp.right) {
			System.out.print(temp.data + " -> ");
		}
		System.out.println(".");

		for (temp = tail; temp != null; temp = temp.left) {
			System.out.print(temp.data + " -> ");
		}
		System.out.println(".");
	}

	// method to create a doubly linked list
	private static void createDLL(Node treeNode) {
		if (treeNode == null) {
			return;
		}

		if (head == null) {
			// if it is the first node
			head = tail = new Node(treeNode.data, null, null, null);
		} else {
			// if it is a new node, we create it, point its left to tail and
			// tail's right to it. Then we update the tail to this place.
			Node dllNode = new Node(treeNode.data, tail, null, null);
			tail.right = dllNode;
			tail = dllNode;
		}

		createDLL(treeNode.left);
		createDLL(treeNode.middle);
		createDLL(treeNode.right);
	}
}

/* Test case 1 
12 
1 2 3 4 5 6 7 8 9 10 11 12 
1 -> 2 -> 5 -> 6 -> 7 -> 3 -> 8 -> 9 -> 10 -> 4 -> 11 -> 12 -> .
12 -> 11 -> 4 -> 10 -> 9 -> 8 -> 3 -> 7 -> 6 -> 5 -> 2 -> 1 -> .
*/

/* Test case 2 
12 
1 -1 3 4 -1 -1 -1 8 -1 10 -1 12 
1 -> 3 -> 8 -> 10 -> 4 -> 12 -> .
12 -> 4 -> 10 -> 8 -> 3 -> 1 -> .
*/