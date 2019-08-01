package Tree;

public class Vertical_Width_of_a_Binary_Tree {
	static class Node {
		int data;
		Node left, right;

		Node(int d) {
			data = d;
			left = right = null;
		}
	}

	public static int verticalWidth(Node root) {
		Node min = new Node(0);
		Node max = new Node(0);

		width_01(root, min, max, 0);

		return (max.data - min.data + 1);

	}

	private static void width_01(Node root, Node min, Node max, int level) {
		if (root == null)
			return;

		min.data = Math.min(min.data, level);
		max.data = Math.max(max.data, level);

		width_01(root.left, min, max, level - 1);
		width_01(root.right, min, max, level + 1);

	}

}
