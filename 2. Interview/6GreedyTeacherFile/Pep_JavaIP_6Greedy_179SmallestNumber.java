package Greedy;

import java.util.Scanner;

public class Pep_JavaIP_6Greedy_179SmallestNumber {
//find the smallest number with given digit sum s and number of digits d
//Greedy: fill all digits from rightmost to leftmost (or from least significant
//digit to most significant.

/*initially deduct 1 from sum 's' so that we have smallest digit at the end.
*After deducting 1, we apply greedy approach.Compare remaining sum with 9,
* if remaining sum is more than 9,
*we put 9 at the current position, else we put the remaining sum.
*Since we fill digits from right to left, we put the highest digits on the right side.*/
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		//s is the sum of digits, m is the number of digits
		int s=scn.nextInt();
		int m=scn.nextInt();

		solve(s,m);
	}

	private static void solve(int s, int m) {
		if(s==0) {
			System.out.println(m==0? "0":"Not Possible");
			return;
		}
		if(s>9*m) {
			System.out.println("Not Possible");
			return;
		}

		int []res=new int[m];
		//try to put  1 at MSB
		s-=1;
		for(int i=m-1; i>0; i-- ) {
			if(s>9) {
				res[i]=9;
				s-=9;
			}else {
				res[i]=s;
				// when zeroes can be inserted
				s=0;
			}
		}
		// if sum is left , add to 1.
		//as we kept 1 for the MSB
		res[0]=s+1;

		for(int val:res) {
			System.out.print(val);
		}
	}

}


/*Test Cases:
20
3
-----------------
299


27
6
----------------
100899

28
3
--------------------
Not Possible

26
4
----------------
1799

https://www.geeksforgeeks.org/find-smallest-number-with-given-number-of-digits-and-digit-sum/

*/
