package InternshipQuestionAs1;

import java.util.Arrays;

public class Squares_of_a_Sorted_Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int ans[] = sortedSquares(new int[] { -4, -1, 0, 3, 10 });
		for (int i : ans)
			System.out.print(i + " ");
	}

	public static int[] sortedSquares(int[] A) {
		int n = A.length;

		int j = 0;

		while (j < n && A[j] < 0)
			j++;

		int i = j - 1;
		int t = 0;

		int ans[] = new int[n];

		while (i >= 0 && j < n) {
			if (A[i] * A[i] < A[j] * A[j]) {
				ans[t++] = A[i] * A[i];
				i--;
			} else {
				ans[t++] = A[j] * A[j];
				j++;
			}
		}

		while (i >= 0) {
			ans[t++] = A[i] * A[i];
			i--;
		}

		while (j < n) {
			ans[t++] = A[j] * A[j];
			j++;
		}

		return ans;
	}

	public static int[] sortedSquares1(int[] A) {
		int n = A.length;
		int ans[] = new int[n];

		for (int i = 0; i < n; i++) {
			ans[i] = A[i] * A[i];
		}
		Arrays.sort(ans);
		return ans;

	}
}
