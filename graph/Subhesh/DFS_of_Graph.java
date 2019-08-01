package Graph;

import java.util.ArrayList;

public class DFS_of_Graph {

	public static void main(String[] args) {

	}

	public static void dfs(int src, ArrayList<ArrayList<Integer>> list, boolean vis[]) {
		System.out.print(src + " ");
		vis[src] = true;
		ArrayList<Integer> nbrs = list.get(src);
		for (int i = 0; i < nbrs.size(); i++) {
			if (vis[nbrs.get(i)] == false) {
				dfs(nbrs.get(i), list, vis);
			}
		}
	}
}
