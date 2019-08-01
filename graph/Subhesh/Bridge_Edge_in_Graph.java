package Graph;

import java.util.ArrayList;

public class Bridge_Edge_in_Graph {

	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		ArrayList<Integer> list0 = new ArrayList<>();
		list0.add(1);
		list0.add(2);
		list0.add(3);
		ArrayList<Integer> list1 = new ArrayList<>();
		list1.add(0);
		list1.add(2);
		ArrayList<Integer> list2 = new ArrayList<>();
		list2.add(0);
		list2.add(1);
		ArrayList<Integer> list3 = new ArrayList<>();
		list3.add(0);
		list3.add(4);
		ArrayList<Integer> list4 = new ArrayList<>();
		list4.add(3);

		list.add(list0);
		list.add(list1);
		list.add(list2);
		list.add(list3);
		list.add(list4);
		bridge(list);
	}

	private static void bridge(ArrayList<ArrayList<Integer>> list) {
		boolean[] visited = new boolean[list.size()];
		int[] parent = new int[list.size()];

		int[] disc = new int[list.size()];
		int[] low = new int[list.size()];

		for (int i = 0; i < list.size(); i++) {
			if (visited[i] == false) {
				bridgefind(list, i, visited, parent, disc, low);
			}
		}
	}

	static int pos = 1;

	private static void bridgefind(ArrayList<ArrayList<Integer>> list, int src, boolean[] visited, int[] parent,
			int[] disc, int[] low) {

		disc[src] = low[src] = pos;
		pos++;

		visited[src] = true;
		ArrayList<Integer> vtx = list.get(src);
		for (int v : vtx) {

			if (visited[v] == false) {
				parent[v] = src;

				bridgefind(list, v, visited, parent, disc, low);

				low[src] = Math.min(low[src], low[v]);

				if (disc[src] < low[v]) {
					System.out.println(src + " " + v);
				}
			} else {
				if (parent[src] != v) {
					low[src] = Math.min(low[src], disc[v]);
				}
			}
		}
	}
}
