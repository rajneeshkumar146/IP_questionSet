package Tree;

import java.util.Stack;

public class Equal_Tree_Partition {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	Stack<Integer> st;

	public boolean checkEqualTree(TreeNode root) {
		st = new Stack<>();
		int total = sum(root);
		st.pop();
		if (total % 2 == 0) // no equal partition exist.
			for (int s : st) // if yes then check for equal partition.
				if (s == total / 2)
					return true;
		return false;
	}

	public int sum(TreeNode node) {
		if (node == null)
			return 0;
		st.push(sum(node.left) + sum(node.right) + node.val);
		return st.peek();
	}
}
