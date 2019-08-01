package june4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class save_winterfell {

	public static class edge {
		public int v2;
		public int w;

		public edge(int v2, int w) {
			this.v2 = v2;
			this.w = w;
		}
	}

	static HashMap<Integer, ArrayList<edge>> map;
	static int max;
	static int end;

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		int t = scn.nextInt();

		for (int tc = 0; tc < t; tc++) {

			map = new HashMap<>();
			max = Integer.MIN_VALUE;
			int n = scn.nextInt();

			int start = -1;
			for (int i = 0; i < n - 1; i++) {
				int u = scn.nextInt();
				if (start == -1) {
					start = u;
				}
				int v = scn.nextInt();
				int w = scn.nextInt();
				if (!map.containsKey(u)) {
					map.put(u, new ArrayList<>());
				}
				if (!map.containsKey(v)) {
					map.put(v, new ArrayList<>());
				}

				map.get(u).add(new edge(v, w));
				map.get(v).add(new edge(u, w));

			}

			HashSet<Integer> visited = new HashSet<>();
			dfs(start, visited, 0);

			visited = new HashSet<>();
			max = Integer.MIN_VALUE;
			dfs(end, visited, 0);

			System.out.println(max);

		}
	}

	public static void dfs(int src, HashSet<Integer> visited, int currsum) {
		visited.add(src);
		if (currsum > max) {
			max = currsum;
			end = src;
		}
		if (!map.containsKey(src)) {
			return;
		}

		for (int i = 0; i < map.get(src).size(); i++) {
			edge eg = map.get(src).get(i);
			if (!visited.contains(eg.v2)) {
				dfs(eg.v2, visited, currsum + eg.w);
			}
		}

	}
}
