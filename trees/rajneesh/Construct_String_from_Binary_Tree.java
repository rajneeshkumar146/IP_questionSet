package Tree;

public class Construct_String_from_Binary_Tree {


	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	public String tree2str(TreeNode t) {
		if (t == null) {
			return "";
		}
		if (t.left == null && t.right == null) {
			return t.val + "";
		}

		StringBuilder sb = new StringBuilder();
		sb.append("" + t.val);
		if (t.left != null) {
			sb.append("(");
			sb.append(tree2str(t.left));
			sb.append(")");
			if (t.right != null) {
				sb.append("(");
				sb.append(tree2str(t.right));
				sb.append(")");
			}
		} else {
			sb.append("()(");
			sb.append(tree2str(t.right));
			sb.append(")");
		}
		return sb.toString();

	}

}
