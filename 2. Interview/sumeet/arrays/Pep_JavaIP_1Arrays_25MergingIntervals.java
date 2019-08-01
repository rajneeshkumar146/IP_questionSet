package interview.arrays;

import java.util.*;

public class Pep_JavaIP_1Arrays_25MergingIntervals {

	private static class Pair implements Comparable<Pair> {
		int start = 0;
		int end = 0;
		
		@Override
		public int compareTo(Pair o) {
			return this.start - o.start;
		}
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		Pair[] pairs = new Pair[scn.nextInt()];
		
		for(int i = 0; i < pairs.length; i++){
			pairs[i] = new Pair();
			pairs[i].start = scn.nextInt();
			pairs[i].end = scn.nextInt();
		}
		
		solve(pairs);
	}

	private static void solve(Pair[] pairs) {
		Arrays.sort(pairs);
		
		ArrayList<Pair> stack = new ArrayList<>();
		stack.add(pairs[0]);
		
		for(int i = 1; i < pairs.length; i++){
			Pair tos = stack.get(stack.size() - 1);
			Pair curr = pairs[i];
			
			if(curr.start >= tos.start && curr.start <= tos.end){
				tos.end = curr.end > tos.end? curr.end: tos.end;
			} else {
				stack.add(curr);
			}
		}
		
		for(Pair pair: stack){
			System.out.println(pair.start + " " + pair.end);
		}
	}

}
