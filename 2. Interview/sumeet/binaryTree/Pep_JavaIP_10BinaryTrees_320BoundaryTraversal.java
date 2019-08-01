package interview.binaryTree;

import java.util.Scanner;

public class Pep_JavaIP_10BinaryTrees_320BoundaryTraversal {
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

		// display(nodes[0]);
		solve(nodes[0]);
	}

	private static void solve(Node node) {
		// left boundary preorder
		leftBoundary(node);

		// leaves inorder
		printLeaves(node);

		// right boundary post order
		rightBoundary(node);
	}

	private static void leftBoundary(Node node) {
		if (node.left != null) {
			System.out.print(node.data + " "); // for clockwise, print before going down
			leftBoundary(node.left);
		} else if (node.right != null) {
			System.out.print(node.data + " "); // if no left child, move right once
			leftBoundary(node.right);
		} else {
			// nothing - not printing the leaf
		}
	}

	private static void rightBoundary(Node node) {
		if (node.right != null) {
			rightBoundary(node.right);
			System.out.print(node.data + " "); // for clockwise, print while coming out
		} else if (node.left != null) {
			rightBoundary(node.left);
			System.out.print(node.data + " "); // if no right child, move left once
		} else {
			// nothing - not printing the leaf
		}
	}

	private static void printLeaves(Node node) {
		if (node.left != null) {
			printLeaves(node.left);
		}

		if (node.left == null && node.right == null) {
			System.out.print(node.data + " ");
		}

		if (node.right != null) {
			printLeaves(node.right);
		}
	}

}
