package InternQuestionDP;

import java.util.Scanner;

public class Maximum_Sum_Bitonic_Subsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		while (t-- > 0) {
			int n = scn.nextInt();
			int a[] = new int[n];
			for (int i = 0; i < n; i++) {
				a[i] = scn.nextInt();
			}

			int mxsmIncBss[] = new int[n];
			int mxsmDecBss[] = new int[n];

			for (int i = 0; i < n; i++) {
				mxsmIncBss[i] = a[i];
				mxsmDecBss[i] = a[i];
			}
			for (int i = 1; i < n; i++) {
				for (int j = 0; j < i; j++) {
					if (a[i] > a[j] && mxsmIncBss[i] < mxsmIncBss[j] + a[i]) {
						mxsmIncBss[i] = mxsmIncBss[j] + a[i];
					}
				}
			}
			for (int i = n - 2; i >= 0; i--) {
				for (int j = n - 1; j > i; j--) {
					if (a[i] > a[j] && mxsmDecBss[i] < mxsmDecBss[j] + a[i]) {
						mxsmDecBss[i] = mxsmDecBss[j] + a[i];
					}
				}
			}

			int fmxsm = Integer.MIN_VALUE;
			for (int i = 0; i < n; i++) {
				fmxsm = Math.max(fmxsm, mxsmIncBss[i] + mxsmDecBss[i] - a[i]);
			}
			System.out.println(fmxsm);
		}
	}

}
