package Tree;

public class Binary_Tree_Cameras {

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	enum specification {
		Covered, notCovered, Camera
	}

	static int res = 0;

	public int minCameraCover(TreeNode root) {
		res = 0;
		if (minCameraCover_(root) == specification.notCovered)
			res++;
		return res;
	}

	public specification minCameraCover_(TreeNode root) {
		if (root == null) {
			return specification.Covered;
		}

		specification left = minCameraCover_(root.left);
		specification right = minCameraCover_(root.right);

		if (left == specification.notCovered || right == specification.notCovered) {
			res++;
			return specification.Camera;
		}

		if (left == specification.Camera || right == specification.Camera) {
			return specification.Covered;
		}

		return specification.notCovered;

	}

}
