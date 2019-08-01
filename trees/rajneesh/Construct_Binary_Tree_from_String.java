package Tree;

import java.util.LinkedList;

public class Construct_Binary_Tree_from_String {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public TreeNode str2tree(String s) {
		if (s.length() == 0)
			return null;
		StringBuilder sb = new StringBuilder();
		LinkedList<TreeNode> st = new LinkedList<>();
		int i = 0;
		while (i < s.length()) {
			char ch = s.charAt(i++);

			if (ch == '(' && sb.length() > 0) {
				st.addLast(new TreeNode(Integer.parseInt(sb.toString())));
				sb.deleteCharAt(sb.length() - 1);
			} else if (ch == ')') {
				TreeNode curr = null;
				if (sb.length() > 0) {
					curr = new TreeNode(Integer.parseInt(sb.toString()));
				} else {
					curr = st.removeFirst();
				}

				TreeNode node = st.getFirst();
				if (node.left == null)
					node.left = curr;
				else
					node.right = curr;

				sb.deleteCharAt(sb.length() - 1);
			} else {
				sb.append(ch);
			}
		}
		return st.removeFirst();
	}
}
