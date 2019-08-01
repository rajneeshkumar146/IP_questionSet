package Tree;

import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;

public class Leaf_under_budget {
	static class Node {
		int data;
		Node left, right;

		Node(int key) {
			data = key;
			left = right = null;
		}
	}

	// method_01.===========================================================================

	public int getCount(Node node, int bud) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		levelOder(node, pq);

		int count = 0;
		while (!pq.isEmpty()) {
			int val = pq.remove();

			if (val <= bud) {
				count++;
				bud -= val;
			}
		}
		return count;

	}

	public void levelOder(Node node, PriorityQueue<Integer> pq) {
		Queue<Node> que = new LinkedList<>();
		que.add(node);
		int level = 0;
		while (!que.isEmpty()) {
			int size = que.size();
			level++;
			while (size-- > 0) {
				Node curr = que.poll();

				if (curr.left != null)
					que.add(curr.left);
				if (curr.right != null)
					que.add(curr.right);

				if (curr.left == null && curr.right == null)
					pq.add(level);
			}
		}
	}

	// method_02.==================================================================================

	public int getCount_02(Node node, int bud) {
		TreeMap<Integer, Integer> map = new TreeMap<>();
		preOder(node, map, 1);

		int count = 0;

		Set<Map.Entry<Integer, Integer>> set = map.entrySet();

		for (Map.Entry<Integer, Integer> pair : set) {
			for (int i = 0; i < pair.getValue(); i++)
				if (pair.getKey() <= bud) {
					count++;
					bud -= pair.getKey();
				}
		}

		return count;
	}

	public void preOder(Node node, TreeMap<Integer, Integer> map, int level) {
		if (node == null)
			return;
		if (node.left == null && node.right == null)
			map.put(level, map.getOrDefault(level, 0) + 1);

		preOder(node.left, map, level + 1);
		preOder(node.right, map, level + 1);
	}

}
