
public class EqualSumSubsets {

	public static void main(String[] args) {

		
		int[] ar= {1,3,4,8,2,6};
		System.out.println(isKSubsetsOfEqualSumPossible(ar, 3));
		
		
	}

	public static boolean isKSubsetsOfEqualSumPossible(int[] a, int k) {

		if (k == 1) {
			return true;
		}
		if (k > a.length) {
			return false;
		}
		int sumofAllElements = 0;
		for (int i = 0; i < a.length; i++) {
			sumofAllElements += a[i];
		}

		if (sumofAllElements % k != 0) {
			return false;
		} else {
			int sumOfSubset = sumofAllElements / k;
			int[] sumSet = new int[k];
			boolean[] contain = new boolean[a.length];
			sumSet[0] = a[a.length - 1];
			contain[a.length - 1] = true;
			int sumSetIdx = 0;
			int containIdx = 0;
			return isKSubsetOfEqualSumPossible(a, sumSet, contain, sumOfSubset, sumSetIdx, containIdx, k,
					a.length - 1);
		}

	}

	private static boolean isKSubsetOfEqualSumPossible(int[] ar, int[] sumSet, boolean[] contain, int sumOfSubset,
			int sumSetIdx, int containIdx, int k, int lastIdx) {

		if (sumSet[sumSetIdx] == sumOfSubset) {

			if (sumSetIdx == k - 2) {
				return true;
			} else {
				return isKSubsetOfEqualSumPossible(ar, sumSet, contain, sumOfSubset, sumSetIdx + 1, containIdx, k,
						ar.length - 1);
			}

		}

		for (int i = lastIdx = ar.length - 1; i >= 0;i--) {

			if (contain[i] == true) {
				continue;
			} else {

				if (sumSet[sumSetIdx] + ar[i] <= sumOfSubset) {

					sumSet[sumSetIdx] += ar[i];
					contain[i] = true;
					boolean next = isKSubsetOfEqualSumPossible(ar, sumSet, contain, sumOfSubset, sumSetIdx, containIdx,
							k, lastIdx - 1);
					sumSet[sumSetIdx] -= ar[i];
					contain[i] = false;
					if (next) {
						return true;
					}

				}

			}

		}

		return false;
	}
}
