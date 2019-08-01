package Tree;

public class Transform_to_Sum_Tree {

	class Tree {
		int data;
		Tree left, right;

		Tree(int d) {
			data = d;
			left = null;
			right = null;
		}
	}

	public void toSumTree(Tree root) {
		if (root == null)
			return;

		toSumTree_(root);
	}

	public int toSumTree_(Tree node) {
		if (node == null)
			return 0;

		int left = toSumTree_(node.left);
		int right = toSumTree_(node.right);

		int temp = left + right + node.data;

		node.data = left + right;

		return temp;

	}

}
