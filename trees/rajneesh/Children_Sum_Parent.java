package Tree;

public class Children_Sum_Parent {
	static class Node {
		int data;
		Node left, right;

		Node(int key) {
			data = key;
			left = right = null;
		}
	}

	public static int isSumProperty(Node node) {
		int left = node.left != null ? node.left.data : 0;
		int right = node.right != null ? node.right.data : 0;
		if (node.data != left + right) {
			if (node.left == null && node.right == null)
				return 1;
			return 0;
		}

		if (node.left != null && isSumProperty(node.left) == 0)
			return 0;
		if (node.right != null && isSumProperty(node.right) == 0)
			return 0;
		return 1;

	}
}
