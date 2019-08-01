package Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class K_th_largest_element_in_BST {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public int kthLargest(TreeNode root, int k) {
		if (root.left == null && root.right == null && k == 1)
			return root.val;
		return kthLargest_(root, k, new Stack<>());

	}

	public int kthLargest_(TreeNode root, int k, Stack<TreeNode> st) {
		if (root == null)
			return -1;

		if (st.size() == k)
			return st.pop().val;

		int right = kthLargest_(root.right, k, st);
		if (right != -1)
			return right;

		st.add(root);

		int left = kthLargest_(root.left, k, st);
		if (left != -1)
			return left;

		if (st.size() == k)
			return st.pop().val;
		return -1;
	}

	// method 2===========================================================

	public int kthLargest2(TreeNode root, int k) {
		List<Integer> ans = new ArrayList<>();
		kthLargest2_(root, ans);
		return ans.get(k - 1);

	}

	private static void kthLargest2_(TreeNode node, List<Integer> ans) {
		if (node == null)
			return;

		kthLargest2_(node.left, ans);
		ans.add(node.val);
		kthLargest2_(node.right, ans);
	}
}
