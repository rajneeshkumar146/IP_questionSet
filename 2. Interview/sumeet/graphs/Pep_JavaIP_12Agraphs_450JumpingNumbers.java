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

public class Pep_JavaIP_12Agraphs_450JumpingNumbers{
	public static void main(String[] args) throws Exception  {
		Scanner scn = new Scanner(System.in);
		
		int n = scn.nextInt();
		
		HashSet<Pair> visited = new HashSet<>(); 
		LinkedList<Pair> queue = new LinkedList<>();
		
		System.out.print(0 + " ");
		for(int i = 1; i <= 9; i++){
			queue.addLast(new Pair(i));
		}
		
		while(queue.size() > 0){
			Pair rp = queue.removeFirst();
			
			if(rp.cell >= n){
				break;
			}
			
			System.out.print(rp.cell + " ");
			if(visited.contains(rp)){
				continue;
			}
			visited.add(rp);
			
			int quo = rp.cell / 10;
			int rem = rp.cell % 10;
			
			if(rem >= 1){
				queue.add(new Pair(10 * rp.cell + rem - 1));
			}
			
			if(rem < 9){
				queue.add(new Pair(10 * rp.cell + rem + 1));
			}
		}
		
		System.out.println(".");
	}
	
	static class Pair {
		int cell;
		
		Pair(int cell){
			this.cell = cell;
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

//https://www.geeksforgeeks.org/print-all-jumping-numbers-smaller-than-or-equal-to-a-given-value/
//Test cases

//Test case 1
/*
200
0 1 2 3 4 5 6 7 8 9 10 12 21 23 32 34 43 45 54 56 65 67 76 78 87 89 98 101 121 123 .
*/

// Test case 2
/*
300
0 1 2 3 4 5 6 7 8 9 10 12 21 23 32 34 43 45 54 56 65 67 76 78 87 89 98 101 121 123 210 212 232 234 .
*/

