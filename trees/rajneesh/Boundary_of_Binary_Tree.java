package Tree;

import java.util.ArrayList;
import java.util.List;

public class Boundary_of_Binary_Tree {

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	List<Integer> boundaryOfBinaryTree(TreeNode root) {
		if (root == null)
			return new ArrayList<>();

		List<Integer> res = new ArrayList<>();
		leftBoundary(root, res);
		leaves(root, res);
		rightBoundary(root, res);

		return res;
	}

	public void leftBoundary(TreeNode node, List<Integer> res) {
		if (node == null || (node.left != null && node.right != null))
			return;
		res.add(node.val);
		if (node.left != null) {
			leftBoundary(node.left, res);
		} else if (node.right != null) {
			leftBoundary(node.right, res);
		}
	}

	public void leaves(TreeNode node, List<Integer> res) {
		if (node == null)
			return;
		if (node.left != null && node.right != null)
			res.add(node.val);

		leaves(node.left, res);
		leaves(node.right, res);
	}

	public void rightBoundary(TreeNode node, List<Integer> res) {
		if (node == null || (node.left != null && node.right != null))
			return;
		res.add(node.val);
		if (node.right != null) {
			rightBoundary(node.right, res);
		} else if (node.left != null) {
			rightBoundary(node.left, res);
		}
	}
}
