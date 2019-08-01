package Tree;

public class Find_the_Closest_Element_in_BST {
	public static class Node {
		int data;
		Node left;
		Node right;

		Node(int x) {
			data = x;
		}
	}

	public static int maxDiff(Node root, int k) {
		int ans = 0;
		int min = Integer.MAX_VALUE;

		while (root != null) {
			if (root.data == k) {
				ans = k;
				break;
			}
			if (Math.abs(root.data - k) < min) {
				min = Math.abs(root.data - k);
				ans = root.data;
			}
			if (root.data > k)
				root = root.left;
			else
				root = root.right;
		}

		return ans;

	}
}
