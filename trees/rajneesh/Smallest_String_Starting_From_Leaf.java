package Tree;

public class Smallest_String_Starting_From_Leaf {

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public String smallestFromLeaf(TreeNode root) {
		return smallestFromLeaf_(root, "");
	}

	public String smallestFromLeaf_(TreeNode root, String str) {
		if (root == null)
			return "~";

		String curr = (char) (root.val + 'a') + str;
		if (root.left == null && root.right == null) {
			return curr;
		}

		String left = smallestFromLeaf_(root.left, curr);
		String right = smallestFromLeaf_(root.right, curr);

		return left.compareTo(right) < 0 ? left : right;

	}
}
