package graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class CloneAGraph {

	class Node {
		public int val;
		public ArrayList<Node> neighbors;

		public Node() {
		}

		public Node(int _val, ArrayList<Node> _neighbors) {
			val = _val;
			neighbors = _neighbors;
		}
	}

	HashMap<Node, Node> map = new HashMap<CloneAGraph.Node, CloneAGraph.Node>();

	public Node cloneGraph(Node node) {

		if (node == null) {
			return null;
		}

		LinkedList<Node> queue = new LinkedList<CloneAGraph.Node>();
		Node newNode = new Node(node.val, new ArrayList<CloneAGraph.Node>());
		map.put(node, newNode);
		queue.add(node);
		while (!queue.isEmpty()) {
			Node rn = queue.remove();
			for (Node nbr : rn.neighbors) {
				if (!map.containsKey(nbr)) {
					Node newNode1 = new Node(nbr.val, new ArrayList<CloneAGraph.Node>());
					queue.add(nbr);
					map.put(nbr, newNode1);
				}
				map.get(rn).neighbors.add(map.get(nbr));

			}

		}
		return newNode;

	}

}
