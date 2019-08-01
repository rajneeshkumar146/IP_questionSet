package Tree;

public class Print_BST_elements_in_given_range {

	static class Node {
		int key;
		Node left, right;

		Node(int item) {
			key = item;
			left = right = null;
		}
	}

	void printNearNodes(Node node, int k1, int k2) {
		if (node == null)
			return;

		if (node.key > k2) {
			printNearNodes(node.left, k1, k2);
		} else if (node.key < k1) {
			printNearNodes(node.right, k1, k2);
		} else {

			printNearNodes(node.left, k1, k2);
			System.out.print(node.key + " ");
			printNearNodes(node.right, k1, k2);

		}
	}
}
