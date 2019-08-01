package may30;

import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

public class minimun_distinct_id {

	static class pair implements Comparable<pair> {
		public int element;
		public int frequency;

		public pair(int element, int frequency) {
			this.frequency = frequency;
			this.element = element;
		}

		@Override
		public int compareTo(pair o) {
			// TODO Auto-generated method stub
			return this.frequency - o.frequency;
		}

	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		int t = scn.nextInt();

		for (int tc = 0; tc < t; tc++) {
			int n = scn.nextInt();

			HashMap<Integer, Integer> map = new HashMap<>();
			PriorityQueue<pair> pq = new PriorityQueue<>();

			int len = 0;
			for (int i = 0; i < n; i++) {
				int val = scn.nextInt();
				map.put(val, map.getOrDefault(val, 0) + 1);
				len++;
			}

			int k = scn.nextInt();

			for (int key : map.keySet()) {
				pair p = new pair(key, map.get(key));
				pq.add(p);
			}

			int removed = 0;

			while (pq.size() >= 0) {
				if (pq.size() == 0) {
					System.out.println(0);
					break;
				}
				pair p = pq.poll();
				if (p.frequency > k) {
					System.out.println(pq.size() + 1);
					break;
				} else {
					k -= p.frequency;
				}
			}

		}
	}

}
