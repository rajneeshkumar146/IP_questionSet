package may31;

import java.util.PriorityQueue;

public class kth_smallest_prime_fraction {
	static class fraction implements Comparable<fraction> {
		double val;
		int numind;
		int denind;

		public fraction(double val, int num, int den) {
			this.val = val;
			this.numind = num;
			this.denind = den;
		}

		@Override
		public int compareTo(fraction o) {
			// TODO Auto-generated method stub
			if (this.val < o.val) {
				return -1;
			}
			return 1;
		}

	}

	public int[] kthSmallestPrimeFraction(int[] A, int K) {
		int maxdenindex = A.length - 1;
		PriorityQueue<fraction> pq = new PriorityQueue<>();

		for (int i = 0; i < A.length; i++) {
			fraction f = new fraction(((A[i] * 1.0) / A[maxdenindex]), i, maxdenindex);
			pq.add(f);
		}

		for (int i = 1; i < K; i++) {
			fraction f = pq.poll();
			f.denind--;

			pq.add(new fraction((A[f.numind] * 1.0) / A[f.denind], f.numind, f.denind));
		}
		fraction f = pq.poll();
		
		int[] ans={A[f.numind],A[f.denind]};
		return ans;
	}
}
