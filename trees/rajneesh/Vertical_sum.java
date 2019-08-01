package Tree;

import java.util.Collections;
import java.util.HashMap;

public class Vertical_sum {
	public static class Node {
		int data;
		Node left;
		Node right;

		Node(int x) {
			data = x;
		}
	}

	public static void printVertical(Node root) {
		Node ll = new Node(-1);
		Node curr = new Node(0);

		printVertical_(root, ll, curr);

		Node itr = ll.left;
		while (itr != null) {
			System.out.print(itr.data + " ");
			itr = itr.right;
		}
	}

	public static void printVertical_(Node root, Node ll, Node curr) {
		if (root == null)
			return;

		curr.data += root.data;
		if (root.left != null) {
			if (curr.left == null) {
				curr.left = new Node(0);
				curr.left.right = curr;

				ll.left = curr.left;
			}
			printVertical_(root.left, ll, curr.left);
		}

		if (root.right != null) {
			if (curr.right == null) {
				curr.right = new Node(0);
				curr.right.left = curr;

				ll.right = curr.right;
			}

			printVertical_(root.right, ll, curr.right);
		}
	}

	// method_2.====================================================================================

	public static void verticalSum(Node root) {
		HashMap<Integer, Integer> map = new HashMap<>();
		verticalSum_01(root, map, 0);
		int min = Collections.min(map.keySet());
		int max = Collections.max(map.keySet());

		for (int i = min; i <= max; i++) {
			System.out.print(map.get(i) + " ");
		}

	}

	private static void verticalSum_01(Node node, HashMap<Integer, Integer> map, int level) {
		if (node == null)
			return;

		if (!map.containsKey(level)) {
			map.put(level, node.data);
		} else {
			map.put(level, map.get(level) + node.data);
		}

		verticalSum_01(node.left, map, level + 1);
		verticalSum_01(node.right, map, level - 1);

	}

}
