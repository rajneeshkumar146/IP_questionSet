package interview.greedy;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

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
			
			cost += rp.val * (rp.isH? vertCuts: horizCuts);
			if(rp.isH){
				horizCuts++;
			} else {
				vertCuts++;
			}
		}
		
		return cost;
	}

}
