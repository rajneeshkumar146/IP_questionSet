package interview.greedy;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

import javax.print.DocFlavor.CHAR_ARRAY;
// Greedy choice : pop the stack which has maximum sum.
//find stack which has maximum sum, pop element from it
//till sum in stacks becomes equal

// Input is given as three stack arrays, a[0]--> top of stack
public class Pep_JavaIP_6Greedy_187MaxSumPossibleAcrossStacks {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int[] stack1 = new int[scn.nextInt()];
		for (int i = 0; i < stack1.length; i++) {
			stack1[i] = scn.nextInt();
		}

		int[] stack2 = new int[scn.nextInt()];
		for (int i = 0; i < stack2.length; i++) {
			stack2[i] = scn.nextInt();
		}

		int[] stack3 = new int[scn.nextInt()];
		for (int i = 0; i < stack3.length; i++) {
			stack3[i] = scn.nextInt();
		}

		int res = solve(stack1, stack2, stack3);
		System.out.println(res);
	}
// calculate sum of all three stacks. Pop in each iteration from the stack with
// max sum
	public static int solve(int[] stack1, int[] stack2, int[] stack3) {
		int sum1 = 0;
		for (int val : stack1) {
			sum1 += val;
		}

		int sum2 = 0;
		for (int val : stack2) {
			sum2 += val;
		}

		int sum3 = 0;
		for (int val : stack3) {
			sum3 += val;
		}

		int i = 0;
		int j = 0;
		int k = 0;
		// pop element from largest sum stack.
		while (i < stack1.length && j < stack2.length && k < stack3.length) {
			if (sum1 == sum2 && sum2 == sum3) {
				return sum1;
			} else if (sum1 >= sum2 && sum1 >= sum3) {
				sum1 -= stack1[i];
				i++;
			} else if (sum2 >= sum1 && sum2 >= sum3) {
				sum2 -= stack2[j];
				j++;
			} else if (sum3 >= sum2 && sum2 >= sum1) {
				sum3 -= stack3[k];
				k++;
			}
		}

		return 0;
	}
}
/*
Test cases:
*************************************************
test case 1
*************************************************
2
3 10

2
4 5

2
2 1 
-------------
0

*************************************************
test case 2
*************************************************
5
3 2 1 1 1 

3
4 3 2 

4
1 1 4 1 
--------------
5

*************************************************
test case 3
*************************************************
5
3 2 1 1 1 

3
4 3 2 

3
2 4 1 
------------------
5


/*https://www.geeksforgeeks.org/find-maximum-sum-possible-equal-sum-three-stacks/ */