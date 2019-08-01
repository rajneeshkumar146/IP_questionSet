import java.util.HashSet;

public class BinaryTreeCameras {
private class Node{
	Node left, right, root;
}
    public int minCameraCover(Node root) {
        int[] ans = solve(root);
        return Math.min(ans[1], ans[2]);
    }

    // 0: All nodes below this are covered, but not this one
    // 1: All nodes below and incl this are covered - no camera
    // 2: All nodes below this are covered, plus camera here
    public int[] solve(Node node) {
        if (node == null)
            return new int[]{0, 0, 99999};

        int[] L = solve(node.left);
        int[] R = solve(node.right);
        int mL12 = Math.min(L[1], L[2]);
        int mR12 = Math.min(R[1], R[2]);

        int d0 = L[1] + R[1];
        int d1 = Math.min(L[2] + mR12, R[2] + mL12);
        int d2 = 1 + Math.min(L[0], mL12) + Math.min(R[0], mR12);
        return new int[]{d0, d1, d2};
    }
    
    
    //Greedy Approach

        int ans;
        HashSet<Node> covered;
        public int minCameraCover2(Node root) {
            ans = 0;
            covered = new HashSet();
            covered.add(null);

            dfs(root, null);
            return ans;
        }

        public void dfs(Node node, Node par) {
            if (node != null) {
                dfs(node.left, node);
                dfs(node.right, node);

                if (par == null && !covered.contains(node) ||
                        !covered.contains(node.left) ||
                        !covered.contains(node.right)) {
                    ans++;
                    covered.add(node);
                    covered.add(par);
                    covered.add(node.left);
                    covered.add(node.right);
                }
            }
        }
}

