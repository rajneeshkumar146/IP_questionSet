package Graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;

public class Graph_valid_Tree {

	public static void main(String[] args) {
		int n = 5;
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			graph.add(new ArrayList<>());
		}
		int[][] edges = { { 0, 1 }, { 0, 2 }, { 0, 3 }, { 1, 4 } };

		for (int i = 0; i < edges.length; i++) {
			int v1 = edges[i][0];
			int v2 = edges[i][1];
			graph.get(v1).add(v2);
			graph.get(v2).add(v1);
		}
		HashSet<Integer> visited1 = new HashSet<>();
		isconnected(0, graph, visited1);
		if (visited1.size() != n) {
			System.out.println(false);
		}
		HashSet<Integer> visited = new HashSet<>();
		for (int i = 0; i < n; i++) {
			if (visited.contains(i) == false) {
				boolean check = iscyclic(i, graph, visited);
				if (check == true) {
					System.out.println(false);
				}
			}
		}
		System.out.println(true);
	}

	private static void isconnected(int src, ArrayList<ArrayList<Integer>> graph, HashSet<Integer> visited) {
		visited.add(src);
		for (int nbr : graph.get(src)) {
			if (visited.contains(nbr) == false) {
				isconnected(nbr, graph, visited);
			}
		}
	}

	private static boolean iscyclic(int src, ArrayList<ArrayList<Integer>> graph, HashSet<Integer> visited) {
		LinkedList<Integer> queue = new LinkedList<>();
		queue.add(src);

		while (queue.size() != 0) {
			int rem = queue.remove();

			if (visited.contains(rem) == true) {
				return true;
			}
			visited.add(rem);
			for (int nbr : graph.get(rem)) {
				if (visited.contains(nbr) == false) {
					queue.add(nbr);
				}
			}
		}
		return false;
	}
}
