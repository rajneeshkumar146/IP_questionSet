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

public class Pep_JavaIP_12Agraphs_443MotherVertex{
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
		
		// topological sort 
		LinkedList<Integer> stack = new LinkedList<>();
		int[] visited = new int[n + 1];
		for(int v = 1; v < graph.length; v++){
			if(visited[v] == 0){
				topologicalSort(graph, v, visited, stack);
			}
		}
		
		int[] chk = new int[n + 1];
		int fv = stack.getFirst();
		dft(graph, fv, chk);
		
		for(int i = 1; i < chk.length; i++){
			if(chk[i] == 0){
				System.out.println(-1);
				return;
			}
		}
		
		System.out.println(fv);
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
	
	private static void dft(int[][] graph, int v, int[] visited){
		visited[v] = 1;
		
		for(int nbr = 1; nbr < graph.length; nbr++){
			if(visited[nbr] == 0 && graph[v][nbr] != 0){
				dft(graph, nbr, visited);
			}
		}
	}
}

//https://www.geeksforgeeks.org/find-a-mother-vertex-in-a-graph/
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
*/

// Test case 2
/*
7 8
4 1 2
1 2 8
3 2 1 
3 4 6
4 5 8
5 6 3 
7 6 5
5 7 3
3
*/

