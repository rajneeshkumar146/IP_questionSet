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

public class Pep_JavaIP_12Agraphs_439FriendsCircles{
	public static void main(String[] args) throws Exception  {
		Scanner scn = new Scanner(System.in);
		
		int n = scn.nextInt();
		int m = scn.nextInt();
		
		int[][] graph = new int[n + 1][n + 1];
		for(int i = 1; i <= m; i++){
			int x = scn.nextInt();
			int y = scn.nextInt();
			
			graph[x][y] = 1;
			graph[y][x] = 1;
		}
		
		int count = 0;
		int[] visited = new int[n + 1];
		for(int i = 1; i <= n; i++){
			if(visited[i] == 0){
				count++;
				traverse(graph, visited, i);
			}
		}
		
		System.out.println(count);
	}
	
	private static void traverse(int[][] graph, int[] visited, int v){
		visited[v] = 1;
		
		for(int nbr = 1; nbr < graph.length; nbr++){
			if(graph[v][nbr] == 1 && visited[nbr] == 0){
				traverse(graph, visited, nbr);
			}
		}
	}
	
}

//https://www.ideserve.co.in/learn/friend-circles-graph
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
1
*/

// Test case 2
/*
7 7
1 2
2 3
3 4
1 4 
5 6
6 7	
5 7
2
*/

//Test case 3
/*
7 5
1 2
3 4 
5 6
6 7	
5 7
3
*/
