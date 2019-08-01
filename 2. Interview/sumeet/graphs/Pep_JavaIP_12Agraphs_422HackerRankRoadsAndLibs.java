package interview.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Pep_JavaIP_12Agraphs_422HackerRankRoadsAndLibs {
	static long mincost;
	static int clib;
	static int croad;
	static HashMap<Integer, HashSet<Integer>> graph;

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		int q = scn.nextInt();
		while (q-- > 0) {
			int n = scn.nextInt();
			int m = scn.nextInt();
			clib = scn.nextInt();
			croad = scn.nextInt();

			graph = new HashMap<>();
			for(int i = 1; i <= n; i++){
				graph.put(i, new HashSet<>());
			}
			
			for (int i = 0; i < m; i++) {
				int v1 = scn.nextInt();
				int v2 = scn.nextInt();

				graph.get(v1).add(v2);
				graph.get(v2).add(v1);
			}

			mincost = 0;
			dft();
			System.out.println(mincost);
		}
	}

	private static void dft() {
		HashSet<Integer> visited = new HashSet<>();
		for (Integer vtx : graph.keySet()) {
			if (visited.contains(vtx)) {
				continue;
			}

			mincost += clib;
			dftComponent(visited, vtx);
		}
	}

	private static void dftComponent(HashSet<Integer> visited, int src) {
		visited.add(src);

		for (Integer nbr : graph.get(src)) {
			if (visited.contains(nbr) == false) {
				mincost += clib < croad ? clib : croad;
				dftComponent(visited, nbr);
			}
		}
	}
}
