package Tree;

import java.util.ArrayList;
import java.util.List;

public class Binary_Tree_Right_Side_View {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public List<Integer> rightSideView(TreeNode root) {

		List<Integer> ans = new ArrayList<Integer>();
		rightSideView_(root, 0, new TreeNode(-1), ans);
		return ans;

	}

	public void rightSideView_(TreeNode root, int level, TreeNode pair, List<Integer> ans) {
		if (root == null)
			return;

		if (level > pair.val) {
			pair.val = level;
			ans.add(root.val);
		}
		rightSideView_(root.right, level + 1, pair, ans);
		rightSideView_(root.left, level + 1, pair, ans);

	}

}
