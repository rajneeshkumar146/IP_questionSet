package interview.graphs;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

public class Pep_JavaIP_12Agraphs_429MonkAndIslands {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		
		while(t-- > 0){
			int n = scn.nextInt();
			int m = scn.nextInt();
			
			boolean[][] graph = new boolean[n + 1][n + 1];
			for(int i = 1; i <= m; i++){
				int v1 = scn.nextInt();
				int v2 = scn.nextInt();
				
				graph[v1][v2] = true;
				graph[v2][v1] = true;
			}
			
			System.out.println(bfs(graph, 1, n));
		}
	}

	private static int bfs(boolean[][] graph, int v1, int v2) {
		int res = 0;
		
		LinkedList<Integer> queue = new LinkedList<>();
		queue.add(v1);
		queue.add(null);
		
		HashSet<Integer> visited = new HashSet<>();
		
		while(queue.size() > 0){
			Integer rv = queue.removeFirst();
			
			if(rv == null){
				res++;
				queue.addLast(null);
				continue;
			}
			
			if(visited.contains(rv)){
				continue;
			}
			visited.add(rv);
			
			// work
			if(rv == v2){
				break;
			}
			
			for(int nbr = 1; nbr < graph.length; nbr++){
				if(graph[rv][nbr] && !visited.contains(nbr)){
					queue.addLast(nbr);
				}
			}
			
		}
		
		return res;
	}
	
	
	// https://www.hackerearth.com/practice/algorithms/graphs/breadth-first-search/practice-problems/algorithm/monk-and-the-islands/
	// Test cases - hackerearth

}
