package interview.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Pep_JavaIP_7DP_238MCP3d {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int x = scn.nextInt();
		int y = scn.nextInt();
		int z = scn.nextInt();
		int[][][] arr = new int[x][y][z];
		for(int i = 0; i < arr.length; i++){
			for(int j = 0; j < arr[i].length; j++){
				for(int k = 0; k < arr[i][j].length; k++){
					arr[i][j][k] = scn.nextInt();
				}
			}
		}
		
		System.out.println(solve(arr));
	}
	
	private static int solve(int[][][] arr){
		int[][][] strg = new int[arr.length][arr[0].length][arr[0][0].length];
		
		for(int i = strg.length - 1; i >= 0; i--){
			for(int j = strg[0].length - 1; j >= 0; j--){
				for(int k = strg[0][0].length - 1; k >= 0; k--){
					Integer min = null;
					if(i < strg.length - 1){
						min = min == null? strg[i + 1][j][k]: Math.min(min, strg[i + 1][j][k]);
					}
					
					if(j < strg[0].length - 1){
						min = min == null? strg[i][j + 1][k]: Math.min(min, strg[i][j + 1][k]);
					}
					
					if(k < strg[0][0].length - 1){
						min = min == null? strg[i][j][k + 1]: Math.min(min, strg[i][j][k + 1]);
					}
					
					strg[i][j][k] = arr[i][j][k] + (min == null? 0: min);
				}
			}
		}
		
		return strg[0][0][0];
	}

}

// https://www.geeksforgeeks.org/minimum-sum-path-3-d-array/
/* Test case 1 
2 2 2
1 2 3 4
4 8 5 2
9
*/

/* Test case 2 
2 2 2
1 2 4 3
3 4 2 1
7
*/

/* Test case 3 
3 3 3
1 2 4 3 4 5 5 2 1
4 8 3 5 2 1 3 4 2
2 4 1 3 1 4 6 3 8
20
*/