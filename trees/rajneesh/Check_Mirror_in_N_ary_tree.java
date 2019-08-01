package Tree;

import java.util.ArrayList;

public class Check_Mirror_in_N_ary_tree {
	private static class Node {
		int data;
		ArrayList<Node> children;

		public Node(int data) {
			this.data = data;
		}
	}

	private static boolean checkMirror(Node node1, Node node2) {
		if (node1.children.size() != node2.children.size() && node1.data != node2.data)
			return false;

		for (int i = 0; i < node1.children.size(); i++) {
			Node ch1 = node1.children.get(i);
			Node ch2 = node2.children.get(node2.children.size() - i - 1);
			if (!checkMirror(ch1, ch2))
				return false;
		}

		return true;

	}
}
