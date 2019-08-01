package may29;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class next_smaller_on_left {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		int t = 1;

		for (int tc = 0; tc < t; tc++) {
			int n = 15;

			ArrayList<Integer> seq = new ArrayList<>();

			for (int i = 0; i < n; i++) {
				seq.add(scn.nextInt());
			}

			nseL_index(seq);

		}
	}

	static void nseL_index(ArrayList<Integer> seq) {
		int[] ans=new int[seq.size()];

		LinkedList<Integer> st = new LinkedList<>();

		for (int i = seq.size() - 1; i >= 0; i--) {

			while (st.size() != 0 && seq.get(i) < seq.get(st.getFirst())) {
				int poped = st.getFirst();
				st.removeFirst();

				ans[poped]=i;
			}

			st.addFirst(i);
		}

		while (st.size() != 0) {
			int poped = st.getFirst();
			st.removeFirst();

			ans[poped]=-1;
		}

		ans[0]=-1;

		for (int i = 0; i < seq.size(); i++) {
			System.out.print(ans[i]);
		}
		System.out.println();
	}

}
