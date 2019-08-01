package Tree;

import java.util.LinkedList;
import java.util.List;

public class Kth_Ancestor_in_a_Tree {
	private static class Node {
		int data;
		Node left, right;

		public Node(int data) {
			this.data = data;
		}
	}

	// method1.===============================================================================

	public static int kthAncestor1(Node root, int k, int node) {
		List<Integer> psf = new LinkedList<>();
		kthAncestor1_(root, node, psf);
		if (k > psf.size() - 1 || k <= 0)
			return -1;
		return psf.get(psf.size() - k - 1);
	}

	public static boolean kthAncestor1_(Node root, int node, List<Integer> psf) {
		if (root == null)
			return false;

		boolean res = false;
		psf.add(root.data);
		if (root.data == node)
			return true;

		res = res || kthAncestor1_(root.left, node, psf);
		res = res || kthAncestor1_(root.right, node, psf);

		if (res)
			return true;
		psf.remove(psf.size() - 1);

		return res;
	}

	// method_2=========================================================================

	public static int kthAncestor2(Node root, int k, int node) {
		Node ans = new Node(-1);
		kthAncestor2_(root, node, k, ans);
		return ans.data;

	}

	private static int kthAncestor2_(Node root, int node, int k, Node ans) {
		if (root == null)
			return -1;
		if (root.data == node)
			return 0;

		int left = kthAncestor2_(root.left, node, k, ans);
		if (left == 0) {
			if (left + 1 == k)
				ans.data = root.data;
			return left + 1;
		}

		int right = kthAncestor2_(root.right, node, k, ans);
		if (right == 0) {
			if (right + 1 == k)
				ans.data = root.data;
			return right + 1;
		}

		return -1;

	}
}
