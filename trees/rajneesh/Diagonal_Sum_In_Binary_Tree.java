package Tree;

import java.util.LinkedList;

public class Diagonal_Sum_In_Binary_Tree {
	private static class Node {
		int data;
		Node left, right;

		Node(int d) {
			data = d;
			left = right = null;
		}
	}

	public static void diagonalsum(Node root) {
		LinkedList<Integer> ans = new LinkedList<>();
		diagonalsum_(root, 0, ans);
		while (!ans.isEmpty()) {
			System.out.print(ans.removeLast() + " ");
		}
	}

	public static void diagonalsum_(Node node, int width, LinkedList<Integer> ans) {
		if (node == null)
			return;
		if (width >= ans.size())
			ans.addFirst(node.data);
		else
			ans.set(ans.size() - width - 1, ans.get(ans.size() - width - 1) + node.data);

		diagonalsum_(node.left, width + 1, ans);
		diagonalsum_(node.right, width, ans);

	}
}
