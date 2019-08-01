package Tree;

import java.util.Map;
import java.util.TreeMap;

public class Number_of_root_to_leaf_paths {
	class Node {
		int data;
		Node left, right;

		Node(int item) {
			data = item;
			left = right = null;
		}
	}

	static TreeMap<Integer, Integer> map;

	static void count(Node root, int p) {
		if (root == null)
			return;
		if (root.left == null && root.right == null)
			if (map.containsKey(p))
				map.put(p, map.get(p) + 1);
			else
				map.put(p, 1);
		count(root.left, p + 1);
		count(root.right, p + 1);

	}

	void countPaths(Node root) {
		map = new TreeMap<Integer, Integer>();
		count(root, 1);
		for (Map.Entry m : map.entrySet())
			System.out.print(m.getKey() + " " + m.getValue() + " $");

	}
}
