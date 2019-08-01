package Tree;

public class Construct_a_Full_Binary_Tree {
	public static class Node {
		int data;
		Node left;
		Node right;

		Node(int x) {
			data = x;
		}
	}

	public Node constructBTree(int pre[], int preM[], int size) {

		return constructBTree_(pre, preM, 0, size - 1, 0, size - 1);

	}

	public Node constructBTree_(int pre[], int preM[], int ps, int pe, int pms, int pme) {
		if (ps > pe)
			return null;

		Node node = new Node(pre[ps]);
		int idx = pms + 1;
		for (; idx <= pme; idx++) {
			if (preM[idx] == pre[ps + 1]) {
				break;
			}
		}

		int count = idx - pms - 1;

		node.left = constructBTree_(pre, preM, ps + 1, ps + count, idx, pme);
		node.right = constructBTree_(pre, preM, ps + 1 + count, pe, pms + 1, idx - 1);
		return node;
	}

}
