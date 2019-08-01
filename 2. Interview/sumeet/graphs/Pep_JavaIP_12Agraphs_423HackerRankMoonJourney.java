package interview.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Pep_JavaIP_12Agraphs_423HackerRankMoonJourney {

	static HashMap<Integer, HashSet<Integer>> graph = new HashMap<>();

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		int n = scn.nextInt();
		for (int i = 0; i < n; i++) {
			graph.put(i, new HashSet<>());
		}

		int p = scn.nextInt();
		for (int i = 0; i < p; i++) {
			int v1 = scn.nextInt();
			int v2 = scn.nextInt();

			graph.get(v1).add(v2);
			graph.get(v2).add(v1);
		}

		long count = dft(n);
		System.out.println(count);
	}

	static long dft(int n) {
		long res = 0;

		ArrayList<HashSet<Integer>> gcc = new ArrayList<>();
		HashSet<Integer> visited = new HashSet<>();
		for (Integer vtx : graph.keySet()) {
			if (visited.contains(vtx)) {
				continue;
			}

			HashSet<Integer> comp = new HashSet<>();
			dftComponenet(vtx, visited, comp);
			gcc.add(comp);
		}

		int remaining = n;
		for (int i = 0; i < gcc.size() - 1; i++) {
			remaining -= gcc.get(i).size();
			res += gcc.get(i).size() * remaining;
		}

		return res;
	}

	private static void dftComponenet(Integer vtx, HashSet<Integer> visited, HashSet<Integer> comp) {
		visited.add(vtx);
		comp.add(vtx);

		for (Integer nbr : graph.get(vtx)) {
			if (visited.contains(nbr) == false) {
				dftComponenet(nbr, visited, comp);
			}
		}
	}

}
