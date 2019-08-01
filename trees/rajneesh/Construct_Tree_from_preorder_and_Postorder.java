package Tree;

public class Construct_Tree_from_preorder_and_Postorder {

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public static TreeNode constructFromPrePost(int[] pre, int[] post) {
		return constructPrePost_(pre, post, 0, pre.length - 1, 0, post.length - 1);

	}

	private static TreeNode constructPrePost_(int[] pre, int[] post, int psi, int pei, int posi, int poei) {
		if (psi > pei || posi > poei)
			return null;
		if (psi == pei && posi == poei)
			return new TreeNode(post[poei]);

		int i = posi;
		while (i <= poei && post[i] != pre[psi + 1])
			i++;

		int gap = i - posi;
		TreeNode node = new TreeNode(pre[psi]);
		node.left = constructPrePost_(pre, post, psi + 1, psi + 1 + gap, posi, posi + gap);
		node.right = constructPrePost_(pre, post, psi + gap + 2, pei, posi + gap + 1, poei - 1);

		return node;

	}

}
