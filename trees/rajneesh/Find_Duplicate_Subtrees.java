package Tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Find_Duplicate_Subtrees {

	static HashMap<String, Integer> map;
	List<TreeNode> ans;

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int data) {
			this.val = data;
			left = null;
			right = null;
		}
	}

	private String inorderTraversal(TreeNode node, Map<String, Integer> map, List<TreeNode> retList) {
		if (node == null)
			return "";

		String str = "(";
		str += inorderTraversal(node.left, map, retList);
		str += Integer.toString(node.val);
		str += inorderTraversal(node.right, map, retList);
		str += ")";

		if (map.get(str) != null && map.get(str) == 1)
			retList.add(node);

		if (map.containsKey(str)) {
			map.put(str, map.get(str) + 1);

		} else
			map.put(str, 1);

		return str;
	}

	public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
		List<TreeNode> retList = new LinkedList<>();
		Map<String, Integer> map = new HashMap<>();
		inorderTraversal(root, map, retList);
		return retList;
	}

}
