package Tree;

public class Path_Sum_IV {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public int pathSum(int[] nums) {

		TreeNode root = new TreeNode(nums[0] % 10);
		for (int num : nums) {
			if (num == nums[0])
				continue;
			int level = num % 100;
			int pos = (num / 10) % 10;
			int val = num % 10;

			pos--; // in_tree_everything_starting_from_0_indexing_according_to_Math's.

			int depth = level - 2; // parent_level_starting_from_0_is_level-2.

			TreeNode curr = root;

			while (depth >= 0) {

				/*
				 * root se dekhenge ki ne2w child kaha lgne vala hai example 5
				 * level means parent is at 3 level to 3 level pe 8 nodes honge
				 * agar child 10-1=9 position pe hai to ye right mai jana
				 * chahiye qkki level 4 pe 16 childs honge phele 8 child level 3
				 * ke half node ke under hoga
				 */

				if (pos < (1 << depth)) {
					if (curr.left == null)
						curr.left = new TreeNode(val);
					curr = curr.left;
				} else {
					if (curr.right == null)
						curr.right = new TreeNode(val);
					curr = curr.right;
				}

				pos %= (1 << depth);
				depth--;
			}

		}

		ans = 0;
		dfs(root, 0);
		return ans;

	}

	int ans = 0;

	public void dfs(TreeNode node, int sum) {
		if (node == null)
			return;
		sum += node.val;
		if (node.left == null && node.right == null) {
			ans += sum;
		} else {
			dfs(node.left, sum);
			dfs(node.right, sum);
		}
	}

	// https://www.cnblogs.com/grandyang/p/7570954.html

}
