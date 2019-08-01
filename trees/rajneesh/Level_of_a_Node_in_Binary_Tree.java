package Tree;

public class Level_of_a_Node_in_Binary_Tree {
	static class Node {
		int data;
		Node left, right;

		Node(int key) {
			data = key;
			left = right = null;
		}
	}

	public static int getLevel(Node root, int key) {
		return getLevel_(root, key, 1);
	}

	public static int getLevel_(Node root, int key, int level) {
		if (root == null)
			return 0;
		if (root.data == key)
			return level;

		return Math.max(getLevel_(root.left, key, level + 1), getLevel_(root.right, key, level + 1));

	}
}
