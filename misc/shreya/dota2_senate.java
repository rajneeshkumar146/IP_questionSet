package misc;

import java.util.LinkedList;

public class dota2_senate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str="RRRDDDRDD";
		System.out.println(predictPartyVictory(str));
	}

	public static String predictPartyVictory(String senate) {
		LinkedList<Integer> queue = new LinkedList<>();
		int[] people = { 0, 0 };
		int[] ban = { 0, 0 };

		for (int i = 0; i < senate.length(); i++) {
			int val = senate.charAt(i) == 'R' ? 1 : 0;
			people[val]++;
			queue.addLast(val);
		}
		while (people[0] > 0 && people[1] > 0) {
			int val = queue.removeFirst();
			if (ban[val] > 0) {
				ban[val]--;
				people[val]--;
			} else {
				ban[val ^ 1]++;
				queue.addLast(val);
			}
		}

		return people[1] > 0 ? "Radiant" : "Dire";
	}

}
