package Tree;

public class Count_BST_nodes_that_lie_in_a_given_range {
	static class Node {
		int data;
		Node left;
		Node right;
	}

	public static int getCountOfNode(Node node, int l, int r) {
		if (node == null)
			return 0;
		if (node.data >= l && r >= node.data) {
			return getCountOfNode(node.left, l, r) + getCountOfNode(node.right, l, r) + 1;
		} else if (node.data < l) {
			return getCountOfNode(node.right, l, r);
		} else if (node.data > r) {
			return getCountOfNode(node.left, l, r);
		} else {
			return 0;
		}

	}
}
