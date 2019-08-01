package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Average_of_Levels_in_Binary_Tree {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public List<Double> averageOfLevels(TreeNode root) {
		LinkedList<TreeNode> que = new LinkedList<>();
		List<Double> ans = new ArrayList<>();
		que.addLast(root);

		while (!que.isEmpty()) {
			int size = que.size();
			int temp = size;
			Double d = 0.0;
			while (temp-- > 0) {
				TreeNode curr = que.removeFirst();
				d += (curr.val * 1.0);

				if (curr.left != null)
					que.addLast(curr.left);
				if (curr.right != null)
					que.addLast(curr.right);
			}

			d = d / (size * 1.0);
			ans.add(d);

		}
		return ans;
	}
}
