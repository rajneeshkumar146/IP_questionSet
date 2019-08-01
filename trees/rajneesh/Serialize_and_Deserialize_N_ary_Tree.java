package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Queue;

public class Serialize_and_Deserialize_N_ary_Tree {
	class TreeNode {
		public int val;
		public List<TreeNode> children;

		public TreeNode() {
		}

		public TreeNode(int _val, List<TreeNode> _children) {
			val = _val;
			children = _children;
		}
	}

	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {
		if (root == null)
			return "";
		List<int[]> l = new ArrayList<>();
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		while (!q.isEmpty()) {
			TreeNode node = q.poll();
			int[] pair = new int[2];
			pair[0] = node.val;
			pair[1] = node.children.size();
			l.add(pair);
			for (TreeNode child : node.children) {
				q.add(child);
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int[] pair : l) {
			sb.append(pair[0] + "," + pair[1] + " ");
		}
		return sb.toString();
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		if (data.equals(""))
			return null;
		String[] strings = data.split(" ");
		List<int[]> l = new ArrayList<>();
		for (String s : strings) {
			String[] pair = s.split(",");
			l.add(new int[] { Integer.parseInt(pair[0]), Integer.parseInt(pair[1]) });
		}
		Queue<TreeNode> q = new LinkedList<>();
		TreeNode root = new TreeNode(-1, new ArrayList<TreeNode>());
		q.add(root);

		ListIterator<int[]> iter = l.listIterator();
		while (!q.isEmpty()) {
			TreeNode node = q.poll();
			int[] pair = iter.next();
			node.val = pair[0];
			List<TreeNode> children = node.children;
			for (int i = 0; i < pair[1]; i++) {
				TreeNode child = new TreeNode(-1, new ArrayList<>());
				children.add(child);
				q.add(child);
			}
		}
		return root;
	}
}
