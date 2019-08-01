package interview.dp;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

// Why not clear by math approach, clear by bfs
public class Pep_JavaIP_7DP_220WaterJug {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int a = scn.nextInt();
		int b = scn.nextInt();
		int d = scn.nextInt();
		
		System.out.println(solve(a, b, d));
	}
	
	// ax + by = d -> diophantine equation can be solved if d is multiple of gcd
	// ax + by = gcd can be solved using extended euclid
	private static int solve(int a, int b, int d){
		int g = gcd(a, b);
		
		if(d % g != 0){// if d is not a multiple of gcd it can't be solved
			return -1;
		} else if(d > Math.max(a, b)){ // if d is greater than the size of greater mug
			return -1;
		} else {
			// either pour from a to b
			// or from b to a
			// sometimes from a to b and other times from b to a does not make sense.
			return Math.min(pour(a, b, d), pour(b, a, d));
		}
	}
	
	// pour from "from" into "to", till one of them is d
	// pour as much as you can, if from is empty fill it, if t is full empty it.
	private static int pour(int from, int to, int d){
		int step = 1;
		int f = from;
		int t = 0;
		
		while(true){
			int space = to - t;
			int available = f;
			int move = Math.min(space, available);
			
			t += move;
			f -= move;
			step++;
			
			if(f == d || t == d){
				break;
			}
			
			if(f == 0){
				f = from;
				step++;
			}
			
			if(t == to){
				t = 0;
				step++;
			}
		}
		
		return step;
	}
	
	public static int gcd(int a, int b){
		if(a % b == 0){
			return b;
		}
		return gcd(b, a % b);
	}
}

// https://www.geeksforgeeks.org/two-water-jug-puzzle/
/* Test case 1 
3 5 4
6
*/

/* Test case 2 
26 24 3
-1
*/

/* Test case 2 
3 5 6
-1
*/