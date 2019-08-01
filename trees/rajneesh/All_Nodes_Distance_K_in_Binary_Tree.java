package Tree;

import java.util.ArrayList;
import java.util.List;

public class All_Nodes_Distance_K_in_Binary_Tree {

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public List<Integer> distanceK(TreeNode node, TreeNode target, int k) {
		List<Integer> ans = new ArrayList<>();
		allNodeDistance_KAway_(node, k, target.val, ans);
		return ans;

	}

	private static int allNodeDistance_KAway_(TreeNode node, int k, int data, List<Integer> ans) {
		if (node == null)
			return -1;

		if (node.val == data) {
			kDown_(node, k, ans);
			return 0;
		}

		int dl = allNodeDistance_KAway_(node.left, k, data, ans); // dataNodeToNodeDistanceLeft
		if (dl != -1) {
			if (dl + 1 == k) { // ussDataNodeSeNodeTkKaDistance+1_Agar_K_keEqualHaiToVoNodeAnsHaiNoNeedToGoInRight.
				ans.add(node.val);
			} else {
				kDown_(node.right, k - dl - 2, ans);
			}

			return dl + 1;
		}

		int dr = allNodeDistance_KAway_(node.right, k, data, ans); // dataNodeToNodeDistanceRight
		if (dr != -1) {
			if (dr + 1 == k) { // ussDataNodeSeNodeTkKaDistance+1_Agar_K_keEqualHaiToVoNodeAnsHaiNoNeedToGoInRight.
				ans.add(node.val);
			} else {
				kDown_(node.left, k - dr - 2, ans);
			}

			return dr + 1;
		}

		return -1;

	}

	private static void kDown_(TreeNode node, int k, List<Integer> ans) {
		if (node == null)
			return;

		if (k == 0) {
			ans.add(node.val);
			return;
		}

		kDown_(node.left, k - 1, ans);
		kDown_(node.right, k - 1, ans);
	}

}
