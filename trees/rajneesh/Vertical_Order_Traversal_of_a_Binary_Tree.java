package Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class Vertical_Order_Traversal_of_a_Binary_Tree {

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	private static int min;
	private static int max;

	public static ArrayList<ArrayList<Integer>> method_02(TreeNode node) {
		ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
		if (node == null)
			return ans;

		int leftWidth = width(node, true);
		int rightWidth = width(node, false);

		for (int i = 0; i <= leftWidth + rightWidth; i++)
			ans.add(new ArrayList<>());

		ArrayDeque<TreeNode> queN = new ArrayDeque<>(); // for_Node
		ArrayDeque<Integer> queV = new ArrayDeque<>(); // for_Value
		queN.addLast(node);
		queV.addLast(leftWidth);

		while (!queN.isEmpty()) {

			TreeNode nn = queN.removeFirst();
			Integer val = queV.removeFirst();
			ans.get(val).add(nn.val);

			if (nn.left != null) {
				queN.addLast(nn.left);
				queV.addLast(val - 1);
			}

			if (nn.right != null) {
				queN.addLast(nn.right);
				queV.addLast(val + 1);
			}
		}

		// System.out.println(ans);
		return ans;

	}

	private static int width(TreeNode node, boolean IsLeftWidth) {
		if (node == null)
			return -1;
		int left = width(node.left, IsLeftWidth) + (IsLeftWidth ? 1 : -1);
		int right = width(node.right, IsLeftWidth) + (IsLeftWidth ? -1 : 1);

		return Math.max(left, right);
	}

	// 3 9 20 null null 15 7
	// [[9],[3,15],[20],[7]]

}
