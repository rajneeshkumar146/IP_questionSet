package Tree;

import java.util.HashMap;

public class K_Sum_Paths {
	static class Node {
		int data;
		Node left, right;

		Node(int d) {
			data = d;
			left = right = null;
		}
	}

	public int printCount(Node root, int sum) {

		if (root == null)
			return 0;
		if (root.left == null && root.right == null && root.data != 0 && sum == 0)
			return 0;

		HashMap<Integer, Integer> map = new HashMap<>();
		map.put(0, 1);
		return pathSum_(root, 0, sum, map, "");

	}

	public static int pathSum_(Node root, int currSum, int sum, HashMap<Integer, Integer> map, String ans) {
		if (root == null)
			return 0;

		currSum += root.data;
		int res = 0;
		res += map.getOrDefault(currSum - sum, 0);
		map.put(currSum, map.getOrDefault(currSum, 0) + 1);

		res += pathSum_(root.left, currSum, sum, map, ans + root.data + " ")
				+ pathSum_(root.right, currSum, sum, map, ans + root.data + " ");
		if (map.get(currSum) > 1)
			map.put(currSum, map.get(currSum) - 1);
		else
			map.remove(currSum);

		return res;

	}

}
