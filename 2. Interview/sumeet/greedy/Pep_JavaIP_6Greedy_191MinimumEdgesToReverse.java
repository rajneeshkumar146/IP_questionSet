package interview.greedy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

public class Pep_JavaIP_6Greedy_191MinimumEdgesToReverse {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();

		int[][] arr = new int[n][n];
		int edges = scn.nextInt();

		for (int i = 0; i < edges; i++) {
			int v1 = scn.nextInt();
			int v2 = scn.nextInt();
			arr[v1][v2] = 1;
		}

		int src = scn.nextInt();
		int dest = scn.nextInt();
		
		int ans = solve(arr, src, dest);
		System.out.println(ans);
	}

	private static int solve(int[][] arr, int src, int dest) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if (arr[i][j] == 1) {
					arr[j][i] = -1;
				}
			}
		}
		
		dft(arr, src, dest, new HashSet<>(), 0);
		return leastCount;
	}
	
	private static int leastCount = Integer.MAX_VALUE;
	private static void dft(int[][] arr, int src, int dest, HashSet<Integer> visited, int count){
		if(src == dest){
			// the route with least number of reversed edges
			if(count < leastCount){
				leastCount = count;
			}
			return;
		}
		
		visited.add(src);
		
		for(int nbr = 0; nbr < arr[src].length; nbr++){
			if(Math.abs(arr[src][nbr]) == 1 && visited.contains(nbr) == false){
				// count increases each times we travel over a reversed edge
				dft(arr, nbr, dest, visited, arr[src][nbr] == -1? count + 1: count);
			}
		}
		
		visited.remove(src);
	}

}
