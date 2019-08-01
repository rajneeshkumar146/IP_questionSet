package Tree;

public class Two_Mirror_Trees {

	private static class Node {
		int data;
		Node left, right;

		public Node(int data) {
			this.data = data;
		}
	}

	boolean areMirror(Node a, Node b) {

		if (a == null && b == null)
			return true;
		else if (a == null || b == null)
			return false;
		else if (a.data != b.data)
			return false;
		if (areMirror(a.right, b.left) == false)
			return false;
		if (areMirror(a.left, b.right) == false)
			return false;
		return true;
	}

}
