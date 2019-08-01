package june2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class skyline_problem {

	public List<List<Integer>> getSkyline(int[][] buildings) {

		ArrayList<int[]> CriticalPoints = new ArrayList<>();

		for (int i = 0; i < buildings.length; i++) {
			CriticalPoints.add(new int[] { buildings[i][0], -buildings[i][2] });
			CriticalPoints.add(new int[] { buildings[i][1], buildings[i][2] });
		}

		Collections.sort(CriticalPoints, (a, b) -> {
			if (a[0] != b[0])
				return a[0] - b[0];
			return a[1] - b[1];
		}); // sorting critical pts based on their x coordinates,if same then
			// then the pt with lower height wins

		// for a[0]==b[0]
		// if both are start then the one with larger negative value will come
		// first
		// if both are ends then the one with smaller positive value will come
		// first
		// else if one start and one end,start will always coe first

		List<List<Integer>> result = new ArrayList<>();
		PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));
		pq.offer(0);
		int prev = 0;
		for (int[] h : CriticalPoints) {
			if (h[1] < 0) { // start,add
				pq.offer(-h[1]);
			} else { // end ,pop
				pq.remove(h[1]);
			}
			int cur = pq.peek();
			if (prev != cur) {
				List<Integer> smallRes = new ArrayList<>();
				smallRes.add(h[0]);
				smallRes.add(cur);
				result.add(smallRes);
				prev = cur;
			}
		}

		return result;

	}
}
