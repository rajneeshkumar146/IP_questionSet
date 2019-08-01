package interview.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Pep_JavaIP_5Backtracking_167HamiltonianCycle {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		int n = scn.nextInt(); // num vertices
		int e = scn.nextInt(); // num edges

		boolean[][] graph = new boolean[n][n]; // adjacency vertex
		for (int i = 0; i < e; i++) {
			int v1 = scn.nextInt(); // vertex 1
			int v2 = scn.nextInt(); // vertex 2

			graph[v1][v2] = true;
			graph[v2][v1] = true;
		}

		solveHamiltonianCycle(graph, 0, new ArrayList<>());
	}

	public static void solveHamiltonianCycle(boolean[][] graph, int vtx, ArrayList<Integer> hamiltonianCycle) {
		// important here to make the last vertex included for base case
		hamiltonianCycle.add(vtx);

		if (hamiltonianCycle.size() == graph.length) {
			System.out.println("P:" + hamiltonianCycle);
			int fv = hamiltonianCycle.get(0);
			int lv = hamiltonianCycle.get(hamiltonianCycle.size() - 1);
			if (graph[fv][lv] == true) {
				System.out.println("C:" + hamiltonianCycle);
			} else {
				System.out.println("C:null");
			}
			// no return to make sure removal happens in base case
		}
		else {
			for (int nbr = 0; nbr < graph[vtx].length; nbr++) {
				// edge exists
				if (graph[vtx][nbr] == true) {
					// but is not included in path yet
					if (hamiltonianCycle.contains(nbr) == false) {
						solveHamiltonianCycle(graph, nbr, hamiltonianCycle);
					}
				}
			}
		}
		
		hamiltonianCycle.remove(hamiltonianCycle.size() - 1);
	}

}
