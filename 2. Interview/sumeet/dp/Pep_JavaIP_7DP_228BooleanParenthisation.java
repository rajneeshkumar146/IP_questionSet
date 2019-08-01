package interview.dp;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Pep_JavaIP_7DP_228BooleanParenthisation {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String operands = scn.nextLine();
		String operators = scn.nextLine();
		
		System.out.println(solve(operands, operators));
	}
	
	private static int solve(String operands, String operators){
		int[][] t = new int[operands.length()][operands.length()];
		int[][] f = new int[operands.length()][operands.length()];
		
		for(int i = 0; i < operands.length(); i++){
			t[i][i] = operands.charAt(i) == 'T'? 1: 0;
			f[i][i] = Math.abs(t[i][i] - 1);
		}
		
		for(int gap = 1; gap < operands.length(); gap++){
			for(int i = 0, j = i + gap; j < operands.length(); i++, j++){
				for(int k = i; k < j; k++){
					int tik = t[i][k] + f[i][k];
					int tkp1j = t[k + 1][j] + f[k + 1][j];
					
					char operator = operators.charAt(k);
					if(operator == '|'){
						t[i][j] += tik * tkp1j - f[i][k] * f[k + 1][j];
						f[i][j] += f[i][k] * f[k + 1][j];
					} else if(operator == '&'){
						t[i][j] += t[i][k] * t[k + 1][j];
						f[i][j] += tik * tkp1j - t[i][k] * t[k + 1][j];
					} else if(operator == '^'){
						t[i][j] += t[i][k] * f[k + 1][j] + f[i][k] * t[k + 1][j];
						f[i][j] += t[i][k] * t[k + 1][j] + f[i][k] * f[k + 1][j];
					}
				}
			}
		}
		
		return t[0][t.length - 1];
	}
}

// https://www.geeksforgeeks.org/dynamic-programming-set-37-boolean-parenthesization-problem/
/* Test case 1 
TTFT
|&^
4
*/

/* Test case 2 
TFF
^|
2
*/
