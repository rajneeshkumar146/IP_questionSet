package Tree;

public class Distribute_Coins_in_Binary_Tree {

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	static int ans = 0;

	public int distributeCoins(TreeNode root) {
		ans = 0;
		if (distributeCoins_(root) != 0) {
			return -1;
		}
		return ans;
	}

	public int distributeCoins_(TreeNode root) {
		if (root == null)
			return 0;

		// here_we_find_deficit_and_excess_on_each_node_for_left_and_right_sub_tree

		int leftDeficiteAndExcess = distributeCoins_(root.left);
		int rightDeficiteAndExcess = distributeCoins_(root.right);

		ans += Math.abs(leftDeficiteAndExcess) + Math.abs(rightDeficiteAndExcess);

		return root.val - 1 + leftDeficiteAndExcess + rightDeficiteAndExcess; // for_solution_root_should_be_zero.
	}
}
