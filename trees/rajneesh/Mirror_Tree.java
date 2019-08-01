package Tree;

public class Mirror_Tree {

	private static class Node {
		int data;
		Node left, right;

		public Node(int data) {
			this.data = data;
		}
	}

	// method1========================================================

	void mirror(Node node) {
		node = mirror_(node);
	}

	Node mirror_(Node node) {
		if (node == null)
			return null;

		Node re = node.right; // prevent to lost node right in just next step.
		node.right = mirror_(node.left);
		node.left = mirror_(re);
		return node;

	}

	// method2======================================================

	void mirror2(Node node) {
		mirror2_(node);
	}

	void mirror2_(Node node) {
		if (node == null || (node.left == null && node.right == null))
			return;

		mirror2_(node.left);
		mirror2_(node.right);

        Node temp=node.right;
        node.right=node.left;
        node.left=temp;
	
	}

}
