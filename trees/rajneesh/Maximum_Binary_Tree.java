package Tree;

public class Maximum_Binary_Tree {

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public TreeNode constructMaximumBinaryTree(int[] nums) {
		return constructMaximumBinaryTree_(nums, 0, nums.length - 1);
	}

	public TreeNode constructMaximumBinaryTree_(int[] nums, int n, int m) {
		if (n > m || m < n)
			return null;
		if (n == m)
			return new TreeNode(nums[n]);

		int maxIdx = n;
		int maxEle = nums[maxIdx];
		for (int i = n; i <= m; i++) {
			if (nums[i] > maxEle) {
				maxEle = nums[i];
				maxIdx = i;
			}
		}

		TreeNode node = new TreeNode(maxEle);
		node.left = constructMaximumBinaryTree_(nums, n, maxIdx - 1);
		node.right = constructMaximumBinaryTree_(nums, maxIdx + 1, m);
		return node;

	}
}
