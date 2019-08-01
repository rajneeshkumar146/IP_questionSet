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

public class Pep_JavaIP_12Agraphs_427CheapestFlight{
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
		int d = scn.nextInt();
		int k = scn.nextInt();
		
		int[] visited = new int[n + 1];
		dft(graph, s, d, visited, 0, 0, k);
		System.out.println(cheapest == Integer.MAX_VALUE? -1: cheapest);
	}
	
	static int cheapest = Integer.MAX_VALUE;
	private static void dft(int[][] graph, int s, int d, int[] visited, int cost, int stops, int k){
		if(s == d){
			if(cost < cheapest && stops <= k){
				cheapest = cost;
			}
			return;
		}
		
		visited[s] = 1;
		
		for(int nbr = 1; nbr < graph.length; nbr++){
			if(visited[nbr] == 0 && graph[s][nbr] != 0){
				dft(graph, nbr, d, visited, cost + graph[s][nbr], stops + 1, k);
			}
		}
		
		visited[s] = 0;
	}
}

//https://leetcode.com/problems/cheapest-flights-within-k-stops/description/
//Test cases

//Test case 1
/*
7 8
1 4 2
2 1 8
3 2 1 
3 4 6
4 5 8
5 6 3 
7 6 5
5 7 3
3 6
2
-1
*/

// Test case 2
/*
7 8
1 4 2
2 1 8
3 2 1 
3 4 6
4 5 8
5 6 3 
7 6 5
5 7 3
1 7
4
13
*/

