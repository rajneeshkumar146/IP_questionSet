package interview.greedy;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;
/*
Total_cost = Total_cost + edge_cost * total_pieces 
Greedy : If total cost is denoted by S, then S = a1w1 + a2w2 … + akwk, 
where wi is a cost of certain edge cutting and ai is corresponding coefficient,
The coefficient ai is determined by the total number of cuts we have competed 
using edge wi at the end of the cutting process. Notice that sum of the 
coefficients are always constant,hence we want to find a distribution of ai 
obtainable such that S is minimum. To do so we perform cuts on highest cost edge
as early as possible, which will reach to optimal S. 
If we encounter several edges having the same cost, we can cut any one of them first.

Horizontal array[]
Vertical array[]
*/

public class Pep_JavaIP_6Greedy_189MinCostToCutSquares {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int[] horiz = new int[scn.nextInt()];
		for (int i = 0; i < horiz.length; i++) {
			horiz[i] = scn.nextInt();
		}
		
		int[] vert = new int[scn.nextInt()];
		for (int i = 0; i < vert.length; i++) {
			vert[i] = scn.nextInt();
		}

		int res = solve(horiz, vert);
		System.out.println(res);
	}

	private static class Pair implements Comparable<Pair> {
		int val;
		boolean isH = false;
		
		Pair(int val, boolean isH){
			this.val = val;
			this.isH = isH;
		}

		@Override
		public int compareTo(Pair o) {
			return this.val - o.val;
		}
	}
	
	
	public static int solve(int[] horiz, int[] vert) {
		PriorityQueue<Pair> pq = new PriorityQueue<>(Collections.reverseOrder());
		for(int val: horiz){
			pq.add(new Pair(val, true));
		}
		for(int val: vert){
			pq.add(new Pair(val, false));
		}
		
		int cost = 0;
		int vertCuts = 1;
		int horizCuts = 1;
		
		while(pq.size() > 0){
			Pair rp = pq.remove();
			// cut along maximum direction
			cost += rp.val * (rp.isH? vertCuts: horizCuts);
			if(rp.isH){
				// if horizontally cut , then horinztal pieces are increased
				horizCuts++;
			} else {
				// if horizontally cut , then horinztal pieces are increased
				vertCuts++;
			}
		}
		
		return cost;
	}

}
/*
Test cases:

*************************************************
test case 1
*************************************************
3
4 1 2

4
2 1 3 1 4
-----------------
42

*************************************************
test case 2
*************************************************
5
5 1 2 3 4

4
9 1 3 2
--------------
71

*************************************************
test case 3
*************************************************
6
3 4 7 8 1 2

4
1 2 3 4
------------------
85
/*Source : https://www.geeksforgeeks.org/minimum-cost-cut-board-squares/ */