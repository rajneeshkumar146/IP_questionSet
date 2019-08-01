package interview.dp;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Pep_JavaIP_7DP_193SuperUglyNumbers {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int[] primes = new int[scn.nextInt()];
		for(int i = 0; i < primes.length; i++){
			primes[i] = scn.nextInt();
		}
		int n = scn.nextInt();
		
		System.out.println(nthSuperUglyNumber(primes, n));
	}
	
	private static int nthSuperUglyNumber(int[] primes, int n){
		int[] ugly = new int[n];
		ugly[0] = 1;
		
		int[] multiples = new int[primes.length];
		// extension of the normal ugly sequence
		for(int i = 1; i < ugly.length; i++){
			int min = Integer.MAX_VALUE;
			for(int j = 0; j < primes.length; j++){
				if(ugly[multiples[j]] * primes[j] < min){
					min = ugly[multiples[j]] * primes[j];
				}
			}
			ugly[i] = min;
			
			for(int j = 0; j < primes.length; j++){
				if(min == ugly[multiples[j]] * primes[j]){
					multiples[j]++;
				}
			}
		}
		
		return ugly[ugly.length - 1];
	}


}

// https://www.geeksforgeeks.org/super-ugly-number-number-whose-prime-factors-given-set/
/* Test case 1 
3 
2 3 5
15
24
*/

/* Test case 2 
5
3 5 7 11 13
9
21
*/

/* Test case 3 
3
2 3 5
50
243
*/

