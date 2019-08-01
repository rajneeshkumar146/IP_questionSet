package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Nary_Tree_Level_Order_Traversal {

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

	public List<List<Integer>> levelOrder(Node root) {
		if (root == null)
			return new ArrayList<>();

		LinkedList<Node> que = new LinkedList<>();
		que.addLast(root);

		List<List<Integer>> ans = new ArrayList<>();
		while (!que.isEmpty()) {
			int size = que.size();
			List<Integer> smallans = new ArrayList<>();

			while (size-- > 0) {
				Node proc = que.removeFirst();
				smallans.add(proc.val);

				for (Node child : proc.children) {
					que.addLast(child);
				}

			}

			ans.add(smallans);

		}

		return ans;
	}

}
