package interview.backtracking;

import java.util.HashSet;
import java.util.Scanner;

public class Pep_JavaIP_5Backtracking_166HasPathLongerThanK {

	static int minWeight = 0;
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		int n = scn.nextInt(); // num vertices
		int e = scn.nextInt(); // num edges
		
		int[][] graph = new int[n][n]; // adjacency vertex
		for (int i = 0; i < e; i++) {
			int v1 = scn.nextInt(); // vertex 1
			int v2 = scn.nextInt(); // vertex 2
			int weight = scn.nextInt(); // weight of the edge

			graph[v1][v2] = weight;
			graph[v2][v1] = weight;
		}
		
		int src = scn.nextInt(); // src vertex
		minWeight = scn.nextInt(); // permitted weight
		
		boolean res = hasPathLongerThanK(graph, src, src + "", 0, new HashSet<>());
		System.out.println(res);
	}

	public static boolean hasPathLongerThanK(int[][] graph, int vtx, String psf, 
										  	 int wsf, HashSet<Integer> processed){
		if(wsf >= minWeight){
			return true;
		}
		
		processed.add(vtx);
		for(int nbr = 0; nbr < graph.length; nbr++){
			if(graph[vtx][nbr] != 0 && !processed.contains(nbr)){ // edge and not cyclic
				boolean rres = hasPathLongerThanK(graph, nbr, psf + nbr, 
												  wsf + graph[vtx][nbr], processed);
				if(rres == true){
					return true;
				}
			}
		}
		processed.remove(vtx);
		
		return false;
	}
}
