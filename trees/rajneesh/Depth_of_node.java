package Tree;

public class Depth_of_node {
	class Node {
		int data;
		Node left, right;

		Node(int item) {
			data = item;
			left = right = null;
		}
	}

	public static int depthOfOddLeafUtil(Node root, int level) {

		if (root == null)
			return 0;

		if (root.left == null && root.right == null && (level & 1) == 1)
			return level;

		return Math.max(depthOfOddLeafUtil(root.left, level + 1), depthOfOddLeafUtil(root.right, level + 1));
	}
}
