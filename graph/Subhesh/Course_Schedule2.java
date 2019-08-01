package Graph;

import java.util.ArrayList;
import java.util.HashSet;

public class Course_Schedule2 {

	public static void main(String[] args) {
		int[][] prerequisite = { { 1, 0 }, { 0, 1 } };
		int numcourse = 2;
		int[] ans = findOrder(numcourse, prerequisite);
		for (int val : ans) {
			System.out.print(val + " ");
		}
	}

	public static int[] findOrder(int numCourses, int[][] prerequisites) {
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		for (int i = 0; i < numCourses; i++) {
			ArrayList<Integer> temp = new ArrayList<>();
			graph.add(temp);
		}

		for (int i = 0; i < prerequisites.length; i++) {
			int a = prerequisites[i][0];
			int b = prerequisites[i][1];
			graph.get(b).add(a);
		}
		ArrayList<Integer> ans = new ArrayList<>();
		HashSet<Integer> set = new HashSet<>();
		for (int i = 0; i < graph.size(); i++) {
			if (set.contains(i) == false) {
				ArrayList<Integer> tempans = new ArrayList<>();
				boolean s = dfs(i, graph, set, tempans);
				if (s == false) {
					int[] arr = new int[1];
					return arr;
				}
				for (int j = 0; j < tempans.size(); j++) {
					ans.add(0, tempans.get(j));
				}
			}
		}
		int[] arr = new int[ans.size()];
		for (int z = 0; z < arr.length; z++) {
			arr[z] = ans.get(z);
		}
		return arr;
	}

	public static boolean dfs(int src, ArrayList<ArrayList<Integer>> graph, HashSet<Integer> visited,
			ArrayList<Integer> ans) {
		if (visited.contains(src)) {
			return false;
		}
		ArrayList<Integer> list = graph.get(src);
		visited.add(src);
		for (int val : list) {
			if (visited.contains(val) == false) {
				boolean t = dfs(val, graph, visited, ans);
				if (t == false) {
					return false;
				}
			}
		}
		ans.add(src);
		return true;
	}
}
