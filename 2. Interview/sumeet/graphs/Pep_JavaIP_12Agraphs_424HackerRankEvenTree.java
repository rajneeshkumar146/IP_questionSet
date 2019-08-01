package interview.graphs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Pep_JavaIP_12Agraphs_424HackerRankEvenTree {
	static HashMap<Integer, HashSet<Integer>> graph = new HashMap<>();
	static int count = 0;

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		int n = scn.nextInt();
		for (int i = 1; i <= n; i++) {
			graph.put(i, new HashSet<>());
		}

		int p = scn.nextInt();
		for (int i = 0; i < p; i++) {
			int v1 = scn.nextInt();
			int v2 = scn.nextInt();

			graph.get(v1).add(v2);
			graph.get(v2).add(v1);
		}

		postOrder(1, new HashSet<>());
		System.out.println(count);
	}

	public static int postOrder(int src, HashSet<Integer> visited) {
		visited.add(src);

		int size = 1;
		for (int nbr : graph.get(src)) {
			if (visited.contains(nbr) == false) {
				int csize = postOrder(nbr, visited);
				size += csize;
			}
		}
		
		if(size % 2 == 0 && src != 1){
			count++;
		}

		return size;
	}
}
