package Stacks;

import java.util.Scanner;
import java.util.Stack;

public class Pep_JavaIP_8StacksNQueues_250CelebrityProblem {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int[][] arr = new int[scn.nextInt()][scn.nextInt()];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++)
				arr[i][j] = scn.nextInt();
		}

		System.out.println(celebrity(arr));

	}

	private static int celebrity(int[][] arr) {
		Stack<Integer> st = new Stack();
		for (int i = 0; i < arr.length; i++) {
			st.push(i);
		}

		while (st.size() > 1) {
			int val1 = st.pop();
			int val2 = st.pop();
			if (knows(arr, val1, val2)) {
				st.push(val2);
			} else {
				st.push(val1);
			}
		}

		int c = st.pop();
		for (int i = 0; i < arr.length; i++) {
			// If any person doesn't
			// know 'c' or 'a' doesn't
			// know any person, return -1
			if (i != c && (knows(arr, c, i) || !knows(arr, i, c)))
				return -1;
		}
		return c;
	}

	private static boolean knows(int[][] arr, int val1, int val2) {
		if (arr[val1][val2] == 1) {
			return true;
		}
		return false;
	}

}
