package Tree;

import java.util.ArrayList;
import java.util.Collections;

public class Maximum_Width_of_Tree {

	class Node {
		int data;
		Node left, right;

		Node(int item) {
			data = item;
			left = right = null;
		}
	}

	int getMaxWidth(Node root) {
		ArrayList<Integer> levelArr = new ArrayList<>(); // maximumSizeGoesTo_LogN.
		MaximumWidth(root, levelArr, 0);
		return (Collections.max(levelArr)); // logN_loopToFindMaximum.
	}

	private static void MaximumWidth(Node node, ArrayList<Integer> levelArr, int level) {

		if (node == null)
			return;

		if (level < levelArr.size())
			levelArr.set(level, levelArr.get(level) + 1);
		else
			levelArr.add(1);

		MaximumWidth(node.left, levelArr, level + 1);
		MaximumWidth(node.right, levelArr, level + 1);

	}
}
