package Tree;

public class Recover_Binary_Search_Tree {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public void recoverTree(TreeNode node) {
		TreeNode swap = new TreeNode(0); // left_and_right_represent_first_and_second_missplaced_Node.
		TreeNode curr = new TreeNode(0); // just to iterate over tree.
		recoverTree_(node, swap, curr);

		if (swap.left != null) {
			int temp = swap.left.val;
			swap.left.val = swap.right.val;
			swap.right.val = temp;
		}
	}

	public void recoverTree_(TreeNode node, TreeNode swap, TreeNode curr) {
		if (node == null)
			return;

		recoverTree_(node.left, swap, curr);

		if (curr.left == null) {
			curr.left = node;
		} else {
			if (curr.left.val > node.val) {
				if (swap.left == null)
					swap.left = curr.left;
				swap.right = node;
			}
			curr.left = node;
		}

		recoverTree_(node.right, swap, curr);

	}
}
