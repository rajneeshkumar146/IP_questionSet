package Tree;

import java.util.HashMap;

public class Clone_A_Binary_Tree {

	private static class Node {
		int data;
		Node left;
		Node right;
		Node random;

		Node(int data, Node left, Node right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}
	}

	private static Node Clone1(Node node) {

		Node root = clone1Worst(node);
		HashMap<Node, Node> map = new HashMap<>();
		clone1PopulateRandom(map, root, node);
		clone1SetRandom(map, root, node);

		return root;
	}

	private static void clone1SetRandom(HashMap<Node, Node> map, Node root, Node node) {
		if (node == null) {
			return;
		}
		root.random = map.get(node.random);
		clone1SetRandom(map, root.left, node.left);
		clone1SetRandom(map, root.right, node.right);
	}

	private static void clone1PopulateRandom(HashMap<Node, Node> map, Node root, Node node) {
		if (node == null) {
			return;
		}
		map.put(node, root);
		clone1PopulateRandom(map, root.left, node.left);
		clone1PopulateRandom(map, root.right, node.right);

	}

	private static Node clone1Worst(Node node) {
		if (node == null) {
			return null;
		}
		Node nnode = new Node(node.data, null, null);

		nnode.left = clone1Worst(node.left);
		nnode.right = clone1Worst(node.right);

		return nnode;

	}

	// clone2======================================================================================================

	private static Node Clone2(Node node) {

		clone2Best(node);
		SetRandoms(node);
		return ExtractTree(node);

	}

	private static void clone2Best(Node node) {

		if (node == null) {
			return;
		}

		clone2Best(node.left);
		clone2Best(node.right);

		Node newLeftchild = new Node(node.data, node.left, null);
		node.left = newLeftchild;

	}

	private static void SetRandoms(Node node) {

		if (node == null) {
			return;
		}

		node.left.random = node.random.left;
		SetRandoms(node.left.left);
		SetRandoms(node.right);

	}

	private static Node ExtractTree(Node onode) {

		Node CloneNode = onode.left;
		Node lcnode = null;
		Node rcnode = null;
		if (onode.left != null && onode.left.left != null) {
			lcnode = ExtractTree(onode.left.left);
		}

		if (onode.right != null) {
			rcnode = ExtractTree(onode.right);
		}

		onode.left = CloneNode.left;
		CloneNode.left = lcnode;
		CloneNode.right = rcnode;
		return CloneNode;

	}

}
