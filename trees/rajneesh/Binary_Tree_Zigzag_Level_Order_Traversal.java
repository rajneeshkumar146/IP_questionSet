package Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Binary_Tree_Zigzag_Level_Order_Traversal {

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public List<List<Integer>> zigzagLevelOrder(TreeNode node) {
		if (node == null)
			return new ArrayList<>();

		List<List<Integer>> ans = new ArrayList<>();
		List<Integer> arr = new ArrayList<>();

		Stack<TreeNode> st = new Stack<>();
		Stack<TreeNode> st1 = new Stack<>();
		st.push(node);
		int count = 0;
		while (!st.isEmpty()) {
			TreeNode nd = st.pop();
			arr.add(nd.val);

			if ((count & 1) == 0) {
				if (nd.left != null)
					st1.push(nd.left);
				if (nd.right != null)
					st1.push(nd.right);

			} else {
				if (nd.right != null)
					st1.push(nd.right);
				if (nd.left != null)
					st1.push(nd.left);
			}

			if (st.size() == 0) {
				Stack<TreeNode> temp = st;
				st = st1;
				st1 = temp;
				ans.add(arr);
				arr = new ArrayList<>();
				count++;
			}
		}
		return ans;

	}

}
