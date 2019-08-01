package Tree;

import Tree.Count_Leaves_in_Binary_Tree.Node;

public class Count_Non_Leaf_Nodes_in_Tree {
	class Node {
		int data;
		Node left, right;

		Node(int item) {
			data = item;
			left = right = null;
		}
	}

	int countNonLeafNodes(Node node) {
		if (node == null)
			return 0;
		if ((node.left == null && node.right == null))
			return 0;
		return countNonLeafNodes(node.left) + countNonLeafNodes(node.right)+1;
	}

}
