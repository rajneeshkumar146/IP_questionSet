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

public class Pep_JavaIP_12Agraphs_447DetectCycleDirected{
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
		
		int[] visited = new int[n + 1];
		int[] ancestors = new int[n + 1];
		for(int i = 1; i < graph.length; i++){
			if(visited[i] == 0){
				boolean cyclic = dft(graph, i, ancestors, visited);
				if(cyclic){
					System.out.println(true);
					return;
				}
			}
		}
		
		System.out.println(false);
	}
	
	// this can solve both directed and undirected
	private static boolean dft(int[][] graph, int v, int[] ancestors, int[] visited){
		visited[v] = 1;
		ancestors[v] = 1;
		
		for(int nbr = 1; nbr < graph.length; nbr++){
			if(graph[v][nbr] != 0){
				if(visited[nbr] == 0){
					boolean cyclic = dft(graph, nbr, ancestors, visited);
					if(cyclic){
						return true;
					}
				} else {
					if(ancestors[nbr] == 1){
						return true;
					}
				}
			}
		}
		
		ancestors[v] = 0;
		return false;
	}
}

//https://www.geeksforgeeks.org/detect-cycle-in-a-graph/
//Test cases

//Test case 1
/*
7 8
1 2
2 3
3 4
1 4
4 5
5 6
6 7
5 7
false
*/

// Test case 2
/*
7 8
1 2
2 3
3 4
1 4
4 5
5 6
6 7
7 5
true
*/

