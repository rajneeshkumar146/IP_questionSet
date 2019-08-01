package Tree;

import java.util.ArrayList;
import java.util.List;

public class Binary_Tree_Inorder_Traversal {

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public static List<Integer> inorderTraversal(TreeNode node) {
		// List<Integer> myAns=inorderTraversalReturnType(node);

		List<Integer> myAns = new ArrayList<>();
		inorderTraversalVoidType(node, myAns);

		return myAns;

	}

	public static List<Integer> inorderTraversalReturnType(TreeNode node) {
		if (node == null)
			return new ArrayList<Integer>();

		List<Integer> myAns = new ArrayList<Integer>();
		List<Integer> left = inorderTraversalReturnType(node.left);
		List<Integer> right = inorderTraversalReturnType(node.right);

		myAns.addAll(left);
		myAns.add(node.val);
		myAns.addAll(right);

		return myAns;

	}

	public static void inorderTraversalVoidType(TreeNode node, List<Integer> myAns) {
		if (node == null)
			return;

		inorderTraversalVoidType(node.left, myAns);
		myAns.add(node.val);
		inorderTraversalVoidType(node.right, myAns);
	}

}
