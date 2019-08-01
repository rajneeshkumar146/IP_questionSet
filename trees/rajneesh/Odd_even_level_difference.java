package Tree;

public class Odd_even_level_difference {
	class Node {
		int data;
		Node left, right;

		Node(int item) {
			data = item;
			left = right = null;
		}
	}

	int getLevelDiff(Node root) {
		int[] arr = new int[2];
		getLevelDiff_(root, 0, arr);
		return arr[0] - arr[1];

	}

	void getLevelDiff_(Node root, int level, int[] arr) {
		if (root == null)
			return;
		arr[(level & 1)] += root.data;
		getLevelDiff_(root.left, level + 1, arr);
		getLevelDiff_(root.right, level + 1, arr);
	}

}
