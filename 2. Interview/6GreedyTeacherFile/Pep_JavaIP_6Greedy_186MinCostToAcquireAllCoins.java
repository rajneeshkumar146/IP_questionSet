package interview.greedy;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;


/*
*You are given a list of N coins of different denominations.
* you can pay an amount equivalent to any 1 coin and can acquire that coin.
*In addition, once you have paid for a coin, we can choose at most K more coins
*and can acquire those for free. The task is to find the minimum
*amount required to acquire all the N coins for a given value of K.
*/
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
/* Greedy choice we : pick the minimum coin , so we have to pay minimum cost
* for k acquisition after it.
*/
	public static int solve(int[] arr, int k){
		// array exhausts after we acquire, n/k+1 coins
		int coinsToAcquire = (int)Math.ceil(1.0 * arr.length / (k + 1));

		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int val: arr){
			pq.add(val);
		}

		int cost = 0;
		// pay for the minimum coin
		while(coinsToAcquire-- > 0){
			cost += pq.remove();
		}

		return cost;
	}
}
/*
Test cases:
*************************************************
test case 1
*************************************************

6 3
100 20 50 10 2 5
--------------------
7

*************************************************
test case 2
*************************************************
6 3
1 2 5 10 20 50
--------------
3

*************************************************
test case 3
*************************************************
8 3
8 5 3 10 2 1 15 25
--------------------
3
/*Source : https://www.geeksforgeeks.org/minimum-cost-for-acquiring-all-coins-with-k-extra-coins-allowed-with-every-coin/*/
