package Tree;

public class Convert_Sorted_Array_to_Binary_Search_Tree {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public TreeNode sortedArrayToBST(int[] nums) {
		return sortedArrayToBST_(nums, 0, nums.length - 1);
	}

	public TreeNode sortedArrayToBST_(int[] nums, int si, int ei) {
		if (si > ei)
			return null;
		int mid = (si + ei + 1) >> 1; //(si+ei+1)_to_esure_that_all_elements_get_conected_to_left.
		TreeNode node = new TreeNode(nums[mid]);
		node.left = sortedArrayToBST_(nums, si, mid - 1);
		node.right = sortedArrayToBST_(nums, mid + 1, ei);
		return node;
	}
}
