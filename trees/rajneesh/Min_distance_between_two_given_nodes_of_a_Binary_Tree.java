package Tree;

public class Min_distance_between_two_given_nodes_of_a_Binary_Tree {

	private static class Node {
		int data;
		Node left, right;

		public Node(int data) {
			this.data = data;
		}
	}

	int findDist(Node root, int key1, int key2) {
		Node lca = lowestCommonAncestor(root, key1, key2);
		return distanceFromRoot(lca, key1) + distanceFromRoot(lca, key2);
	}

	private static Node lowestCommonAncestor(Node root, int key1, int key2) {
		if (root == null || root.data == key1 || root.data == key2) {
			return root;
		}
		Node left = lowestCommonAncestor(root.left, key1, key2);
		Node right = lowestCommonAncestor(root.right, key1, key2);
		if (left != null && right != null) {
			return root;
		}
		return left != null ? left : right;
	}

	private int distanceFromRoot(Node root, int key) {
		if (root == null) {
			return -1;
		}
		if (root.data == key) {
			return 0;
		}
		int leftDistance = distanceFromRoot(root.left, key);
		int rightDistance = distanceFromRoot(root.right, key);
		return leftDistance == -1 ? rightDistance == -1 ? -1 : rightDistance + 1 : leftDistance + 1;

	}

}
