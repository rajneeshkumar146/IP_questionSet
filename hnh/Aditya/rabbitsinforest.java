package hnh;

import java.util.HashMap;
import java.util.HashSet;

public class rabbitsinforest {

	public static void main(String[] args) {

	}

	public static int rabbits(int[] arr) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			if (!map.containsKey(arr[i])) {
				map.put(arr[i], 1);
			} else {
				map.put(arr[i], map.get(arr[i]) + 1);
			}

		}
public 
	}
}
