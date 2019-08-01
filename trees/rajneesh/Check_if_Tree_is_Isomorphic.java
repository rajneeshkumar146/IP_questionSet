package Tree;

public class Check_if_Tree_is_Isomorphic {
	private static class Node {
		int data;
		Node left, right;

		public Node(int data) {
			this.data = data;
		}
	}

	public boolean isIsomorphic(Node n1, Node n2) {
		if (n1 == null && n2 == null)
			return true;
		else if (n1 == null || n2 == null)
			return false;

		if (n1.data != n2.data)
			return false;

		// There are two possible cases for n1 and n2 to be isomorphic
		// Case 1: nodes are NOT "Flipped".
		// Case 2: nodes have been "Flipped"
		return (isIsomorphic(n1.left, n2.left) && isIsomorphic(n1.right, n2.right))
				|| (isIsomorphic(n1.left, n2.right) && isIsomorphic(n1.right, n2.left));
	}
}
