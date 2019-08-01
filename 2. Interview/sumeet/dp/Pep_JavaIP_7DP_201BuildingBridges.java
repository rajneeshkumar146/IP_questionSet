package interview.dp;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Pep_JavaIP_7DP_201BuildingBridges {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] north = new int[n];
		int[] south = new int[n];
		for(int i = 0; i < n; i++){
			north[i] = scn.nextInt();
			south[i] = scn.nextInt();
		}
		
		System.out.println(solve(north, south));
	}
	
	private static class Pair implements Comparable<Pair>{
		int x;
		int y;
		
		Pair(int x, int y){
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Pair o) {
			if(this.y == o.y){
				return this.x - o.x;
			} else {
				return this.y - o.y;
			}
		}
	}
	
	// What? - Sort on south coords, calculate lis on north coords
	// How? - Check code
	// Why? - The set of pairs, such that if a.x <= b.x then a.y <= b.y is required.
	// Sorting on y makes sure we have pairs with smaller y in beginning
	// LIS on x makes sure, its the largest such set where is x is smaller, so is y.
	// More Why? - At a particular spot we are storing maximum number of non-overlapping bridges 
	// to the left of it i.e. j's x and y must be smaller to i's x and y. 
	// In the original array, there may be such elements lying to right of i, we sort on y
	// to bring them to left of i and to allow the valids (x also less) among them to have
	// a chance to be considered for this i. It's not LIS, it is reducible to LIS once we 
	// sort on y. The longest sequence of bridges ending at "i" with non-overlapping bridges
	// to its left. Compare all such "i's" to have the answer.
	private static int solve(int[] north, int[] south){
		Pair[] pairs = new Pair[north.length];
		for(int i = 0; i < north.length; i++){
			pairs[i] = new Pair(north[i], south[i]);
		}
		
		Arrays.sort(pairs);
		
		int[] lis = new int[pairs.length];
		
		lis[0] = 1;
		for(int i = 1; i < pairs.length; i++){
			for(int j = 0; j < i; j++){
				if(pairs[j].x < pairs[i].x){
					if(lis[j] > lis[i]){
						lis[i] = lis[j];
					}
				}
			}
			
			lis[i]++;
		}
		
		int len = 0;
		
		for(int i = 0; i < lis.length; i++){
			if(lis[i] > len){
				len = lis[i];
			}
		}
		
		return len;
	}
	
}

// https://www.geeksforgeeks.org/dynamic-programming-building-bridges/
/* Test case 1 
4
6 2
4 3
2 6
1 5
2
*/

/* Test case 2 
8
8 1
1 2
4 3
3 4
5 5
2 6
6 7
7 8
5
*/