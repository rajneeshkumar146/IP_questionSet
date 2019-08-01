package Graph;

import java.util.ArrayList;

public class Biconnected_Graph {

	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		ArrayList<Integer> list0 = new ArrayList<>();
		list0.add(1);
//		list0.add(2);
//		list0.add(3);
		ArrayList<Integer> list1 = new ArrayList<>();
		list1.add(0);
//		list1.add(2);
//		ArrayList<Integer> list2 = new ArrayList<>();
//		list2.add(1);
//		list2.add(3);
//		ArrayList<Integer> list3 = new ArrayList<>();
//		list3.add(0);
//		list3.add(2);
//
		list.add(list0);
		list.add(list1);
//		list.add(list2);
//		list.add(list3);
		System.out.println(Biconnected(list));
	}

	private static boolean Biconnected(ArrayList<ArrayList<Integer>> list) {
		boolean[] visited = new boolean[list.size()];

		int[] low = new int[list.size()];
		int[] disc = new int[list.size()];
		int[] parent = new int[list.size()];

		boolean ans = Articulationcheck(list, low, disc, parent, visited, 0);
		int count = 0;
		for (int i = 0; i < visited.length; i++) {
			if (visited[i] == true) {
				count++;
			}
		}
		if (count != list.size()) {
			return false;
		} else {
			return ans;
		}
	}

	static int pos = 1;

	private static boolean Articulationcheck(ArrayList<ArrayList<Integer>> list, int[] low, int[] disc, int[] parent,
			boolean[] visited, int src) {
		visited[src] = true;
		low[src] = disc[src] = pos;

		for (int nbr : list.get(src)) {
			if (visited[nbr] == false) {
				parent[nbr] = src;
				boolean ans = Articulationcheck(list, low, disc, parent, visited, nbr);
				if (ans == false) {
					return false;
				}
				low[src] = Math.min(low[src], low[nbr]);

				if (disc[src] < low[nbr]) {
					return false;
				}
			} else {
				if (parent[src] != nbr) {
					low[src] = Math.min(low[src], disc[nbr]);
				}
			}
		}
		return true;
	}
}
