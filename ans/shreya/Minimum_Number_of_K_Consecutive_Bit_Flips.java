package InternshipQuestionAs1;

public class Minimum_Number_of_K_Consecutive_Bit_Flips {

	public static void main(String[] args) {

		System.out.println(minKBitFlips(new int[] { 1, 0, 1, 0 }, 2));
	
	}

	public static int minKBitFlips(int[] A, int K) {

		int ans = 0;
		for (int i = 0; i <= A.length - K; i++) {
			if (A[i] == 1)
				continue;
			ans++;
			for (int j = 0; j < K; j++) {
				A[i + j] ^= 1;
			}
		}
		for (int i = A.length - K + 1; i < A.length; i++)
			if (A[i] == 0)
				return -1;
		return ans;
	}
}