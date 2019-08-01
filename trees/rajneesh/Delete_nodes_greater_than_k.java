package Tree;

public class Delete_nodes_greater_than_k {

	private static class Node {
		int data;
		Node left, right;

		Node(int d) {
			data = d;
			left = right = null;
		}
	}

	public static Node deleteNode(Node root, int x) {
		if (root == null)
			return root;
		if (root.data == x) {
			return root.left;
		} else if (root.data > x) {
			return deleteNode(root.left, x);
		} else {
			root.right = deleteNode(root.right, x);
			return root;
		}
	}
	
	// 887 778 916 794 336 387 493 650 422 363 28 691 60 764 927 541 427 173 737
	// 212 369 568 430 783 531 863 124 68 136 930 803 23 59 70 168 394 457 12 43
	// 230 374 422 920 785 538 199 325 316 371 414 527 92 981 957 874 863 171
	// 997 282 306 926 85 328 337 506 847 730 314 858 125 896 583 546 815 368
	// 435 365 44 751 88 809 277 179 789
	// 926
	// 12 23 28 43 44 59 60 68 70 85 88 92 124 125 136 168 171 173 179 199 212
	// 230 277 282 306 314 316 325 328 336 337 363 365 368 369 371 374 387 394
	// 414 422 422 427 430 435 457 493 506 527 531 538 541 546 568 583 650 691
	// 730 737 751 764 778 783 785 789 794 803 809 815 847 858 863 863 874 887
	// 896 916 920

}
