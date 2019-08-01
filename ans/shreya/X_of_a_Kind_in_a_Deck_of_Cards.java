package InternshipQuestionAs1;

import java.util.HashMap;
import java.util.Map;

public class X_of_a_Kind_in_a_Deck_of_Cards {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean hasGroupsSizeX(int[] deck) {

		if (deck.length < 2) {
			return false;
		}

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i : deck) {
			map.put(i, map.containsKey(i) ? map.get(i) + 1 : 1);
		}

		int min = Integer.MAX_VALUE;

		for (int n : map.keySet())
			min = Math.min(min, map.get(n));// min grp

		for (int i = 2; i <= min; i++) {// chck each grp of size i

			boolean possible = true;

			for (int n : map.keySet()) { // grp are dividable or not
				if (map.get(n) % i != 0) {
					possible = false;
					break;
				}
			}
			if (possible) { // if yes in any i<=min return true;
				return true;
			}
		}
		return false;
	}
}
