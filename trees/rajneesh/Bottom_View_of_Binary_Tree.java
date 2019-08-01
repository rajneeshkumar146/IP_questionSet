package Tree;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Bottom_View_of_Binary_Tree {

	private static class Node {
		int data;
		Node left, right;

		public Node(int data) {
			this.data = data;
		}
	}

	private static class pair {
		Integer d = 0;
		Node node;

		pair(Node node, Integer d) {
			this.node = node;
			this.d = d;
		}
	}

	public static void bottomView(Node root) {
		Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
		LinkedList<pair> que = new LinkedList<>();
		que.addLast(new pair(root, 0));
		while (!que.isEmpty()) {
			pair p = que.removeFirst();
			map.put(p.d, p.node.data);
			if (p.node.left != null)
				que.addLast(new pair(p.node.left, p.d - 1));
			if (p.node.right != null)
				que.addLast(new pair(p.node.right, p.d + 1));
		}

		Set set = map.entrySet();
		Iterator itr = set.iterator();

		while (itr.hasNext()) {
			Map.Entry entry = (Map.Entry) itr.next();
			System.out.print(entry.getValue() + " ");
		}
	}
}
