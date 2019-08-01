package interview.greedy;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

import javax.print.DocFlavor.CHAR_ARRAY;

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
