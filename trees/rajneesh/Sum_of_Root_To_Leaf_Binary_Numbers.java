package Tree;

public class Sum_of_Root_To_Leaf_Binary_Numbers {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public int sumRootToLeaf(TreeNode node) {
		return sumRootToLeaf_(node, 0);
	}

	public int sumRootToLeaf_(TreeNode node, int curr) {
		if (node == null)
			return 0;
		curr <<= 1;
		curr += node.val;
		if (node.left == null && node.right == null)
			return curr;

		return sumRootToLeaf_(node.left, curr) + sumRootToLeaf_(node.right, curr);
	}
	
	//method2.============================================

	public int pathSum(TreeNode root, String binSoFar) {
		if (root == null)
			return 0;
		binSoFar += root.val;
		if (root.left == null && root.right == null)
			return Integer.parseInt(binSoFar, 2);
		return pathSum(root.right, binSoFar) + pathSum(root.left, binSoFar);
	}

	// [0,0,1,0,0,0,0,0,0,0,1,0,0,1,1,1,1,1,0,1,null,1,0,0,1,1,0,1,1,0,0,0,0,1,1,1,null,0,1,0,1,1,null,1,null,1,1,0,1,1,1,1,1,1,0,1,1,1,0,0,1,1,0,1,1,null,1,null,0,0,null,null,null,null,null,1,null,0,1,0,0,1,null,1,1,null,null,0,0,0,0,null,1,0,1,0,0,0,1,0,0,1,0,1,0,null,null,0,1,1,0,0,null,0,0,1,0,0,1,0,1,null,1,null,null,0,null,1,null,null,0,1,null,1,1,null,null,1,1,null,1,0,1,1,0,null,null,1,1,0,0,0,1,1,0,0,0,1,0,0,1,0,0,1,1,0,1,0,1,1,0,0,0,1,null,1,1,1,0,null,0,0,0,0,1,0,0,0,1,0,1,null,1,1,0,null,1,null,null,0,null,0,null,0,null,0,null,null,null,null,null,null,null,null,1,1,null,null,null,null,null,0,0,0,null,1,0,1,null,0,1,0,0,1,null,0,0,null,1,1,1,null,0,null,0,null,1,null,null,1,0,0,0,1,1,null,1,0,null,null,0,0,0,0,1,1,1,0,1,1,0,0,0,null,null,1,1,null,1,1,null,null,1,0,0,0,1,1,0,1,null,1,null,null,null,null,null,0,1,1,0,0,null,1,1,null,0,null,null,1,0,1,null,1,1,0,null,null,null,0,0,null,null,null,0,null,null,null,1,null,1,1,null,0,null,0,0,1,1,null,1,null,1,0,1,1,1,1,null,null,null,1,0,0,1,0,0,null,null,null,null,null,1,0,1,1,0,0,0,0,null,0,1,0,0,0,1,0,1,null,1,1,0,1,0,1,1,0,0,1,null,null,0,0,0,0,0,0,1,null,null,null,1,1,0,1,0,1,0,null,1,0,0,null,1,1,0,null,null,1,0,1,1,0,0,1,0,1,0,1,0,null,null,0,null,0,1,null,null,null,null,null,null,null,null,0,1,0,null,null,null,1,0,1,0,1,1,null,1,0,0,0,0,null,null,null,null,1,0,null,null,null,0,0,null,0,1,null,0,null,null,null,null,1,1,0,null,null,null,0,1,1,null,null,null,null,null,1,0,null,0,null,null,null,null,null,0,1,0,1,null,null,null,0,1,0,1,1,0,1,null,null,1,1,1,null,null,0,0,0,null,null,null,null,null,null,null,null,0,null,0,1,null,1,1,1,1,1,0,1,0,1,null,0,null,1,0,1,null,null,1,null,1,0,0,1,0,1,1,1,null,null,null,null,null,1,1,1,0,1,0,0,1,0,0,1,1,1,null,null,null,1,null,1,0,1,1,1,1,0,0,0,null,null,null,null,0,null,null,null,null,null,null,null,null,null,null,1,1,1,null,0,1,0,1,null,null,1,1,null,1,0,null,0,null,null,null,null,null,1,null,null,null,null,null,0,1,1,null,null,null,null,1,null,0,1,0,null,null,1,null,null,1,1,1,0,0,0,0,null,1,1,null,null,0,null,null,0,null,null,1,null,null,null,null,null,null,null,null,null,0,null,null,null,null,1,1,null,null,null,null,null,null,1,1,null,1,null,null,null,1,1,1,1,1,1,0,null,1,null,1,null,null,1,null,1,0,0,1,0,0,0,0,null,0,1,null,null,1,null,null,0,0,1,1,1,1,null,null,null,0,1,0,1,1,null,null,null,0,null,null,0,1,0,0,null,0,null,null,0,1,0,null,null,1,0,null,null,0,1,null,1,0,null,0,null,null,1,0,0,null,null,0,null,0,1,1,0,0,0,1,1,0,0,0,null,0,0,null,null,null,null,1,0,1,0,1,0,null,0,0,1,null,1,1,1,0,1,0,null,1,0,null,null,0,0,null,0,null,0,null,null,null,null,0,null,null,null,null,null,0,null,null,null,null,null,null,null,null,null,0,null,null,1,0,null,null,0,1,null,0,null,1,null,null,1,0,null,null,null,null,0,null,null,null,null,1,1,null,1,1,1,1,1,null,null,1,null,null,null,null,null,0,null,null,0,1,null,1,1,1,null,null,1,0,null,1,0,1,null,1,null,1,null,0,0,null,1,1,1,1,0,1,0,null,0,null,0,0,null,null,null,1,1,null,null,0,null,null,null,null,null,null,null,0,1,0,0,null,null,1,null,null,0,1,null,null,null,null,1,null,0,0,null,0,1,null,null,0,null,null,0,1,1,0,1,0,null,null,null,null,null,null,null,null,null,null,null,null,null,0,0,0,0,0,null,null,0,1,null,null,0,0,1,0,0,1,1,null,1,null,1,1,0,null,1,null,1,0,1,1,0,1,null,0,null,1,1,1,null,null,null,null,0,1,0,null,1,0,1,null,null,0,null,null,1,1,1,0,1,0,1,0,null,null,null,0,1,null,null,null,null,null,null,null,null,null,null,null,0,0,0,0,null,null,null,null,null,null,null,1,null,1,null,null,null,0,null,null,0,null,null,null,0,1,0,0,null,null,null,1,null,null,null,null,null,null,null,null,null,null,null,null,null,0,null,null,null,0,null,null,null,null,null,null,0,0,null,null,0,0,null,0,1,null,1,0,0,null,null,0,null,null,0,null,null,1,null,1,null,null,0,0,null,1,null,null,null,0,0,0,null,1,null,1,0,1,null,1,null,1,null,0,null,null,null,1,null,null,null,1,0,null,null,null,null,null,1,null,null,null,null,null,0,null,0,0,0,1,1,1,0,1,null,0,null,null,null,null,null,null,0,null,null,null,0,null,null,null,null,null,1,0,0,null,0,0,null,null,null,0,0,0,1,null,0,null,1,null,null,null,1,null,0,0,null,1,1,1,null,null,null,1,null,null,null,null,1,null,1,1,null,null,null,null,null,null,1,null,0,0,1,null,null,null,0,null,null,null,null,1,0,0,0,1,0,0,1,null,null,null,0,null,0,null,null,null,1,1,0,null,null,null,null,null,1,null,null,null,null,0,null,null,1,null,0,null,null,0,null,null,1,null,null,0,null,null,0,null,null,1,0,1,0,null,1,0,0,1,null,null,0,1,1,null,null,null,null,null,0,1,null,null,null,null,null,0,null,null,null,null,null,null,1,0,null,0,0,0,null,null,null,null,null,null,null,null,null,null,0,null,0,0,0,1,null,0,0,null,null,null,0,1,1,null,1,0,0,1,null,null,null,null,null,null,null,null,null,null,null,null,1,1,1,1,1,0,0,0,null,1,null,1,0,0,1,null,null,0,null,null,1,null,null,null,null,null,1,0,0,null,null,null,1,0,1,0,null,0,0,1,null,1,1,0,null,null,null,1,1,null,null,null,null,null,1,null,null,null,0,null,null,null,null,null,0,0,1,null,null,0,1,1,null,null,null,null,null,null,null,null,null,0,null,null,null,null,null,null,null,null,1,null,null,null,1,null,1,null,0,null,null,null,null,null,null,null,1,1,1,0,null,null,1,null,null,null,null,null,null,0,null,null,0,null,1,1,0,null,1,1,null,1,null,null,1,null,null,1,null,0,1,null,null,null,0,0,null,null,1,0,1,1,0,null,null,1,0,null,1,0,1,1,null,null,0,0,1,0,0,1,0,0,null,null,0,0,null,0,null,null,0,null,null,1,0,0,null,1,null,null,null,1,null,null,0,null,0,0,1,0,null,1,0,null,1,null,null,1,null,null,1,null,null,null,1,null,null,null,null,1,null,null,null,null,null,null,null,null,1,null,null,0,null,null,null,null,0,null,null,1,null,null,null,null,null,null,null,0,null,0,0,null,null,1,null,0,null,1,null,null,null,null,null,null,null,null,1,null,0,null,null,null,null,null,null,null,null,null,null,null,null,1,null,null,null,null,null,null,null,null,null,0,null,1,null,1,1,null,1,null,0,null,null,1,null,null,null,null,1,null,null,null,null,0,1,0,null,1,0,0,1,1,null,0,null,1,1,0,1,0,null,null,1,null,1,null,null,null,null,1,1,null,0,1,1,0,1,null,null,0,null,0,null,null,null,null,0,null,1,null,null,null,null,null,null,0,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,0,1,null,null,null,null,null,0,0,null,null,0,null,0,null,null,0,0,null,0,1,1,null,0,1,1,null,null,null,null,null,null,null,null,1,1,null,0,0,0,0,null,null,1,null,null,0,0,1,null,1,null,1,null,0,null,0,0,1,null,null,null,null,null,null,null,null,null,null,null,0,null,null,1,null,null,null,null,null,null,null,0,null,null,null,null,null,null,null,1,null,0,null,1,1,null,0,null,null,null,null,null,null,1,0,0,null,0,1,null,null,0,null,null,null,null,null,null,null,1,null,null,1,null,null,1,null,null,null,0,null,null,null,null,null,null,null,null,0,null,null,0,null,null,null,null,null,null,1,0,null,null,null,null,0,1,null,null,null,null,1,null,null,1,null,null,null,null,1,null,null,null,null,null,null,null,0]
	// 7354215
}
