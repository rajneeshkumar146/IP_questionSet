package SearchingSorting;

import java.util.ArrayList;
import java.util.Scanner;

public class Pep_JavaIP_2SnS_71InsertionAndMergingIntervals {
/* What: Given sorted and non-overlapping intervals array. Insert an interval
*
* How :
* Check for insertion in trivial cases
*  1.)beginning , 2.)end,
*  3.)whole array can be merged in this interval
*Find insertion point i,push all intervals less than i in stack
*Start from i th interval , push if non-overalp , merge if overlap till end
* of intervals array
*
*WHY:
*Similar to merging intervals.
*/
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int size = scn.nextInt();
		ArrayList<Pair> pairs = new ArrayList();
		for (int i = 0; i < size; i++) {
			pairs.add(new Pair(scn.nextInt(), scn.nextInt()));
		}
		int isv = scn.nextInt();
		int ilv = scn.nextInt();

		// 4 cases:
		/*Insert at beginning*/
		if (ilv < pairs.get(0).sv) {
			pairs.add(0, new Pair(isv, ilv));
		} /*Insert at end*/
			else if (isv > pairs.get(pairs.size() - 1).lv) {
			pairs.add(new Pair(isv, ilv));
		} /*Merge all intervals in current*/
			else if (isv <= pairs.get(0).sv && ilv >= pairs.get(pairs.size() - 1).lv) {
			pairs = new ArrayList();
			pairs.add(new Pair(isv, ilv));
		} else {
			boolean insertiondone = false;
			int insertAt = -1;
			for (int i = 0; i < pairs.size(); i++) {
				if (pairs.get(i).sv >= isv) {
					insertiondone = true;
					insertAt = i;
					break;
				} else {
					continue;
				}
			}

			if (insertiondone == false) {
				pairs.add(new Pair(isv, ilv));
			} else {
				pairs.add(insertAt, new Pair(isv, ilv));
			}
		}

		// Merge routine
		ArrayList<Pair> stack = new ArrayList<>();
		stack.add(pairs.get(0));

		for (int i = 1; i < pairs.size(); i++) {
			Pair tos = stack.get(stack.size() - 1);
			Pair curr = pairs.get(i);

			if (curr.sv >= tos.sv && curr.sv <= tos.lv) {
				tos.lv = curr.lv > tos.lv ? curr.lv : tos.lv;
			} else {
				stack.add(curr);
			}
		}

		for (Pair pair : stack) {
			System.out.println(pair.sv + " " + pair.lv);
		}

	}

	static class Pair {
		int sv;
		int lv;

		public Pair(int sv, int lv) {
			this.sv = sv;
			this.lv = lv;
		}
	}

}

/*
Test cases:
	2
	1 3
	6 9
	2 5
	------------------
	1 5
	6 9

5
1 2
3 5
6 7
8 10
12 16
4 9
-----------------
1 2
3 10
12 16

5
1 2
3 5
6 7
9 11
13 16
4 9
-------------------------
1 2
3 11
13 16

Source: https://www.geeksforgeeks.org/insert-in-sorted-and-non-overlapping-interval-array/



*/
