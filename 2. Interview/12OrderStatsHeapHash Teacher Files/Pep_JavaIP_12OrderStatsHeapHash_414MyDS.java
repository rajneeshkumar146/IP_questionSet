package OrderStatsHeapHash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Pep_JavaIP_12OrderStatsHeapHash_414MyDS {
/**
 * Build your own data structure
 */
	public static void main(String[] args) {
		// You have to do 4 operations
		// 1 is for insert
		// 2 is for remove
		// 3 is for search
		// 4 is for getrandom
		// 0 for terminating
		Scanner scn = new Scanner(System.in);
		myDs ds = new myDs();
		int ch=-1;
		do {
			ch = scn.nextInt();
			switch (ch) {
			case 1:
				ds.insert(scn.nextInt());
				System.out.println(ds.list);
				break;
			case 2:
				ds.delete(scn.nextInt());
				System.out.println(ds.list);
				break;
			case 3:
				System.out.println(ds.search(scn.nextInt()));
				break;
			case 4:
				System.out.println(ds.getRandom());
			}
		} while (ch != 0);

	}

	public static class myDs {

		HashMap<Integer, Integer> hm = new HashMap<>();
		ArrayList<Integer> list = new ArrayList<>();

		public void insert(int data) {

			list.add(data);
			int idx = list.size() - 1;
			hm.put(data, idx);
		}

		public int delete(int data) {
			if (!hm.containsKey(data)) {
				return -1;
			}

			int idx = hm.get(data);
			hm.remove(data);

			int temp = list.get(idx);
			list.set(idx, list.get(list.size() - 1));
			list.set(list.size() - 1, temp);
			list.remove(list.size() - 1);

			return temp;
		}

		public boolean search(int data) {
			return hm.containsKey(data);

		}

		public int getRandom() {

			int rand = (int) (Math.random() * list.size());

			return list.get(rand);
		}
	}

}
