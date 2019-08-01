package interview.greedy;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

import javax.print.DocFlavor.CHAR_ARRAY;

public class Pep_JavaIP_6Greedy_185MaxHeightPyramid {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int[] arr = new int[scn.nextInt()];
		for(int i = 0; i < arr.length; i++){
			arr[i] = scn.nextInt();
		}
		
		int res = solve(arr);
		System.out.println(res);
	}
	
	public static int solve(int[] arr){
		int res = 1;
		
		Arrays.sort(arr); // sorting to use smallest number first
		
		// building problem top-down
		
		int plc = 1; // previous level count
		int plv = arr[0]; // previous level value
		int clc = 0; // current level count
		int clv = 0; // current level value
		
		for(int i = 1; i < arr.length; i++){
			clc++;
			clv += arr[i];
			
			// if current level count and value has surpassed
			// previous level
			if(clc > plc && clv > plv){
				plc = clc;
				plv = clv;
				clc = 0;
				clv = 0;
				
				// level change
				res++;
			}
		}
		
		return res;
	}
}
