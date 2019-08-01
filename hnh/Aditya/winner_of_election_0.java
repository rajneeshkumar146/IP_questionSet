package may27;

import java.util.HashMap;
import java.util.Scanner;

public class winner_of_election_0 {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();

		for (int tc = 0; tc < t; tc++) {
			HashMap<String, Integer> voteList = new HashMap<>();
			int n = scn.nextInt();
			for (int i = 0; i < n; i++) {
				String candidate = scn.next();
				if (voteList.containsKey(candidate)) {
					voteList.put(candidate, voteList.get(candidate) + 1);
				} else {
					voteList.put(candidate, 1);
				}

			}

			String winner = "";
			int maxvotes = 0;
			for (String candidate : voteList.keySet()) {
				if (voteList.get(candidate) > maxvotes) {
					winner = candidate;
					maxvotes = voteList.get(candidate);
				} else if (voteList.get(candidate) == maxvotes) {
					if (candidate.compareTo(winner) < 0) {
						winner = candidate;
					}
				}
			}
			
			System.out.println(winner+" "+maxvotes);

		}

	}

}
