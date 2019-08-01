package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class Recover_a_Tree_From_Preorder_Traversal {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	Queue<Integer> valQue = new LinkedList<>();
	Queue<Integer> levelQue = new LinkedList<>();

	TreeNode preOrder() {

		if (valQue.isEmpty()) {
			return null;
		}
		int val = valQue.remove();
		int level = levelQue.remove();
		TreeNode root = new TreeNode(val);
		if (!levelQue.isEmpty()) {
			int nextLevel = levelQue.peek();

			if (nextLevel == level + 1) {
				root.left = preOrder();
			}
		}

		if (!levelQue.isEmpty()) {
			int nextLevel = levelQue.peek();
			if (nextLevel == level + 1) {
				root.right = preOrder();
			}
		}

		return root;
	}

	void prepare(String S) {
		int idx = 0;
		while (idx < S.length()) {
			int level = 0;
			while (S.charAt(idx) == '-') {
				level++;
				idx++;
			}
			levelQue.add(level);

			int val = 0;
			while (idx < S.length() && Character.isDigit(S.charAt(idx))) {
				val *= 10;
				val += S.charAt(idx) - '0';
				idx++;
			}
			valQue.add(val);
		}
	}

	public TreeNode recoverFromPreorder(String S) {
		prepare(S);
		return preOrder();
	}
}
