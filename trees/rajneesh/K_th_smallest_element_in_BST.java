package Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class K_th_smallest_element_in_BST {

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public int kthSmallest(TreeNode root, int k) {
		if (root.left == null && root.right == null && k == 1)
			return root.val;
		return kthSmallest_(root, k, new Stack<>());

	}

	public int kthSmallest_(TreeNode root, int k, Stack<TreeNode> st) {
		if (root == null)
			return -1;

		if (st.size() == k)
			return st.pop().val;

		int left = kthSmallest_(root.left, k, st);
		if (left != -1)
			return left;

		st.add(root);

		int right = kthSmallest_(root.right, k, st);
		if (right != -1)
			return right;

		if (st.size() == k)
			return st.pop().val;
		return -1;
	}

	// method 2===========================================================

	public int kthSmallest2(TreeNode root, int k) {
		List<Integer> ans = new ArrayList<>();
		kthSmallest2_(root, ans);
		return ans.get(k - 1);

	}

	private static void kthSmallest2_(TreeNode node, List<Integer> ans) {
		if (node == null)
			return;

		kthSmallest2_(node.left, ans);
		ans.add(node.val);
		kthSmallest2_(node.right, ans);
	}

	// [3,1,4,null,2]
	// 1
	// 1

	// [1,null,2]
	// 2
	// 2

}
