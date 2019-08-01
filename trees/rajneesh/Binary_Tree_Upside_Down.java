package Tree;

public class Binary_Tree_Upside_Down {
/*	Given a binary tree where all the right nodes are either leaf nodes with a sibling (a left node that shares the same parent node) or empty, flip it upside down and turn it into a tree where the original right nodes turned into left leaf nodes. Return the new root.
	For example:
	Given a binary tree {1,2,3,4,5},
	    1
	   / \
	  2   3
	 / \
	4   5
	return the root of the binary tree [4,5,2,#,#,3,1].
	   4
	  / \
	 5   2
	    / \
	   3   1  
*/
	
//	https://www.cnblogs.com/grandyang/p/5172838.html
	

/*This question allows us to reverse a binary tree upside down, and restricts whether the right node is either empty or 
 * there must be a corresponding left node. After the upside down, the leftmost child of the original binary tree becomes 
 * the root node, and its corresponding right node becomes its left child node, and its parent node becomes its right child 
 * node, which is equivalent to a clockwise rotation. For general tree questions, there are two solutions, iterative and recursive. 
 * This question is no exception, so let's take a look at the recursive solution. For a root node, our goal is to change its left 
 * child node to the root node, the right child node to the left child node, and the original root node to the right child node. 
 * Then we first determine whether the root node exists and Whether it has a left child node, if these two conditions are not met, 
 * it can be returned directly, and no flip operation is required. Then we keep calling the recursive function on the left child 
 * node until we reach the leftmost child node and start flipping. After flipping the leftmost child node, we can start to go back 
 * to the previous left child node and continue to flip until we flip the whole tree. code show as below:
 */
	
	public static class TreeNode {
		
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	
	public TreeNode upsideDownBinaryTree(TreeNode node){
		if(node==null ||node.left==null) return null;
		
		TreeNode left=node.left;
		TreeNode right=node.right;
		
		TreeNode res=upsideDownBinaryTree(node.left);
		left.right=right;
		left.right=node;

		node.left=null;
		node.right=null;
		return res;
	}
	
	
    public TreeNode upsideDownBTIter(TreeNode node){
	    TreeNode curr = node;
	    TreeNode par = null; // for parent.
	    TreeNode temp = null; // for reight.
	    TreeNode next = null; // for left which is left potential candidate.

	    while (curr != null) {
		   next = curr.left; // store next potential candidate.

		   curr.left = temp;//
		   temp = curr.right;
 
		   curr.right = par; // current right become current parent.

		   par = curr;   //previous parent become parent of next sytree.
		   curr = next;
	}
	    
	    return par;

}
	
	
	
	
	
	
	
	
}
