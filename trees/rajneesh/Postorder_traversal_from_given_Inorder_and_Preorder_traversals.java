package Tree;

public class Postorder_traversal_from_given_Inorder_and_Preorder_traversals {

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	void printPostOrder(int in[], int pre[], int n) {
		// Your code here
		constructPreIn_(pre, in, 0, n - 1, 0, n - 1);
	}

	private void constructPreIn_(int[] pre, int[] in, int psi, int pei, int isi, int iei) {
		if (psi > pei || isi > iei)
			return;

		int i = isi;
		while (i <= iei && in[i] != pre[psi])
			i++;

		int gap = i - isi;
		constructPreIn_(pre, in, psi + 1, pei + gap, isi, i - 1);
		constructPreIn_(pre, in, psi + gap + 1, pei, i + 1, iei);

		System.out.print(pre[psi] + " ");
	}

}
