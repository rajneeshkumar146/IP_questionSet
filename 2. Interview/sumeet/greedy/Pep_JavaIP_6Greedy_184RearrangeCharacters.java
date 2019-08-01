package interview.greedy;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

import javax.print.DocFlavor.CHAR_ARRAY;

public class Pep_JavaIP_6Greedy_184RearrangeCharacters {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.nextLine();

		str = solve(str);
		System.out.println(str);
	}

	private static class Pair implements Comparable<Pair> {
		Character ch;
		int freq;

		Pair(Character ch, int freq) {
			this.ch = ch;
			this.freq = freq;
		}

		@Override
		public int compareTo(Pair o) {
			if (this.freq != o.freq) {
				return this.freq - o.freq;
			} else {
				return o.ch - this.ch;
			}
		}
	}

	public static String solve(String str) {
		String res = "";

		// create a freq map
		HashMap<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			map.put(ch, map.containsKey(ch) == false ? 1 : map.get(ch) + 1);
		}

		// create a pq with pairs for each character
		PriorityQueue<Pair> pq = new PriorityQueue<>(Collections.reverseOrder());
		for (Character key : map.keySet()) {
			pq.add(new Pair(key, map.get(key)));
		}

		// last item that was removed
		Pair prev = null;
		while (pq.size() > 0) {
			// curr item that is being removed
			Pair curr = pq.remove();

			// use a char and reduce freq
			res += curr.ch;
			curr.freq--;

			// add previous removal back
			if (prev != null && prev.freq > 0) {
				pq.add(prev);
			}

			// collect current removal in previous
			prev = curr;
		}

		return res.length() == str.length() ? res : "Invalid";
	}

}
