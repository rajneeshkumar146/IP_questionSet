-----------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------
                                       Question Description
-----------------------------------------------------------------------------------------
1. You are given a set of non-overlapping intervals, containing n intervals, and a new interval.
  for eg : [1 3], [6 9], new interval : [2 5].
2. You have to insert the new interval in its correct position.
   => [1 3], [2 5], [6 9].
3. If the insertion of new interval results in overlapping intervals,
   then you have to merge the overlapping intervals.
	 => [1 3], [6 9]
4. Print the resultant intervals.
   => 1 3
	    6 9
-----------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------
package SearchingSorting;

import java.util.ArrayList;
import java.util.Scanner;

public class Pep_JavaIP_2SnS_71InsertionAndMergingIntervals {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int size = scn.nextInt();
		ArrayList<Pair> pairs = new ArrayList();
		for (int i = 0; i < size; i++) {
			pairs.add(new Pair(scn.nextInt(), scn.nextInt()));
		}
		int isv = scn.nextInt();
		int ilv = scn.nextInt();



     // code to insertion of new interval


		ArrayList<Pair> stack = new ArrayList<>();
		stack.add(pairs.get(0));

	   //code to merge intervals

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
