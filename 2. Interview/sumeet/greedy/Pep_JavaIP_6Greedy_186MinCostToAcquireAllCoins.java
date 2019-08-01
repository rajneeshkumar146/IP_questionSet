package interview.greedy;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

import javax.print.DocFlavor.CHAR_ARRAY;

public class Pep_JavaIP_6Greedy_186MinCostToAcquireAllCoins {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int[] arr = new int[scn.nextInt()];
		for(int i = 0; i < arr.length; i++){
			arr[i] = scn.nextInt();
		}
		int k = scn.nextInt();
		
		int res = solve(arr, k);
		System.out.println(res);
	}
	
	public static int solve(int[] arr, int k){
		int coinsToAcquire = (int)Math.ceil(1.0 * arr.length / (k + 1));
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int val: arr){
			pq.add(val);
		}
		
		int cost = 0;
		while(coinsToAcquire-- > 0){
			cost += pq.remove();
		}
		
		return cost;
	}
}
