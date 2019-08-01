package Tree;

public class Reverse_alternate_levels_of_a_perfect_binary_tree {
	class Node {
		int data;
		Node left, right;

		Node(int item) {
			data = item;
			left = right = null;
		}
	}

	void reverseAlternate(Node node) {
		if (node == null)
			return;
		if (node.left == null && node.right == null)
			return;
		reverseAlternate_(node.left, node.right, 1);
	}

	void reverseAlternate_(Node node1, Node node2, int lev) {
		if (node1 == null || node2 == null)
			return;
		if (lev % 2 != 0) {
			int temp = node1.data;
			node1.data = node2.data;
			node2.data = temp;
		}
		reverseAlternate_(node1.left, node2.right, lev + 1);
		reverseAlternate_(node1.right, node2.left, lev + 1);

	}
}
