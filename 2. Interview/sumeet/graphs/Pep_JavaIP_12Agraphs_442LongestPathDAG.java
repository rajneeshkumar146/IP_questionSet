package interview.graphs;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;

public class Pep_JavaIP_12Agraphs_442LongestPathDAG{
	public static void main(String[] args) throws Exception  {
		Scanner scn = new Scanner(System.in);
		
		int n = scn.nextInt();
		int m = scn.nextInt();
		
		int[][] graph = new int[n + 1][n + 1];
		for(int i = 1;i <= m; i++){
			int x = scn.nextInt();
			int y = scn.nextInt();
			
			graph[x][y] = scn.nextInt();
		}
		
		int s = scn.nextInt();
		
		// topological sort 
		LinkedList<Integer> stack = new LinkedList<>();
		int[] visited = new int[n + 1];
		for(int v = 1; v < graph.length; v++){
			if(visited[v] == 0){
				topologicalSort(graph, v, visited, stack);
			}
		}
		
		int[] dist = new int[n + 1];
		Arrays.fill(dist, Integer.MIN_VALUE);
		dist[s] = 0;
		
		while(stack.size() > 0){
			int rem = stack.removeFirst();
			
			if(dist[rem] == Integer.MIN_VALUE){
				continue;
			}
			
			for(int nbr = 1; nbr < graph.length; nbr++){
				if(graph[rem][nbr] != 0){
					if(dist[rem] + graph[rem][nbr] > dist[nbr]){
						dist[nbr] = dist[rem] + graph[rem][nbr];
					}
				}
			}
		}
		
		for(int v = 1; v < graph.length; v++){
			System.out.println(v + " " + dist[v]);
		}
	}
	
	private static void topologicalSort(int[][] graph, int v, int[] visited, LinkedList<Integer> stack){
		visited[v] = 1;
		
		for(int nbr = 1; nbr < graph.length; nbr++){
			if(visited[nbr] == 0 && graph[v][nbr] != 0){
				topologicalSort(graph, nbr, visited, stack);
			}
		}
		
		stack.addFirst(v);
	}
	
}

//https://www.geeksforgeeks.org/strongly-connected-components/
//Test cases

//Test case 1
/*
5 5
1 3 2
3 2 5
2 1 6
1 4 8
4 5 2
1
1 13
2 7
3 2
4 8
5 10
*/

// Test case 2
/*
7 8
1 4 2
1 2 8
2 3 1 
3 4 6
4 5 8
5 6 3 
6 7 5
5 7 3
3
1 -2147483648
2 -2147483648
3 0
4 6
5 14
6 17
7 22
*/

