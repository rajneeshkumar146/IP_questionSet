package Tree;

public class Construct_Tree_from_Inorder_and_Postorder {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public TreeNode buildTree(int[] in, int[] post) {
		return constructor_postIn_(post, in, 0, post.length - 1, 0, in.length - 1);

	}

	private TreeNode constructor_postIn_(int[] post, int[] in, int psi, int pei, int isi, int iei) {
		if (psi > pei || isi > iei)
			return null;

		int i = isi;
		while (i <= iei && in[i] != post[pei])
			i++;

		int gap = i - isi;
		TreeNode node = new TreeNode(post[pei]);
		node.left = constructor_postIn_(post, in, psi, psi + gap - 1, isi, i - 1);
		node.right = constructor_postIn_(post, in, psi + gap, pei - 1, i + 1, iei);
		return node;
	}
}
