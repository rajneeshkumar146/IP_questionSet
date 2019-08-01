package Tree;

public class Print_Nodes_having_K_leaves {

	static class Node {
		int data;
		Node left, right;

		Node(int item) {
			data = item;
			left = right = null;
		}
	}

	boolean flag = false;

	public void btWithKleaves(Node root, int k) {
		flag = false;
		int res = btWithKleaves_(root, k);
		if (!flag) {
			System.out.print(-1);
		}
		System.out.println();
	}

	public int btWithKleaves_(Node root, int k) {
		if (root == null)
			return 0;
		if (root.left == null && root.right == null)
			return 1;

		int res = 0;
		res = btWithKleaves_(root.left, k) + btWithKleaves_(root.right, k);
		if (res == k) {
			System.out.print(root.data + " ");
			flag = true;
		}

		return res;
	}

}
