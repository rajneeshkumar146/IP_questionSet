package Tree;

import java.util.LinkedList;

public class Binary_Search_Tree_Iterator {

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	LinkedList<TreeNode> st = new LinkedList<>();

	public Binary_Search_Tree_Iterator(TreeNode root) {
		pushAll(root);
	}

	private void pushAll(TreeNode n) {
		while (n != null) {
			st.addFirst(n);
			n = n.left;
		}
	}

	/** @return the next smallest number */
	public int next() {
		TreeNode n = st.removeFirst();
		pushAll(n.right);
		return n.val;
	}

	/** @return whether we have a next smallest number */
	public boolean hasNext() {
		return st.size() != 0;
	}

}
