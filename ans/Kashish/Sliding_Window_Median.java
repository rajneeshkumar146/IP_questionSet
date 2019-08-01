package InternQuestAS1;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Sliding_Window_Median {
	public static double[] medianSlidingWindow(int[] nums, int k) {
		double[] ans = new double[nums.length - k + 1];
		PriorityQueue<Integer> right = new PriorityQueue<>();
		PriorityQueue<Integer> left = new PriorityQueue<>(Collections.reverseOrder());
		for (int i = 0; i < nums.length; i++) {
			if (left.size() - right.size() <= 0) {
				right.add(nums[i]);
				left.add(right.remove());

			} else {
				left.add(nums[i]);
				right.add(left.remove());
			}

			double median = 0;
			if (left.size() + right.size() == k) {
				if (left.size() == right.size()) {
					median = (double) ((long)left.peek() + (long)right.peek()) / 2;
				} else {
					median = (long)left.peek();
				}

				ans[i - k + 1] = median;
				if (!left.remove(nums[i - k + 1])) {
					right.remove(nums[i - k + 1]);
				}

			}
		}
		return ans;

	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn=new Scanner(System.in);
		

	}

}
