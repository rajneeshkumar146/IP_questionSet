package Tree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Subtree_of_Another_Tree {

	/*
	 * We can find the preorder traversal of the given tree ss and tt, given by,
	 * say s_{preorder}s preorder ​ and t_{preorder}t preorder ​
	 * respectively(represented in the form of a string). Now, we can check if
	 * t_{preorder}t preorder ​ is a substring of s_{preorder}s preorder ​ .
	 * 
	 * But, in order to use this approach, we need to treat the given tree in a
	 * different manner. Rather than assuming a nullnull value for the childern
	 * of the leaf nodes, we need to treat the left and right child as a
	 * lnulllnull and rnullrnull value respectively. This is done to ensure that
	 * the t_{preorder}t preorder ​ doesn't become a substring of s_{preorder}s
	 * preorder ​ even in cases when tt isn't a subtree of ss.
	 * 
	 * You can also note that we've added a '#' before every considering every
	 * value. If this isn't done, the trees of the form s:[23, 4, 5] and t:[3,
	 * 4, 5] will also give a true result since the preorder string of the
	 * t("23 4 lnull rull 5 lnull rnull") will be a substring of the preorder
	 * string of s("3 4 lnull rull 5 lnull rnull"). Adding a '#' before the
	 * node's value solves this problem.
	 * 
	 * Time complexity : O(m^2+n^2+m*n)O(m 2 +n 2 +m∗n). A total of nn nodes of
	 * the tree ss and mm nodes of tree tt are traversed. Assuming string
	 * concatenation takes O(k)O(k) time for strings of length kk and indexOf
	 * takes O(m*n)O(m∗n).
	 * 
	 * Space complexity : O(max(m,n))O(max(m,n)). The depth of the recursion
	 * tree can go upto nn for tree tt and mm for tree ss in worst case.
	 * 
	 * 
	 */

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	// method_01.========================================================================

	HashSet<String> trees = new HashSet<>();

	public boolean isSubtree(TreeNode s, TreeNode t) {
		String tree1 = preorder(s, true);
		String tree2 = preorder(t, true);
		return tree1.indexOf(tree2) >= 0;
	}

	public String preorder(TreeNode t, boolean left) {
		if (t == null) {
			if (left)
				return "lnull";
			else
				return "rnull";
		}
		return "#" + t.val + " " + preorder(t.left, true) + " " + preorder(t.right, false);
	}

	// method_02.===============================================================================

	public boolean isSubtree_(TreeNode s, TreeNode t) {
		if (s == null && t != null)
			return false;
		if (s != null && t == null)
			return false;

		List<TreeNode> ans = new ArrayList<>();
		isfind(t, s, ans);
		for (TreeNode node : ans)
			if (isSameStructure(t, node))
				return true;

		return false;
	}

	boolean isSameStructure(TreeNode t, TreeNode s) {
		if (t == null && s == null)
			return true;
		if (t == null || s == null)
			return false;

		boolean res = false;
		boolean left = t.val == s.val && isSameStructure(t.left, s.left);
		boolean right = t.val == s.val && isSameStructure(t.right, s.right);

		if (left && right)
			return true;
		return false;

	}

	public void isfind(TreeNode t, TreeNode s, List<TreeNode> ans) {
		if (s == null)
			return;

		if (t.val == s.val) {
			ans.add(s);
		}

		isfind(t, s.left, ans);
		isfind(t, s.right, ans);
	}

}
