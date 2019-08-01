package Tree;

import Tree.Recover_Binary_Search_Tree.TreeNode;

public class Minimum_Distance_Between_BST_Nodes {

	static int min = -1;
	static int ans = -1;


	public static int minDiffInBST(TreeNode root) {
        ans=1000000;
        min=-1;
		minDiffInBST_(root);
        return ans;
	}
	
	
	public static void minDiffInBST_(TreeNode root) {
		if (root == null) {
			return;
		}

		minDiffInBST_(root.left);
		
		if (min == -1) {
			min = root.val;
		} else {
			ans = Math.min(ans, root.val - min);
			min = root.val;
		}

		minDiffInBST_(root.right);
	}
    
}
