package Tree;

public class Largest_BST {

	class Node {
		int data;
		Node left, right;

		Node(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}

	public int largestBst(Node node) {
		return LargestBSt(node).size;
	}

	public MinMax LargestBSt(Node node) {
		if (node == null)
			return new MinMax();

		MinMax left = LargestBSt(node.left);
		MinMax right = LargestBSt(node.right);

		MinMax mpair = new MinMax();
		mpair.min = Math.min(Math.min(left.min, right.min), node.data);
		mpair.max = Math.max(Math.max(left.max, right.max), node.data);
		mpair.isBST = left.isBST && right.isBST && left.max < node.data && node.data < right.min;

		if (mpair.isBST)
			mpair.size = left.size + right.size + 1;
		else
			mpair.size = Math.max(left.size, right.size);

		return mpair;
	}

	private class MinMax {
		private int min;
		private int max;
		private boolean isBST;
		private int size;

		private MinMax() {
			min = Integer.MAX_VALUE;
			max = Integer.MIN_VALUE;
			isBST = true;
			size = 0;
		}
	}

}
