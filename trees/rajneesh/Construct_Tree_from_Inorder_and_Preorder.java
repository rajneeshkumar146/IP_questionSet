package Tree;

public class Construct_Tree_from_Inorder_and_Preorder {

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public TreeNode buildTree(int[] pre, int[] in) {
		return constructPreIn_(pre, in, 0, pre.length - 1, 0, in.length - 1);

	}

	private TreeNode constructPreIn_(int[] pre, int[] in, int psi, int pei, int isi, int iei) {
		if (psi > pei || isi > iei)
			return null;

		int i = isi;
		while (i <= iei && in[i] != pre[psi])
			i++;

		int gap = i - isi;
		TreeNode node = new TreeNode(pre[psi]);
		node.left = constructPreIn_(pre, in, psi + 1, pei + gap, isi, i - 1);
		node.right = constructPreIn_(pre, in, psi + gap + 1, pei, i + 1, iei);

		return node;
	}

}
