package Tree;

public class Count_Number_of_SubTrees_having_given_Sum {
	static class Node {
		int data;
		Node left, right;

		Node(int d) {
			data = d;
			left = right = null;
		}
	}

	static int count = 0;

	int countSubtreesWithSumX(Node node, int x) {
		count = 0;

		countSubtreesWithSumX_(node, x);
		return count;
	}

	int countSubtreesWithSumX_(Node node, int x) {
		if (node == null)
			return 0;

		int left = countSubtreesWithSumX_(node.left, x);
		int right = countSubtreesWithSumX_(node.right, x);

		if (left + right + node.data == x) {
			count++;
		}

		return left + right + node.data;
	}

}
