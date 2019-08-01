package Tree;

public class Max_Level_Sum_in_Binary_Tree {
	public static class Node {
		int data;
		Node left;
		Node right;

		Node(int x) {
			data = x;
		}
	}

	public static int maxLevelSum(Node root) {
		int[] arr = new int[height(root) + 1];
		maxLevelSum_(root, 0, arr);
		int max = -1;
		for (int i : arr) {
			max = Math.max(max, i);
		}
		return max;
	}

	public static void maxLevelSum_(Node root, int level, int[] arr) {
		if (root == null)
			return;
		arr[level] += root.data;
		maxLevelSum_(root.left, level + 1, arr);
		maxLevelSum_(root.right, level + 1, arr);
	}

	public static int height(Node root) {
		if (root == null)
			return -1;
		return Math.max(height(root.left), height(root.right)) + 1;
	}

}
