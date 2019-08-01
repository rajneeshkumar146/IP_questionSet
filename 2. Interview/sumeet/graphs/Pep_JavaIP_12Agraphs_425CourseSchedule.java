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

public class Pep_JavaIP_12Agraphs_425CourseSchedule{
	public static void main(String[] args) throws Exception  {
		Scanner scn = new Scanner(System.in);
		
		int n = scn.nextInt();
		int m = scn.nextInt();
		
		int[][] edges = new int[m][2];
		for(int i = 0;i < m; i++){
			int x = scn.nextInt();
			int y = scn.nextInt();
			
			edges[i][0] = x;
			edges[i][1] = y;
		}
		
		int[] visited = new int[n];
		LinkedList<Integer> stack = new LinkedList<>();
		for(int v = 0; v < visited.length; v++){
			if(visited[v] == 0){
				dft(edges, v, visited, stack);
			}
		}
		
		LinkedList<Integer> rev = new LinkedList<>();
		while(stack.size() > 0){
			rev.addFirst(stack.removeFirst());
		}
		
		System.out.println(rev);
	}
	
	private static void dft(int[][] edges, int v, int[] visited, LinkedList<Integer> stack){
		visited[v] = 1;
		
		for(int i = 0; i < edges.length; i++){
			if(edges[i][0] == v){
				int nbr = edges[i][1];
				if(visited[nbr] == 0){
					dft(edges, nbr, visited, stack);
				}
			}
		}
		
		stack.addFirst(v);
	}
	
}

//https://leetcode.com/problems/course-schedule-ii/description/
//Test cases

//Test case 1
/*
4 
4
1 0 
2 0
3 1
3 2
[0, 1, 2, 3]
*/

// Test case 2
/*
6
6
0 1
1 2
2 3
2 5
1 5
4 5
[3, 5, 2, 1, 0, 4]
*/

