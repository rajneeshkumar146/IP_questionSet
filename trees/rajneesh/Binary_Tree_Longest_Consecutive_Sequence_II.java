package Tree;

public class Binary_Tree_Longest_Consecutive_Sequence_II {

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	// method_01.=============================================================================

	/*
	 * Approach #1 Brute Force [Time Limit Exceeded]
	 * 
	 * We can easily see that in a tree there is exactly one unique path one
	 * from one node to another. So, the number of paths possible will be equal
	 * to number of pairs of nodes (N2){{N}\choose{2}}(2N​), where NNN is the
	 * number of nodes.
	 * 
	 * Brute force solution of this problem is to find the path between every
	 * two nodes and check whether it is increasing or decreasing. In this way
	 * we can find maximum length increasing or decreasing sequence.
	 * 
	 * Complexity Analysis
	 * 
	 * Time complexity : O(n3)O(n^3)O(n3). Total possible number of paths are
	 * n2n^2n2 and checking every path whether it is increasing or decreasing
	 * will take O(n)O(n)O(n) for one path.
	 * 
	 * Space complexity : O(n3)O(n^3)O(n3). n2n^2n2 paths each with O(n)O(n)O(n)
	 * nodes.
	 */

	// method_02.=============================================================================

	int maxval = 0;
	public int longestConsecutive(TreeNode root) {
		longestPath(root);
		return maxval;
	}

	public int[] longestPath(TreeNode root) {
		if (root == null)
			return new int[] { 0, 0 };
		int inr = 1, dcr = 1;
		if (root.left != null) {
			int[] l = longestPath(root.left);
			if (root.val == root.left.val + 1)
				dcr = l[1] + 1;
			else if (root.val == root.left.val - 1)
				inr = l[0] + 1;
		}
		if (root.right != null) {
			int[] r = longestPath(root.right);
			if (root.val == root.right.val + 1)
				dcr = Math.max(dcr, r[1] + 1);
			else if (root.val == root.right.val - 1)
				inr = Math.max(inr, r[0] + 1);
		}
		maxval = Math.max(maxval, dcr + inr - 1);
		return new int[] { inr, dcr };
	}
	
	/*
	 * This solution is very simple. With every node, we associate two
	 * values/variables named inrinrinr and dcrdcrdcr, where incrincrincr
	 * represents the length of the longest incrementing branch below the
	 * current node including itself, and dcrdcrdcr represents the length of the
	 * longest decrementing branch below the current node including itself.
	 * 
	 * We make use of a recursive function longestPath(node) which returns an
	 * array of the form [inr,dcr][inr, dcr][inr,dcr] for the calling node. We
	 * start off by assigning both inrinrinr and dcrdcrdcr as 1 for the current
	 * node. This is because the node itself always forms a consecutive
	 * increasing as well as decreasing path of length 1.
	 * 
	 * Then, we obtain the length of the longest path for the left child of the
	 * current node using longestPath[root.left]. Now, if the left child is just
	 * smaller than the current node, it forms a decreasing sequence with the
	 * current node. Thus, the dcrdcrdcr value for the current node is stored as
	 * the left child's dcrdcrdcr value + 1. But, if the left child is just
	 * larger than the current node, it forms an incrementing sequence with the
	 * current node. Thus, we update the current node's inrinrinr value as
	 * left_child(inr)+1left\_child(inr) + 1left_child(inr)+1.
	 * 
	 * Then, we do the same process with the right child as well. But, for
	 * obtaining the inrinrinr and dcrdcrdcr value for the current node, we need
	 * to consider the maximum value out of the two values obtained from the
	 * left and the right child for both inrinrinr and dcrdcrdcr, since we need
	 * to consider the longest sequence possible.
	 * 
	 * Further, after we've obtained the final updated values of inrinrinr and
	 * dcrdcrdcr for a node, we update the length of the longest consecutive
	 * path found so far as maxval=max(inr+dcr−1)maxval = \text{max}(inr + dcr -
	 * 1)maxval=max(inr+dcr−1).
	 * 
	 * The following animation will make the process clear:
	 */

}
