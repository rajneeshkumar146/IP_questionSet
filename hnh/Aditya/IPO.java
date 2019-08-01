package june1;

import java.util.PriorityQueue;

public class IPO {

	public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {

		PriorityQueue<Integer[]> pq = new PriorityQueue<>((a, b) -> (a[0] - b[0])); // variation
																					// of
																					// compareto

		PriorityQueue<Integer[]> pq2 = new PriorityQueue<>((a, b) -> (b[1] - a[1])); // variation
																						// of
																						// compareto

		for (int i = 0; i < Profits.length; i++) {
			pq.add(new Integer[] { Capital[i], Profits[i] }); // [0] is capital
																// [1] isprofit
		}

		for (int i = 0; i < k; i++) {
			while (pq.size() > 0 && pq.peek()[0] <= W) { // adding do-able
															// projects to
															// priority queue
				pq2.add(pq.poll());
			}

			if (pq2.size() == 0) { // no projects left
				break;
			}

			W += pq2.poll()[1];

		}

		return W;
	}
}

// PriorityQueue<int[]> pqCap = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
// PriorityQueue<int[]> pqPro = new PriorityQueue<>((a, b) -> (b[1] - a[1]));
//
// for (int i = 0; i < Profits.length; i++) {
// pqCap.add(new int[] {Capital[i], Profits[i]});
// }
//
// for (int i = 0; i < k; i++) {
// while (!pqCap.isEmpty() && pqCap.peek()[0] <= W) {
// pqPro.add(pqCap.poll());
// }
//
// if (pqPro.isEmpty()) break;
//
// W += pqPro.poll()[1];
// }
//
// return W;
