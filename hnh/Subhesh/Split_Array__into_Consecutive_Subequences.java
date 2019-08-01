package HnH;

import java.util.HashMap;

public class Split_Array__into_Consecutive_Subequences {

	public static void main(String[] args) {
		int[] nums = { 9, 10, 11, 12, 13, 14, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 41, 42, 42, 43, 44,
				45, 46, 47, 47, 48, 48, 49, 49, 50, 50, 51, 51, 51, 52, 52, 52, 53, 53, 53, 54, 54, 54, 55, 55, 55, 56,
				56, 56, 57, 57, 57, 58, 58, 58, 59, 59, 59, 59, 60, 60, 60, 60, 61, 61, 61, 61, 62, 62, 62, 62, 63, 63,
				63, 63, 64, 64, 64, 64, 65, 65, 65, 65, 66, 66, 66, 66, 67, 67, 67, 67, 68, 68, 68, 68, 69, 69, 69, 69,
				70, 70, 70, 70, 71, 71, 71, 71, 72, 72, 72, 72, 73, 73, 73, 73, 74, 74, 74, 74, 75, 75, 75, 75, 76, 76,
				76, 76, 76, 77, 77, 77, 77, 77, 78, 78, 78, 78, 78, 79, 79, 79, 79, 80, 80, 80, 80, 81, 81, 81, 81, 82,
				82, 82, 82, 83, 83, 83, 83, 84, 84, 84, 84, 85, 85, 85, 85, 85, 86, 86, 86, 86, 86, 86, 87, 87, 87, 87,
				87, 87, 88, 88, 88, 88, 88, 88, 89, 89, 89, 89, 89, 89, 90, 90, 90, 90, 90, 90, 91, 91, 91, 91, 91, 91,
				92, 92, 92, 92, 92, 92, 93, 93, 93, 93, 93, 93, 94, 94, 94, 94, 94, 94, 95, 95, 95, 95, 95, 95, 96, 96,
				96, 96, 96, 96, 96, 97, 97, 97, 97, 97, 97, 97, 98, 98, 98, 98, 98, 98, 98, 99, 99, 99, 99, 99, 99, 99,
				100, 100, 100, 100, 100, 100, 100, 101, 101, 101, 101, 101, 101, 101, 102, 102, 102, 102, 102, 102, 102,
				103, 103, 103, 103, 103, 103, 103, 104, 104, 104, 104, 104, 104, 104, 105, 105, 105, 105, 105, 105, 106,
				106, 106, 106, 106, 106, 107, 107, 107, 107, 107, 107, 108, 108, 108, 108, 108, 108, 109, 109, 109, 109,
				109, 109, 110, 110, 110, 110, 110, 111, 111, 111, 111, 111, 112, 112, 112, 112, 112, 113, 113, 113, 113,
				113, 114, 114, 114, 114, 114, 115, 115, 115, 115, 115, 116, 116, 116, 116, 116, 117, 117, 117, 117, 118,
				118, 118, 118, 119, 119, 119, 119, 120, 120, 120, 120, 121, 121, 121, 122, 122, 122, 123, 123, 123, 124,
				124, 124, 125, 125, 125, 126, 126, 126, 127, 127, 127, 128, 128, 128, 129, 129, 129, 130, 130, 130, 131,
				131, 132, 132, 133, 133, 134, 134, 135, 135, 136, 136, 137, 137, 138, 138, 139, 139, 140, 140, 141, 141,
				142, 142, 143, 143, 144, 144, 145, 145, 146, 146, 147 };
		System.out.println(isPossible(nums));
	}

	public static boolean isPossible(int[] nums) {
		HashMap<Integer, Integer> count = new HashMap<>();
		HashMap<Integer, Integer> tail = new HashMap<>();
		for (int x : nums) {
			count.put(x, count.getOrDefault(x, 0) + 1);
		}

		for (int x : nums) {
			if (count.get(x) == 0) {
				continue;
			} else {
				count.put(x, count.get(x) - 1);
				if (tail.containsKey(x) == true && tail.get(x) > 0) {
					tail.put(x, tail.get(x) - 1);
					tail.put(x + 1, tail.getOrDefault(x, 0) + 1);
				} else if (count.containsKey(x + 1) && count.containsKey(x + 2) && count.get(x + 1) > 0
						&& count.get(x + 2) > 0) {
					count.put(x + 1, count.get(x + 1) - 1);
					count.put(x + 2, count.get(x + 2) - 1);
					tail.put(x + 3, tail.getOrDefault(x + 3, 0) + 1);
				} else {
					return false;
				}
			}
		}
		return true;
	}

	public static boolean isPossibleLeet(int[] nums) {
		Counter count = new Counter();
		Counter tails = new Counter();
		for (int x : nums)
			count.add(x, 1);

		for (int x : nums) {
			if (count.get(x) == 0) {
				continue;
			} else if (tails.get(x) > 0) {
				tails.add(x, -1);
				tails.add(x + 1, 1);
			} else if (count.get(x + 1) > 0 && count.get(x + 2) > 0) {
				count.add(x + 1, -1);
				count.add(x + 2, -1);
				tails.add(x + 3, 1);
			} else {
				return false;
			}
			count.add(x, -1);
		}
		return true;
	}
}

class Counter extends HashMap<Integer, Integer> {
	public int get(int k) {
		return containsKey(k) ? super.get(k) : 0;
	}

	public void add(int k, int v) {
		put(k, get(k) + v);
	}
}
