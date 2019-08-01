package Tree;

import java.util.ArrayList;
import java.util.List;

public class Nary_Tree_Preorder_Traversal {
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

	public List<Integer> preorder(Node root) {
		if (root == null)
			return new ArrayList<>();

		List<Integer> ans = new ArrayList<>();
		ans.add(root.val);
		for (Node child : root.children) {
			ans.addAll(preorder(child));
		}

		return ans;
	}
}
