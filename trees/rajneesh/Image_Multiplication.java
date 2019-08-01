package Tree;

public class Image_Multiplication {
	public static class Node {
		int data;
		Node left;
		Node right;

		Node(int x) {
			data = x;
		}
	}

	public static int imagemultiplication(Node node) {
		int ans = 0;
		imagemultiplication_(node.left, node.right, false);
		return ans + (node.data * node.data) % mod;
	}

	private static int ans = 0;
	private static int mod = (int) 1e9 + 7;

	private static void imagemultiplication_(Node node1, Node node2, boolean flag) {
		if (node1 == null)
			return;

		if (node1 != null && node2 != null && !flag) {
			ans += (node1.data + node2.data) % mod;
			imagemultiplication_(node1.left, node2.right, false);
			imagemultiplication_(node1.right, node2.left, false);
		}

		if (node1 == node2)
			flag = true;
	}
}
