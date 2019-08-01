package Tree;

import java.util.LinkedList;
import java.util.Scanner;

public class Print_Common_Nodes_in_BST {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int n1 = sc.nextInt();
			Node root1 = null;
			Node root2 = null;
			for (int i = 0; i < n1; i++) {
				int a = sc.nextInt();
				if (root1 == null)
					root1 = new Node(a);
				else {
					insert(root1, a);
				}
			}
			int n2 = sc.nextInt();
			for (int i = 0; i < n2; i++) {
				int a = sc.nextInt();
				if (root2 == null)
					root2 = new Node(a);
				else {
					insert(root2, a);
				}
			}
			Print_Common_Nodes_in_BST g = new Print_Common_Nodes_in_BST();
			g.printCommon(root1, root2);
			System.out.println();
		}
	}

	public static Node insert(Node root, int a) {
		if (root == null)
			return new Node(a);
		if (root.data > a) {
			root.left = insert(root.left, a);
		}
		if (root.data < a)
			root.right = insert(root.right, a);
		return root;
	}

	static class Node {
		int data;
		Node left, right;

		Node(int d) {
			data = d;
			left = right = null;
		}

	}

	// solution.==============================================================

	public void printCommon(Node root1, Node root2) {
		LinkedList<Node> st1 = new LinkedList<>();
		addAllLeft(root1, st1);

		LinkedList<Node> st2 = new LinkedList<>();
		addAllLeft(root2, st2);

		while (!st1.isEmpty() && !st2.isEmpty()) {
			if (st1.getFirst().data == st2.getFirst().data) {
				System.out.print(st1.getFirst().data + " ");
				addAllLeft(st1.removeFirst().right, st1);
				addAllLeft(st2.removeFirst().right, st2);
			} else if (st1.getFirst().data < st2.getFirst().data) {
				addAllLeft(st1.removeFirst().right, st1);
			} else {
				addAllLeft(st2.removeFirst().right, st2);
			}
		}
	}

	public void addAllLeft(Node node, LinkedList<Node> st) {
		while (node != null) {
			st.addFirst(node);
			node = node.left;
		}
	}
}
