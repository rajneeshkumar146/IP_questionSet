package Tree;

import java.util.ArrayList;
import java.util.List;

public class Binary_Tree_Postorder_Traversal {

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public static List<Integer> postorderTraversal(TreeNode node) {
		// List<Integer> myAns=postorderTraversalReturnType(node);

		List<Integer> myAns = new ArrayList<>();
		postorderTraversalVoidType(node, myAns);

		return myAns;

	}

	public static List<Integer> postorderTraversalReturnType(TreeNode node) {
		if (node == null)
			return new ArrayList<Integer>();

		List<Integer> myAns = new ArrayList<Integer>();
		List<Integer> left = postorderTraversalReturnType(node.left);
		List<Integer> right = postorderTraversalReturnType(node.right);

		myAns.addAll(left);
		myAns.addAll(right);
		myAns.add(node.val);
		return myAns;

	}

	public static void postorderTraversalVoidType(TreeNode node, List<Integer> myAns) {
		if (node == null)
			return;

		postorderTraversalVoidType(node.left, myAns);
		postorderTraversalVoidType(node.right, myAns);
		myAns.add(node.val);
	}

}
