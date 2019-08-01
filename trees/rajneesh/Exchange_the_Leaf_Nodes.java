package Tree;

public class Exchange_the_Leaf_Nodes {
	class Node {
		int data;
		Node left, right;

		public Node(int data) {
			this.data = data;
		}
	}

	// method01.==================================================================

	Node temp = null;

	public void exchangeLeaves(Node node) {
		if (node == null)
			return;
		if (node.left == null && node.right == null) {
			if (temp == null)
				temp = node;
			else {
				int te = temp.data;
				temp.data = node.data;
				node.data = te;
				temp = null;
			}
		}

		exchangeLeaves(node.left);
		exchangeLeaves(node.right);
	}

}
