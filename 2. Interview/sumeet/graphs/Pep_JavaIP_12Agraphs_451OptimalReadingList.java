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

public class Pep_JavaIP_12Agraphs_451OptimalReadingList{
	public static void main(String[] args) throws Exception  {
		Scanner scn = new Scanner(System.in);

		int[] pages = new int[scn.nextInt() + 1];
		int avg = 0;
		for(int i = 1; i < pages.length; i++){
			pages[i] = scn.nextInt();
			avg += pages[i];
		}
		
		int k = scn.nextInt();
		avg = avg / k;
		
		HashMap<Integer, HashMap<Integer, Integer>> graph = new HashMap<>();
		for(int i = 1; i <= pages.length ; i++){
			graph.put(i, new HashMap<>());
		}
		
		for(int i = 1; i < pages.length; i++){
			int sum = pages[i];
			for(int j = i + 1; j < pages.length; j++){
				graph.get(i).put(j, Math.abs(avg - sum));
				sum += pages[j];
			}
			graph.get(i).put(pages.length, Math.abs(avg - sum));
		}
		
		dfs(graph, 1, pages.length, new int[pages.length + 1], 0, "1", 0, k);
		System.out.println(pageSP);
	}
	
	static int sp = Integer.MAX_VALUE;
	static String pageSP = "";
	private static void dfs(HashMap<Integer, HashMap<Integer, Integer>> graph, int s, int d, int[] visited, int dist, String psf, int count, int k){
		if(s == d){
			if(dist < sp && count == k){
				sp = dist;
				pageSP = psf;
			}
			return;
		}
		
		visited[s] = 1;
		for(int nbr: graph.get(s).keySet()){
			if(visited[nbr] == 0){
				dfs(graph, nbr, d, visited, dist + graph.get(s).get(nbr), psf + (nbr != d? " " + nbr: ""), count + 1, k);
			}
		}
		visited[s] = 0;
	}
	
	
}

//https://www.geeksforgeeks.org/optimal-read-list-given-number-days/
//Test cases

//Test case 1
/*
4
8 5 6 12
3
1 2 4
*/

// Test case 2
/*
7
10 15 3 18 9 21 5
4
1 3 5 6
*/

