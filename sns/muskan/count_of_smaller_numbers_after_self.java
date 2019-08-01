package pep_sns;

public class count_of_smaller_numbers_after_self {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums= {5,1,1,3,2,7,0,2};
		Integer[] arr = countSmaller(nums);
		for(Integer val: arr) {
			System.out.print(val + " ");
		}
	}
	
	public static Integer[] countSmaller(int[] nums) {
        Integer[] result = new Integer[nums.length];
         
        BSTNode root = null;
        for (int i = nums.length - 1; i >= 0; i--) {
            root = insert(root, nums[i], i, result, 0);
        }
         
        return result;
    }
     
    private static BSTNode insert(BSTNode root, int num, int i, Integer[] result, 
                           int preSum) {
        if (root == null) {
            root = new BSTNode(num, 0);
            result[i] = preSum;
            return root;
        } else if (root.val == num) {
            root.dup++;
            result[i] = preSum + root.numOfLeftNodes;
            return root;
        } else if (root.val > num) {
            root.numOfLeftNodes++;
            root.left = insert(root.left, num, i, result, preSum);
        } else {
            root.right = insert(root.right, num, i, result, 
                preSum + root.numOfLeftNodes + root.dup);
        }
         
        return root;
    }
     
    public static class BSTNode {
        int val;
        int dup = 1;
        int numOfLeftNodes;
        BSTNode left, right;
         
        BSTNode(int val, int numOfLeftNodes) {
            this.val = val;
            this.numOfLeftNodes = numOfLeftNodes;
        }
    }

}
