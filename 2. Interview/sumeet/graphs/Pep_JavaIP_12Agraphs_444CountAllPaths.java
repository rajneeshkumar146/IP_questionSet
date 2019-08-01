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

public class Pep_JavaIP_12Agraphs_444CountAllPaths{
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
		
		int[] visited = new int[n + 1];
		dft(graph, s, d, visited);
		System.out.println(count);
	}
	
	static int count = 0;
	
	private static void dft(int[][] graph, int s, int d, int[] visited){
		if(s == d){
			count++;
			return;
		}
		
		visited[s] = 1;
		
		for(int nbr = 1; nbr < graph.length; nbr++){
			if(visited[nbr] == 0 && graph[s][nbr] != 0){
				dft(graph, nbr, d, visited);
			}
		}
		
		visited[s] = 0;
	}
}

//https://www.geeksforgeeks.org/count-possible-paths-two-vertices/
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
4
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
1 7
0
*/

