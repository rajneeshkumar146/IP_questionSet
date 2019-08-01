package hnh;

import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

public class rearrangecharacters {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int test = scn.nextInt();
		for (int t = 1; t <= test; t++) {
			String s = scn.next();
			System.out.println(rearrangecharacters(s));
		}

	}

	public static int rearrangecharacters(String s) {
		PriorityQueue<pair> vs = new PriorityQueue<>(Collections.reverseOrder());
		HashMap<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (map.containsKey(ch)) {
				map.put(ch, map.get(ch) + 1);
			} else {
				map.put(ch, 1);
			}

		}
		pair prev = new pair();
		prev.value = '#';
		prev.freq = 0;
		for (char val : map.keySet()) {
			pair p = new pair();
			p.value = val;
			p.freq = map.get(val);
			vs.add(p);
		}
		StringBuilder sb = new StringBuilder();
		while (vs.size() > 0) {
			pair pop = vs.remove();
			sb.append(pop.value);
			pop.freq = pop.freq - 1;
			if (prev.freq > 0) {
				vs.add(prev);
			}
			prev.value = pop.value;
			prev.freq = pop.freq;

		}
		if (sb.length() != s.length()) {
			return 0;
		} else {
			return 1;
		}
	}

	private static class pair implements Comparable<pair> {
		char value;
		int freq;

		@Override
		public int compareTo(pair o) {
			// TODO Auto-generated method stub
			return this.freq - o.freq;
		}
	}
}
