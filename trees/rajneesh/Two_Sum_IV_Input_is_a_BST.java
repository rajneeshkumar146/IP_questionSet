package Tree;

import java.util.ArrayList;
import java.util.HashSet;

public class Two_Sum_IV_Input_is_a_BST {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public boolean findTarget(TreeNode root, int k) {
		// return findTargetValue_01(root, k);

		return findTargetValue_02(root, k);
	}

	// method_01.============================================================================

	public boolean findTargetValue_01(TreeNode root, int k) {
		HashSet<Integer> map = new HashSet<>();

		flag = false;
		findTargetValue(root, k, map);
		return flag;

	}

	boolean flag = false;

	public void findTargetValue(TreeNode root, int k, HashSet<Integer> map) {
		if (root == null || flag)
			return;
		map.add(root.val);

		if (map.contains(k - root.val) && (k - root.val) != root.val) {
			flag = true;
			return;
		}

		findTargetValue(root.left, k, map);
		findTargetValue(root.right, k, map);

	}

	// method_02.===============================================================================

	public boolean findTargetValue_02(TreeNode root, int k) {

		ArrayList<Integer> arr = new ArrayList<>();
		findTargetValue_02_(root, arr);

		int i = 0;
		int j = arr.size() - 1;
		while (i < j) {
			if (arr.get(i) + arr.get(j) < k) {
				i++;
			} else if (arr.get(i) + arr.get(j) > k) {
				j--;
			} else {
				return true;
			}
		}

		return false;

	}

	public void findTargetValue_02_(TreeNode root, ArrayList<Integer> map) {
		if (root == null)
			return;

		findTargetValue_02_(root.left, map);
		map.add(root.val);
		findTargetValue_02_(root.right, map);

	}

}
