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

public class Pep_JavaIP_12Agraphs_446DetectCycleUndirected{
	public static void main(String[] args) throws Exception  {
		Scanner scn = new Scanner(System.in);
		
		int n = scn.nextInt();
		int m = scn.nextInt();
		
		int[][] graph = new int[n + 1][n + 1];
		for(int i = 1;i <= m; i++){
			int x = scn.nextInt();
			int y = scn.nextInt();
			
			graph[x][y] = 1;
			graph[y][x] = 1;
		}
		
		int[] visited = new int[n + 1];
		for(int i = 1; i < graph.length; i++){
			if(visited[i] == 0){ // checking different components
				boolean cyclic = dft(graph, i, -1, visited);
				if(cyclic){
					System.out.println(true);
					return;
				}
			}
		}
		
		System.out.println(false);
	}
	
	private static boolean dft(int[][] graph, int v, int p, int[] visited){
		visited[v] = 1;
		
		for(int nbr = 1; nbr < graph.length; nbr++){
			if(graph[v][nbr] != 0){
				if(visited[nbr] == 0){
					boolean cyclic = dft(graph, nbr, v, visited);
					if(cyclic){
						return true;
					}
				} else {
					// its a back edge then
					if(nbr != p){ // nbr is visited but not a parent (must be in the psf then)
						return true;
					}
				}
			}
		}
		
		return false;
	}
}

//https://www.geeksforgeeks.org/detect-cycle-undirected-graph/
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
true
*/

// Test case 2
/*
7 7
1 2
2 3
3 4
1 4
4 5
5 6
6 7
true
*/

//Test case 3
/*
7 6
2 3
3 4
1 4
4 5
5 6
6 7
false
*/

