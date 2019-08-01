package interview.dp;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Pep_JavaIP_7DP_196MinJumps {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int[] arr = new int[scn.nextInt()];
		for(int i = 0; i < arr.length; i++){
			arr[i] = scn.nextInt();
		}
		
		System.out.println(minMoves(arr));
	}
	
	private static int minMoves(int[] arr){
		int[] moves = new int[arr.length];
		Arrays.fill(moves, Integer.MAX_VALUE);
		
		moves[moves.length - 1] = 0;
		for(int i = moves.length - 2; i >= 0; i--){
			for(int j = i + 1; j <= i + arr[i] && j < arr.length; j++){
				if(arr[j] != 0 && moves[j] + 1 < moves[i]){
					moves[i] = moves[j] + 1;
				}
			}
		}
		
		return moves[0];
	}

}

// https://www.geeksforgeeks.org/minimum-number-of-jumps-to-reach-end-of-a-given-array/
/* Test case 1 
11
1 3 5 8 9 2 6 7 6 8 9
3
*/

/* Test case 2 
5
3 5 7 11 13
2
*/

/* Test case 3 
10
1 3 0 4 0 0 2 1 1 1
5
*/

