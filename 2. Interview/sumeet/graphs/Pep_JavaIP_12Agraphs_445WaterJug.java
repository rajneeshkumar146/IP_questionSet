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

public class Pep_JavaIP_12Agraphs_445WaterJug{
	public static void main(String[] args) throws Exception  {
		Scanner scn = new Scanner(System.in);
		
		int n = scn.nextInt();
		int m = scn.nextInt();
		int d = scn.nextInt();
		
		HashSet<Pair> visited = new HashSet<>(); 
		LinkedList<Pair> queue = new LinkedList<>();
		queue.addLast(new Pair(0, 0, 0, ""));
		
		while(queue.size() > 0){
			Pair rp = queue.removeFirst();
			
			if(visited.contains(rp)){
				continue;
			}
			visited.add(rp);
			
			if(rp.j1 == d || rp.j2 == d){
				System.out.println(rp.path);
				return;
			}
			
			// fill
			queue.add(new Pair(n, rp.j2, rp.count + 1, rp.path));
			queue.add(new Pair(rp.j1, m, rp.count + 1, rp.path));
			
			// empty
			queue.add(new Pair(0, rp.j2, rp.count + 1, rp.path));
			queue.add(new Pair(rp.j1, 0, rp.count + 1, rp.path));
			
			// move
			if(rp.j1 >= m - rp.j2){
				queue.add(new Pair(rp.j1 - (m - rp.j2), m , rp.count + 1, rp.path));
			} else {
				queue.add(new Pair(0, rp.j2 + rp.j1, rp.count + 1, rp.path));
			}
			
			if(rp.j2 >= n - rp.j1){
				queue.add(new Pair(n, rp.j2 - (n - rp.j1), rp.count + 1, rp.path));
			} else {
				queue.add(new Pair(rp.j2 + rp.j1, 0, rp.count + 1, rp.path));
			}
		}
		
	}
	
	static class Pair {
		int j1;
		int j2;
		int count = 0;
		String path = "";
		
		Pair(int j1, int j2, int count, String psf){
			this.j1 = j1;
			this.j2 = j2;
			this.count = count;
			this.path = (psf == ""? "" : psf + " -> ") + "[" + this.j1 + ", " + this.j2 + "]";
		}
		
		public int hashCode(){
			return this.j1 + this.j2 + this.count;
		}
		
		public boolean equals(Object other){
			Pair p = (Pair)other;
			
			return this.j1 == p.j1 && this.j2 == p.j2;
		}
	}
}

//https://www.geeksforgeeks.org/water-jug-problem-using-bfs/
//Test cases

//Test case 1
/*
4 3 2
[0, 0] -> [0, 3] -> [3, 0] -> [3, 3] -> [4, 2]
*/

// Test case 2
/*
6 5 2
[0, 0] -> [6, 0] -> [1, 5] -> [1, 0] -> [0, 1] -> [6, 1] -> [2, 5]
*/

