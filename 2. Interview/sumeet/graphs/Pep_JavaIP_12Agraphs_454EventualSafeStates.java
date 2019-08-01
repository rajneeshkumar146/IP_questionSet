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

public class Pep_JavaIP_12Agraphs_454EventualSafeStates{
	public static void main(String[] args) throws Exception  {
		Scanner scn = new Scanner(System.in);
		
		int n = scn.nextInt();
		int m = scn.nextInt();
		
		int[][] graph = new int[n][n];
		for(int i = 1;i <= m; i++){
			int x = scn.nextInt();
			int y = scn.nextInt();
			
			graph[x][y] = 1;
		}
		
		int[] visited = new int[n];
		boolean[] safe = new boolean[n];
		for(int i = 0; i < graph.length; i++){
			boolean cyclic = dft(graph, i, visited);
			if(!cyclic){
				safe[i] = true;
			}
		}

		for(int i = 0; i < safe.length; i++){
			// visited not to be checked here, it improves performance for next vertices
			// when they reach a visited[nbr] = 1, they reach a confirmed cycle vertex.
			// when they reach a visited[nbr] = 2, they reach a confirmed non cycle vertex.
			if(safe[i]){
				System.out.println(i);
			}
		}
	}
	
	//  another way to solve 447
	private static boolean dft(int[][] graph, int v, int[] visited){
		visited[v] = 1;
		
		for(int nbr = 0; nbr < graph.length; nbr++){
			if(graph[v][nbr] != 0){
				if(visited[nbr] == 0){
					boolean cyclic = dft(graph, nbr, visited);
					if(cyclic){
						return true;
					}
				} else if(visited[nbr] == 1) {
					return true; // it is in the path above
				} else {
					// do nothing, visited[nbr] is 2, it is visited but not in the path above. 
				}
			}
		}
		
		visited[v] = 2;
		return false;
	}
}

//https://leetcode.com/problems/find-eventual-safe-states/solution/
//Test cases

//Test case 1
/*
7 7
0 1
0 2
1 2 
1 3
3 0 
2 5
4 5
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

