package interview.binaryTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class Pep_JavaIP_10BinaryTrees_325ConstructFromParentArray {
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
		Scanner scn = new Scanner(System.in);
		int[] arr = new int[scn.nextInt()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}

		Node root = construct(arr);
		if (root == null) {
			System.out.println("Invalid");
		} else {
			display(root);
		}
	}

	private static Node construct(int[] arr) {
		Node[] nodes = new Node[arr.length];
		for (int i = 0; i < nodes.length; i++) { // create all nodes, without left and right
			nodes[i] = new Node(i, null, null);
		}

		Node root = null;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == -1) { // if parent is -1, it is the root node
				root = nodes[i];
				continue;
			}
			if (nodes[arr[i]].left == null) { // go to the parent and set it's left
				nodes[arr[i]].left = nodes[i];
			} else if (nodes[arr[i]].right == null) { // go to the parent and set it's right
				nodes[arr[i]].right = nodes[i];
			} else { // invalid
				return null;
			}
		}

		return root;
	}

}
