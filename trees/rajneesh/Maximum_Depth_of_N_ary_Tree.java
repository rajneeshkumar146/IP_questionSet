package Tree;

import java.util.List;

public class Maximum_Depth_of_N_ary_Tree {

	class Node {
		public int val;
		public List<Node> children;

		public Node() {
		}

		public Node(int _val, List<Node> _children) {
			val = _val;
			children = _children;
		}
	}

	public static int maxDepth(Node root) {
		return Depth(root);

	}

	public static int Depth(Node root) {

		if (root == null)
			return 0;

		int height = 1;
		for (Node child : root.children) {
			int ch = Depth(child);

			height = Math.max(height, ch + 1);

		}

		return height;

	}

}
