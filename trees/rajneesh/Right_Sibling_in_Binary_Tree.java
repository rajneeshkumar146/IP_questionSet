package Tree;

import Tree.Next_Right_Node.Node;

public class Right_Sibling_in_Binary_Tree {
	class Node {
		int data;
		Node left, right, parent;

		Node(int d) {
			data = d;
			left = right = parent = null;
		}
	}

	public static Node findRightSibling(Node node) {
		// Your code here
		if (node == null || node.parent == null) {
			return null;
		}
		int level = -1;
		Node curNode = node.parent;
		while (curNode.right == node || curNode.right == null) {
			node = curNode;
			curNode = curNode.parent;
			level--;
		}
		curNode = curNode.right;
		level++;
		while (level < 0) {
			if (curNode.left != null) {
				curNode = curNode.left;
			} else if (curNode.right != null) {
				curNode = curNode.right;
			} else {
				break;
			}
			level++;
		}
		if (level == 0) {
			return curNode;
		} else {
			return findRightSibling(curNode);
		}
	}
}
