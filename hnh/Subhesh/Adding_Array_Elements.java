package HnH;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Adding_Array_Elements {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int tc = s.nextInt();
		for (int i = 0; i < tc; i++) {
			int c = s.nextInt();
			int K = s.nextInt();
			int[] arr = new int[c];
			for (int j = 0; j < c; j++) {
				arr[j] = s.nextInt();
			}

			System.out.println(miniSteps(arr, K));
		}
	}

	private static int miniSteps(int[] arr, int K) {
		// sort
		Arrays.sort(arr);
		// find the ones less than K
		int idx;
		int sum = 0;
		for (idx = 0; idx < arr.length; idx++) {
			if (arr[idx] >= K) {
				idx--;
				break;
			}
			sum += arr[idx];
		}
		if (idx == arr.length) {
			idx--;
		}
		// impossible?
		if (idx == arr.length - 1 && sum < K) {
			return -1;
		}
		// now greedy
		int steps = 0;
		int skippedSum = 0;
		int i, j;
		for (i = 0, j = idx; i < j;) {
			int s = arr[j] + arr[i];
			if (s < K) {
				skippedSum += arr[i];
				i++;
			} else {
				i++;
				j--;
				steps++;
			}
		}
		if (i == j) {
			skippedSum += arr[i];
		}
		int remainCnt = idx + 1 - steps * 2;
		if (remainCnt > 0) {
			if (skippedSum >= K) {
				steps += remainCnt - 1;
			} else {
				steps += remainCnt;
			}
		}
		return steps;
	}
}
