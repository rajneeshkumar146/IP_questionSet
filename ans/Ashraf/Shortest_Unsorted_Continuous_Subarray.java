package InternshipQuestionAs1;

import java.util.Arrays;

public class Shortest_Unsorted_Continuous_Subarray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int findUnsortedSubarray(int[] a) {
		int[] b = a.clone();
		Arrays.sort(b);

		int s = b.length, e = 0;

		for (int i = 0; i < b.length; i++) {
			if (b[i] != a[i]) {
				s = Math.min(s, i);
				e = Math.max(e, i);
			}
		}
		return (e - s >= 0 ? e - s + 1 : 0);
	}
}
