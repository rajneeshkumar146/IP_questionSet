package Tree;

public class Convert_Ternary_Expression_to_Binary_Tree {
	class Node {
		char data;
		Node left, right;

		Node(char key) {
			data = key;
			left = right = null;
		}
	}

	public Node convertExp(String str, int i) {
		if (i >= str.length()) {
			return null;
		}

		char ch = str.charAt(i++);
		Node node = new Node(ch);
		char expression = str.charAt(i);
		if (i < str.length() && expression == '?')
			node.left = convertExp(str, i + 1);
		if (i < str.length() && expression == ':')
			node.right = convertExp(str, i + 1);

		return node;
	}

}
