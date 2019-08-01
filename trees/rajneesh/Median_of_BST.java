package Tree;

public class Median_of_BST {

	private class Node {
		int data;
		Node left;
		Node right;

		Node(int data) {
			this.data = data;
		}
	}

	private static int solve(Node root, int size) {
		int sum = 0;
		Node node = root;

		int count = 0;
		int n1 = (size + 1) / 2;
		int n2 = (size + 2) / 2;

		while (node != null) {
			if (node.left != null) {
				Node lkarm = leftsRightmost(node);

				if (lkarm.right == null) {
					lkarm.right = node;
					node = node.left;
				} else {
					count++;
					if (count == n1 || count == n2) {
						sum += node.data;
					}

					lkarm.right = null;
					node = node.right;
				}
			} else {
				count++;
				if (count == n1 || count == n2) {
					sum += node.data;
				}

				node = node.right;
			}
		}

		return size % 2 == 0 ? sum / 2 : sum;
	}

	private static Node leftsRightmost(Node node) {
		Node curr = node.left;

		while (curr.right != null && curr.right != node) {
			curr = curr.right;
		}

		return curr;
	}

}
