package Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Most_Frequent_Subtree_Sum {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public int[] findFrequentTreeSum(TreeNode root) {
		Map<Integer, Integer> freqMap = new HashMap<>();
		findFrequentTreeSum_(root, freqMap);

		List<Integer> ans = new ArrayList<>();
		for (Integer i : freqMap.keySet()) {
			if (freqMap.get(i) == maxCount) {
				ans.add(i);
			}
		}

		int[] arr = new int[ans.size()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = ans.get(i);
		}
		return arr;

	}

	int maxCount = 0;

	public int findFrequentTreeSum_(TreeNode node, Map<Integer, Integer> freqMap) {
		if (node == null)
			return 0;

		int curr = findFrequentTreeSum_(node.left, freqMap) + findFrequentTreeSum_(node.right, freqMap) + node.val;

		freqMap.put(curr, freqMap.getOrDefault(curr, 0) + 1);
		maxCount = Math.max(maxCount, freqMap.get(curr));
		return curr;
	}
}
