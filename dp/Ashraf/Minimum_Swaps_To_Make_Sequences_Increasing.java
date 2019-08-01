package InternQuestionDP;

public class Minimum_Swaps_To_Make_Sequences_Increasing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int minSwap(int[] A, int[] B) {
		int n = A.length;
		int[] ns = new int[n];
		int[] s = new int[n];

		ns[0] = 0;
		s[0] = 1;

		for (int i = 1; i < n; i++) {
			ns[i] = n;
			s[i] = n;

			if (A[i - 1] < A[i] && B[i - 1] < B[i]) {
				ns[i] = ns[i - 1];
				s[i] = ns[i - 1] + 1;
			}

			if (A[i - 1] < B[i] && B[i - 1] < A[i]) {
				ns[i] = Math.min(ns[i], s[i - 1]);
				s[i] = ns[i - 1] + 1;
			}
		}
		return Math.min(ns[n - 1], s[n - 1]);
	}
}
