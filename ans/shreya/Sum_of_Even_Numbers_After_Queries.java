package InternshipQuestionAs1;

public class Sum_of_Even_Numbers_After_Queries {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int v : sumEvenAfterQueries(new int[] { 1, 2, 3, 4 },
				new int[][] { { 1, 0 }, { -3, 1 }, { -4, 0 }, { 2, 3 } })) {
			System.out.print(v + " ");
		}
	}

	public static int[] sumEvenAfterQueries(int[] A, int[][] queries) {

		int esum = 0;
		for (int x : A)
			if (x % 2 == 0)
				esum += x;

		int[] ans = new int[queries.length];

		for (int i = 0; i < queries.length; ++i) {

			int val = queries[i][0];
			int index = queries[i][1];

			if (val % 2 == 0 && A[index] % 2 == 0) {
				esum += val;
			} else if (val % 2 == 0 && A[index] % 2 != 0) {

			} else if (val % 2 != 0 && A[index] % 2 == 0) {
				esum -= A[index];
			} else if (val % 2 != 0 && A[index] % 2 != 0) {
				esum += val + A[index];
			}
			A[index] += val;
			ans[i] = esum;
		}
		return ans;
	}
}
