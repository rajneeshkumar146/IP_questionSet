package interview.binaryTree;

import java.util.Scanner;

public class Pep_JavaIP_10BinaryTrees_343CreateVerticalSumDLL {
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
		// display(root);

		head = tail = new Node(0, null, null);
		createVerticalSumDLL(root, head);
		displayDLL();
	}

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

	private static Node head;
	private static Node tail;
	
	private static void createVerticalSumDLL(Node node, Node dll) {
		dll.data += node.data;
		if (node.left != null) {
			if (dll.left == null) {
				dll.left = new Node(0, null, dll);
				head = dll.left;
			}
			createVerticalSumDLL(node.left, dll.left);
		}

		if (node.right != null) {
			if (dll.right == null) {
				dll.right = new Node(0, dll, null);
				tail = dll.right;
			}
			createVerticalSumDLL(node.right, dll.right);
		}
	}
}

/* Test case 1 
12 
1 2 3 4 5 6 7 8 9 10 11 12 
8 -> 4 -> 33 -> 12 -> 14 -> 7 -> .
7 -> 14 -> 12 -> 33 -> 4 -> 8 -> .
*/

/* Test case 2 
12 
1 2 3 -1 4 5 -1 -1 -1 6 7 8
16 -> 10 -> 10 -> .
10 -> 10 -> 16 -> .
*/

/* Test case 3 
12 
1 2 3 4 -1 -1 5 6 7 -1 -1 -1
6 -> 4 -> 9 -> 1 -> 3 -> 5 -> .
5 -> 3 -> 1 -> 9 -> 4 -> 6 -> .
*/