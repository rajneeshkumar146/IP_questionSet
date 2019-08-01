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

public class Pep_JavaIP_12Agraphs_452CountTrees{
	public static void main(String[] args) throws Exception  {
		Scanner scn = new Scanner(System.in);
		
		int n = scn.nextInt();
		int m = scn.nextInt();
		
		ArrayList<Integer>[] graph = new ArrayList[n];
		for(int i = 0; i < graph.length; i++){
			graph[i] = new ArrayList<>();
		}
		
		for(int i = 1; i <= m; i++){
			int u = scn.nextInt();
			int v = scn.nextInt();
			
			graph[u].add(v);
			graph[v].add(u);
		}
		
		HashSet<Integer> visited = new HashSet<>();
		int count = 0;
		for(int i = 0; i < n; i++){
			if(visited.contains(i) == false){
				count++;
				dft(i, graph, visited);
			}
		}
		
		System.out.println(count);
	}
	
	private static void dft(int v, ArrayList<Integer>[] graph, HashSet<Integer> visited){
		visited.add(v);
		for(int nbr : graph[v]){
			if(visited.contains(nbr) == false){
				dft(nbr, graph, visited);
			}
		}
	}
	
}

//https://www.geeksforgeeks.org/count-number-trees-forest/
//Test cases

//Test case 1
/*
5 3
0 1
0 2
3 4
2
*/

// Test case 2
/*
7 8
0 1
1 2 
2 3
0 3
3 4
4 5 
5 6
4 6
1
*/

