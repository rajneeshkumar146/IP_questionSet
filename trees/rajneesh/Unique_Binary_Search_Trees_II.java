package Tree;

import java.util.ArrayList;
import java.util.List;

public class Unique_Binary_Search_Trees_II {

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public List<TreeNode> helper(int m, int n) {
		List<TreeNode> myList = new ArrayList<TreeNode>();

		// This for loops takes one by one every kth node as root
		for (int k = m; k <= n; k++) {

			List<TreeNode> leftList = new ArrayList<TreeNode>();
			List<TreeNode> rightList = new ArrayList<TreeNode>();

			// Recursive call to generate all possible BSTs for(1.....k-1)
			if (k - 1 > 0) {
				leftList = helper(m, k - 1);
			}

			// Recursive call to generate all possible BSTs for (k+1....n)
			if (k + 1 <= n) {
				rightList = helper(k + 1, n);
			}

			// Now there are a total of noOfLeftTree*noOfRightTree combination
			// possible
			if (leftList.size() != 0 && rightList.size() != 0) {
				for (int i = 0; i < leftList.size(); i++) {
					for (int j = 0; j < rightList.size(); j++) {
						TreeNode root = new TreeNode(k);
						root.left = leftList.get(i);
						root.right = rightList.get(j);
						myList.add(root);
					}
				}
			} else if (leftList.size() != 0) { // if no of rightTree
												// combinations are zero
												// [Boundary case]
				for (int j = 0; j < leftList.size(); j++) {
					TreeNode root = new TreeNode(k);
					root.left = leftList.get(j);
					myList.add(root);
				}
			} else if (rightList.size() != 0) { // if no of leftTree
												// combinations are zero
												// [Boundary case]
				for (int j = 0; j < rightList.size(); j++) {
					TreeNode root = new TreeNode(k);
					root.right = rightList.get(j);
					myList.add(root);
				}
			} else { // base cases
				TreeNode root = new TreeNode(k);
				myList.add(root);
			}

		}

		return myList;
	}

	public List<TreeNode> generateTrees(int n) {

		return helper(1, n);
	}

}
