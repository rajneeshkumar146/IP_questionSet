package Tree;

public class Longest_consecutive_sequence_in_Binary_tree {
	public static class TreeNode {
		int key;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			key = x;
		}
	}

	public int longestConsecutive(TreeNode root) {
		ans = -1;
		longestConsecutive_(root, -1, 1);
		return ans;
	}

	int ans = -1;

	public void longestConsecutive_(TreeNode root, int expectedValue, int pathLength) {
		if (root == null)
			return;

		if (root.key == expectedValue) {
			pathLength++;
			ans = Math.max(ans, pathLength);
		} else { // 6 1 2 R 2 4 R 4 5 R 5 6 R 6 7 R 7 8 L, dry run for this
			pathLength = 1;
		}

		longestConsecutive_(root.left, root.key + 1, pathLength);
		longestConsecutive_(root.right, root.key + 1, pathLength);
	}

}
