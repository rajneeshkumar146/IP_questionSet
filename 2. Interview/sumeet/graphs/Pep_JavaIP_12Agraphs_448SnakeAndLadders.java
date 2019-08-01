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

public class Pep_JavaIP_12Agraphs_448SnakeAndLadders{
	public static void main(String[] args) throws Exception  {
		Scanner scn = new Scanner(System.in);
		
		int n = scn.nextInt();
		int m = scn.nextInt();
		int[] graph = new int[n + 1];
		
		for(int i = 1; i <= m; i++){
			int x = scn.nextInt();
			int y = scn.nextInt();
			graph[x] = y;
		}
		
		HashSet<Pair> visited = new HashSet<>(); 
		LinkedList<Pair> queue = new LinkedList<>();
		queue.addLast(new Pair(1, ""));
		
		while(queue.size() > 0){
			Pair rp = queue.removeFirst();
			
			if(visited.contains(rp)){
				continue;
			}
			visited.add(rp);
			
			if(rp.cell == n){
				System.out.println(rp.path);
				return;
			}
			
			for(int dice = 1; dice <= 6; dice++){
				int ncell = rp.cell + dice;
				
				if(ncell <= n){
					ncell = graph[ncell] == 0? ncell: graph[ncell];
					queue.add(new Pair(ncell, rp.path));
				}
			}
		}
		
	}
	
	static class Pair {
		int cell;
		String path = "";
		
		Pair(int cell, String psf){
			this.cell = cell;
			this.path = (psf == ""? "" : psf + " -> ") + this.cell;
		}
		
		public int hashCode(){
			return this.cell;
		}
		
		public boolean equals(Object other){
			Pair p = (Pair)other;
			return this.cell == p.cell;
		}
	}
}

//https://www.geeksforgeeks.org/snake-ladder-problem-2/
//Test cases

//Test case 1
/*
20 2
3 13
5 11
1 -> 13 -> 14 -> 20
*/

// Test case 2
/*
30 5
7 17
29 3
27 4
11 19
25 12
1 -> 5 -> 19 -> 24 -> 30
*/

