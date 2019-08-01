package Tree;

import java.util.ArrayList;
import java.util.Scanner;

public class pth_common_ancestor_in_BST {

	static class Node {
		int data;
		Node left, right;

		public Node(int data) {
			this.data = data;
		}
	}

	public static void preorder(Node node) {
		if (node == null)
			return;
		System.out.print(node.data + " ");
		preorder(node.left);
		preorder(node.right);
	}

	public static Node insert(Node node, int data) {
		if (node == null) {
			Node temp = new Node(data);
			return temp;
		}
		if (data < node.data) {
			node.left = insert(node.left, data);
		} else {
			node.right = insert(node.right, data);
		}

		return node;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			int p = sc.nextInt();
			Node root = null;
			for (int i = 0; i < n; i++) {
				root = insert(root, sc.nextInt());
			}

			int x = sc.nextInt(), y = sc.nextInt();
			if (x > y) {
				int temp = y;
				y = x;
				x = temp;
			}

			// preorder(root);

			pth_common_ancestor_in_BST obj = new pth_common_ancestor_in_BST();
			po(obj.PthAncestor(root, x, y, p, new ArrayList<>()));
		}
	}

	public static void po(Object o) {
		System.out.println(o);
	}

	// method1.=================================================================================

	public int PthAncestor(Node root, int x, int y, int p, ArrayList<Integer> list) {
		Node node = new Node(0);
		pthAncestor_(root, x, y, p, node);
		if (node.left != null && node.right != null) {
			return node.right.data;
		}
		return -1;
	}

	public boolean pthAncestor_(Node root, int x, int y, int p, Node node) {
		if (node == null)
			return false;

		if (root.data > y && root.data > x) {
			boolean left = pthAncestor_(root.left, x, y, p, node);
			if (left && node.data + 1 == p) {
				node.right = root;
			}
			node.data = node.data + 1;
			return left;
		} else if (root.data < x && root.data < y) {
			boolean right = pthAncestor_(root.right, x, y, p, node);
			if (right && node.data + 1 == p) {
				node.right = root;
			}
			node.data = node.data + 1;
			return right;
		} else {
			node.left = root;
			node.data = 1;
			if (node.data == p) {
				node.right = root;
			}
			return true;
		}
	}

	// method2.=============================================================

	public int pthAncestor2(Node root, int x, int y, int p) {
		Node node = new Node(0);
		pthAncestor2_(root, x, y, p, node);
		if (node.left != null && node.right != null) {
			return node.right.data;
		}
		return -1;
	}

	public boolean pthAncestor2_(Node root, int x, int y, int p, Node node) {
		if (node == null)
			return false;

		boolean selfDone = (root.data == x) || (root.data == y);

		boolean left = pthAncestor2_(root.left, x, y, p, node);
		if (node.left != null) {
			if (node.data+1 == p)
				node.right = root;
			node.data=node.data+1;
			return true;
		}

		boolean right = pthAncestor2_(root.right, x, y, p, node);
		if (node.left != null) {
			if (node.data == p)
				node.right = root;
			node.data=node.data+1;
			return true;
		}

		if ((left && right) || (selfDone && right) || (left && selfDone)) {
			node.left = root;
			node.data = 1;
			if (node.data == p)
				node.right = root;
		}

		return selfDone || left || right;

	}

}
