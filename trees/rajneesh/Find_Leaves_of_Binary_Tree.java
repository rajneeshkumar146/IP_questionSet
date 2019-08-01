package Tree;

import java.util.ArrayList;
import java.util.List;

public class Find_Leaves_of_Binary_Tree {

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	List<List<Integer>> res = new ArrayList<>();

	public List<List<Integer>> findLeaves(TreeNode root) {
		if (root == null) {
			return res;
		}

		while (root.left != null || root.right != null) {
			List<Integer> list = new ArrayList<>();
			traverse(root, list);
			res.add(list);
		}

		List<Integer> list = new ArrayList<>();
		list.add(root.val);
		res.add(list);

		return res;
	}

	public TreeNode traverse(TreeNode root, List<Integer> res) {
		if (root == null) {
			return null;
		}

		if (root.left == null && root.right == null) {
			res.add(root.val);
			return null;
		}

		root.left = traverse(root.left, res);
		root.right = traverse(root.right, res);
		return root;
	}

}
