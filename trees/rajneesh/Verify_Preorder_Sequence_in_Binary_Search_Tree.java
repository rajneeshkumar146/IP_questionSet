package Tree;

public class Verify_Preorder_Sequence_in_Binary_Search_Tree {

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public boolean verifyPreorder(int[] preorder) {
		idx = 0;
		verifyPreorder(preorder, -100000, 1000000);
		if (idx == preorder.length) {
			return true;
		}
		return false;

	}

	int idx = 0;

	public void verifyPreorder(int[] preorder, int min, int max) {
		if (idx >= preorder.length)
			return;

		int ele = preorder[idx];

		boolean res = false;
		if (ele > min && ele < max) {
			idx++;
			verifyPreorder(preorder, min, ele);
			verifyPreorder(preorder, ele, max);

		}

	}

}
