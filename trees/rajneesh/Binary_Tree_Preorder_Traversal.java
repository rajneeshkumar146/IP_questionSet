package Tree;

import java.util.ArrayList;
import java.util.List;


public class Binary_Tree_Preorder_Traversal {

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public static List<Integer> preorderTraversal(TreeNode node) {
		// List<Integer> myAns=preorderTraversalReturnType(node);

		List<Integer> myAns = new ArrayList<>();
		preorderTraversalVoidType(node, myAns);

		return myAns;

	}

	public static List<Integer> preorderTraversalReturnType(TreeNode node) {
		if (node == null)
			return new ArrayList<Integer>();

		List<Integer> myAns = new ArrayList<Integer>();
		List<Integer> left = preorderTraversalReturnType(node.left);
		List<Integer> right = preorderTraversalReturnType(node.right);

		myAns.add(node.val);
		myAns.addAll(left);
		myAns.addAll(right);

		return myAns;

	}

	public static void preorderTraversalVoidType(TreeNode node, List<Integer> myAns) {
		if (node == null)
			return;

		myAns.add(node.val);
		preorderTraversalVoidType(node.left, myAns);
		preorderTraversalVoidType(node.right, myAns);
	}

}
