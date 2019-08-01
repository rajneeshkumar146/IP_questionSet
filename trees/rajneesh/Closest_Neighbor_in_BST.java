package Tree;

public class Closest_Neighbor_in_BST {

	static class Node {
		int data;
		Node left, right;

		Node(int key) {
			data = key;
			left = right = null;
		}

	}

	public static int findMaxforKey(Node node, int val, int size) {
		int res = -1;
		while (node != null) {
			if (node.data <= val && node.data >= res) {
				res = node.data;
			}

			if (node.data < val)
				node = node.right;
			else
				node = node.left;
		}
		return res;

	}

}
