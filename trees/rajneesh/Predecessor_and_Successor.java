package Tree;

public class Predecessor_and_Successor {

	static class Node {
		int data;
		Node left, right;

		Node(int item) {
			data = item;
			left = right = null;
		}
	}

	static class Res {
		Node pre = null;
		Node succ = null;
	}

	public static void findPreSuc(Node node, Res p, Res s, int key) {
		if (node == null)
			return;

		if (node.data == key) {
			if (node.left != null) {
				Node nn = node.left;
				while (nn.right != null) {
					nn = nn.right;
				}
				p.pre = nn;
			}

			if (node.right != null) {
				Node nn = node.right;
				while (nn.left != null) {
					nn = nn.left;
				}
				s.succ = nn;
			}
			return;
		}

		if (node.data > key) {
			s.succ = node;
			findPreSuc(node.left, p, s, key);
		} else {
			p.pre = node;
			findPreSuc(node.right, p, s, key);
		}
	}

}
