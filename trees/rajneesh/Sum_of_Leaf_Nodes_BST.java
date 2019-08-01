package Tree;

public class Sum_of_Leaf_Nodes_BST {
	public static class Node {
		int data;
		Node left;
		Node right;

		Node(int x) {
			data = x;
		}
	}

	public int SumofLeafNodes(Node root) {
		if (root == null)
			return 0;
		if (root.left == null && root.right == null)
			return root.data;
		return SumofLeafNodes(root.left) + SumofLeafNodes(root.right);
	}
}
