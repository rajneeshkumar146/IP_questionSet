package Tree;

import java.util.Scanner;

public class Node_at_distance {

	static class Node {
		int data;
		Node left, right;

		Node(int key) {
			data = key;
			left = right = null;
		}
	}

	static Node root;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		while (t-- > 0) {
			int n = sc.nextInt();
			Node root = null;
			for (int i = 0; i < n; i++) {
				int n1 = sc.nextInt();
				int n2 = sc.nextInt();
				char lr = sc.next().charAt(0);
				if (root == null) {
					root = new Node(n1);
					switch (lr) {
					case 'L':
						root.left = new Node(n2);
						break;
					case 'R':
						root.right = new Node(n2);
						break;
					}
				} else {
					insert(root, n1, n2, lr);
				}

			}

			Node_at_distance gfg = new Node_at_distance();
			int k = sc.nextInt();
			System.out.println(gfg.printKDistantfromLeaf(root, k));

		}
	}

	public static void insert(Node root, int n1, int n2, char ch) {
		if (root == null)
			return;
		if (root.data == n1) {
			switch (ch) {
			case 'L':
				root.left = new Node(n2);
				break;
			case 'R':
				root.right = new Node(n2);
				break;
			}
		} else {
			insert(root.left, n1, n2, ch);
			insert(root.right, n1, n2, ch);
		}
	}

	// =================================================================================================

	static int count = 0;

	public static int printKDistantfromLeaf_(Node node, int k) {
		if (node == null)
			return 0;

		int left = printKDistantfromLeaf_(node.left, k);
		int right = printKDistantfromLeaf_(node.right, k);

		if (left == k || right == k)
			count++;

		return Math.max(left, right) + 1;

	}

	public static int printKDistantfromLeaf(Node node, int k) {
		count = 0;
		printKDistantfromLeaf_(node, k);
		return count;
	}

}
