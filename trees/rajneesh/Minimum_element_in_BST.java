package Tree;

public class Minimum_element_in_BST {
	class Node {
		int data;
		Node left, right;

		Node(int d) {
			data = d;
			left = right = null;
		}
	}

	int minValue(Node node) {
		if (node == null)
			return -1;
		while (node.left != null) {
			node = node.left;
		}
		return node.data;

	}
}
