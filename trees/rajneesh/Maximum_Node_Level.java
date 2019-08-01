package Tree;

public class Maximum_Node_Level {

	static class Node {
		int data;
		Node left, right;

		Node(int item) {
			data = item;
			left = right = null;
		}
	}

	// method_01.============================================================

	public static int maxNodeLevel(Node node) {
		// int[] arr = new int[1000]; //can be used.
		int[] arr = new int[height(node)];
		maxNodeLevel_(node, arr, 0);
		int max = Integer.MIN_VALUE;
		int level = -1;
		for (int i = 0; i < arr.length; i++) {
			if (max < arr[i]) {
				max = arr[i];
				level = i;
			}
		}
		return level;
	}

	public static void maxNodeLevel_(Node node, int[] arr, int width) {
		if (node == null)
			return;
		arr[width]++;
		maxNodeLevel_(node.left, arr, width + 1);
		maxNodeLevel_(node.right, arr, width + 1);
	}

	public static int height(Node node) {
		if (node == null)
			return 0;
		return Math.max(height(node.left), height(node.right)) + 1;
	}

}
