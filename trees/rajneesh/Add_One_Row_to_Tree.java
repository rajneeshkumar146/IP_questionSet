package Tree;

public class Add_One_Row_to_Tree {

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public static TreeNode addOneRow(TreeNode root, int v, int d) {
		if (d == 0)
			return root;
		else if (d == 1) {
			TreeNode node = new TreeNode(v);
			node.left = root;
			return node;
		}

		addOneRow_(root, v, d, 1);
		return root;

	}

	private static void addOneRow_(TreeNode root, int v, int d, int level) {
		if (root == null) {
			return;
		}
		if (level >= d) {
			return;
		}

		if (level == d - 1) {
			TreeNode temp = root.left;
			root.left = new TreeNode(v);
			root.left.left = temp;

			TreeNode temp2 = root.right;
			root.right = new TreeNode(v);
			root.right.right = temp2;
		} else {
			addOneRow_(root.left, v, d, level + 1);
			addOneRow_(root.right, v, d, level + 1);
		}

	}
	
	
	
	// 4 2 6 3 1 5
	// 1
	// 2
	// 4 1 1 2 null null 6 3 1 5
	
	

}
