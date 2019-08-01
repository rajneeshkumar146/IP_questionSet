package SnS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class tywins_war_strategy {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int tc = scn.nextInt();
		for (int j = 0; j < tc; j++) {
			int n = scn.nextInt();
			int k = scn.nextInt();
			int targetTroops = (int) Math.ceil((double) n / 2);
			int curTroops = 0;
			ArrayList<Integer> tr = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				int x = scn.nextInt();
				if (x % k == 0) {
					curTroops++;
				} else {
					tr.add(x % k);
				}
			}
			int res = 0;
			targetTroops = targetTroops - curTroops;
			Collections.sort(tr, Collections.reverseOrder());
			for (int i = 0; i < targetTroops; i++) {
				res += (k - tr.get(i));
			}

			System.out.println(res);
		}
	}

}
