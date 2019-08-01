package pep_sns;

import java.awt.List;
import java.util.ArrayList;

public class online_election {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// CAN BE DONE ONLINE ONLY
		int[] persons = { 0, 1, 1, 0, 0, 1, 0 };
		int[] times = { 0, 5, 10, 15, 20, 25, 30 };
		TopVotedCandidate tp = new TopVotedCandidate(persons, times);
		System.out.println(tp.q(3));
		System.out.println(tp.q(12));
		System.out.println(tp.q(25));
		System.out.println(tp.q(15));
		System.out.println(tp.q(24));
		System.out.println(tp.q(8));
	}

	public static class TopVotedCandidate {

		ArrayList<Pair> list;

		public TopVotedCandidate(int[] persons, int[] times) {
			list = new ArrayList<>();

			int[] votes = new int[persons.length];
			for (int i = 0; i < persons.length; i++) {
				int cp = persons[i], ct = times[i];
				votes[persons[i]]++;

				if (list.size() > 0) {
					Pair last = list.get(list.size() - 1);
					if (votes[last.p] > votes[cp]) {
						cp = last.p;
					}
				}
				list.add(new Pair(cp, ct));
			}
		}

		public int q(int t) {
			int low = 1;
			int high = list.size();
			while (low < high) {
				int mid = low + (high - low) / 2;
				if (list.get(mid).t <= t) {
					low = mid + 1;
				} else {
					high = mid;
				}
			}
			return list.get(low - 1).p;
		}
	}

	public static class Pair {
		int p;
		int t;

		Pair(int p, int t) {
			this.p = p;
			this.t = t;
		}

	}

}
