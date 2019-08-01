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

public class Pep_JavaIP_12Agraphs_440StronglyConnectedComponents{
	public static void main(String[] args) throws Exception  {
		Scanner scn = new Scanner(System.in);
		
		int n = scn.nextInt();
		int m = scn.nextInt();
		
		int[][] graph = new int[n + 1][n + 1];
		for(int i = 1;i <= m; i++){
			int x = scn.nextInt();
			int y = scn.nextInt();
			
			graph[x][y] = 1;
		}
		
		// topological sort 
		LinkedList<Integer> stack = new LinkedList<>();
		int[] visited = new int[n + 1];
		for(int v = 1; v < graph.length; v++){
			if(visited[v] == 0){
				topologicalSort(graph, v, visited, stack);
			}
		}
		
		// reversing the edges
		int[][] tgraph = new int[n + 1][n + 1];
		for(int i = 0; i < graph.length; i++){
			for(int j = 0; j < graph[i].length; j++){
				if(graph[i][j] == 1){
					tgraph[j][i] = 1;
				}
			}
		}
		
		visited = new int[n + 1];
		while(stack.size() > 0){
			int v = stack.removeFirst();
			if(visited[v] == 0){
				dft(tgraph, v, visited);
				System.out.println(".");
			}
		}
	}
	
	private static void topologicalSort(int[][] graph, int v, int[] visited, LinkedList<Integer> stack){
		visited[v] = 1;
		
		for(int nbr = 1; nbr < graph.length; nbr++){
			if(visited[nbr] == 0 && graph[v][nbr] == 1){
				topologicalSort(graph, nbr, visited, stack);
			}
		}
		
		stack.addFirst(v);
	}
	
	private static void dft(int[][] graph, int v, int[] visited){
		visited[v] = 1;
		System.out.print(v + " ");
		
		for(int nbr = 1; nbr < graph.length; nbr++){
			if(visited[nbr] == 0 && graph[v][nbr] == 1){
				dft(graph, nbr, visited);
			}
		}
	}
}

//https://www.geeksforgeeks.org/strongly-connected-components/
//Test cases

//Test case 1
/*
5 5
1 3
3 2
2 1
1 4
4 5
1 2 3 .
4 .
5 .
*/

// Test case 2
/*
7 8
4 1
1 2
2 3 
3 4
4 5
5 6
6 7
7 5
1 4 3 2 .
5 7 6 .
*/

