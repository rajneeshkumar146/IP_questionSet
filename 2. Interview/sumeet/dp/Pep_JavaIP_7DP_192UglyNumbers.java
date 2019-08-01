package interview.dp;

import java.util.Scanner;

public class Pep_JavaIP_7DP_192UglyNumbers {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		System.out.println(nthUglyNumber(n));
	}
	
	private static int nthUglyNumber(int n){
		int[] ugly = new int[n];
		ugly[0] = 1;
		
		int twoidx = 0;
		int threeidx = 0;
		int fiveidx = 0;
		// a 2's multiple sequence of old ugly numbers
		// and a 3's multiple sequence of old ugly numbers
		// and a 5's multiple sequence of old ugly numbers
		// contribute to next ugly number
		for(int i = 1; i < ugly.length; i++){
			ugly[i] = Math.min(ugly[twoidx] * 2, Math.min(ugly[threeidx] * 3, ugly[fiveidx] * 5));
			
			if(ugly[i] == ugly[twoidx] * 2){
				twoidx++;
			}
			if(ugly[i] == ugly[threeidx] * 3){
				threeidx++;
			}
			if(ugly[i] == ugly[fiveidx] * 5){
				fiveidx++;
			}
		}
		
		return ugly[ugly.length - 1];
	}


}

// Link https://www.geeksforgeeks.org/ugly-numbers/
/* Test case 1 
10
12
*/

/* Test case 2 
1
1
*/

/* Test case 3 
15
24
*/

