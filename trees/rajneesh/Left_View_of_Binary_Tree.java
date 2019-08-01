package Tree;

public class Left_View_of_Binary_Tree {
	private static class Node {
		int data;
		Node left, right;

		Node(int item) {
			data = item;
			left = right = null;
		}
	}

	private static void leftView(Node root) {
		rightSideView_(root, 0, new Node(-1));

	}

	public static void rightSideView_(Node root, int level, Node node) {
		if (root == null)
			return;

		if (level > node.data) {
			System.out.print(root.data + " ");
			node.data = level;
		}
		rightSideView_(root.left, level + 1, node);
		rightSideView_(root.right, level + 1, node);

	}
}
