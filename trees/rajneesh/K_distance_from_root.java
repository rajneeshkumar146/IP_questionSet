package Tree;

public class K_distance_from_root {
	class Node {
		int data;
		Node left, right;

		Node(int item) {
			data = item;
			left = right = null;
		}
	}

	void printKdistance(Node root, int k) {
		if (root == null)
			return;
		if (k == 0) {
			System.out.print(root.data + " ");
			return;
		}
		printKdistance(root.left, k - 1);
		printKdistance(root.right, k - 1);

	}

}
