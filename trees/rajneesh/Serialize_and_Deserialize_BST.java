package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class Serialize_and_Deserialize_BST {

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public String serialize(TreeNode root) {
		if (root == null)
			return null;
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		StringBuilder sb = new StringBuilder();
		while (!q.isEmpty()) {
			TreeNode curr = q.remove();
			if (curr == null) {
				sb.append("x,");
			} else {
				sb.append(curr.val + ",");
				q.add(curr.left);
				q.add(curr.right);
			}
		}
		return sb.substring(0, sb.length() - 1);
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		if (data == null)
			return null;
		Queue<TreeNode> q = new LinkedList<>();
		String[] vals = data.split(",");
		int i = 0;
		TreeNode root = new TreeNode(Integer.valueOf(vals[i++]));
		q.add(root);
		while (!q.isEmpty()) {
			TreeNode n = q.remove();
			if (!vals[i].equals("x")) {
				n.left = new TreeNode(Integer.valueOf(vals[i]));
				q.add(n.left);
			}
			i++;
			if (!vals[i].equals("x")) {
				n.right = new TreeNode(Integer.valueOf(vals[i]));
				q.add(n.right);
			}
			i++;
		}
		return root;
	}

}
