package Tree;

import java.util.ArrayList;
import java.util.List;

public class Binary_Tree_Paths {

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public List<String> binaryTreePaths(TreeNode root) {
		List<String> ans = new ArrayList<>();
		binaryTreePaths_(root, "", ans);
		return ans;
	}

	public void binaryTreePaths_(TreeNode node, String str, List<String> ans) {
		if (node == null)
			return;
		if (node.left == null && node.right == null) {
			str += node.val;
			ans.add(str);
			return;
		}

		binaryTreePaths_(node.left, str + node.val + "->", ans);
		binaryTreePaths_(node.right, str + node.val + "->", ans);
	}
}
