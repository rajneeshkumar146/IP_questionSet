package pep_sns;

import java.util.Arrays;

public class heaters {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] houses = { 1, 2, 3, 4, 5, 6 };
		int[] heaters = { 1, 6, 5 };
		System.out.println(findRadius(houses, heaters));
	}

	public static int findRadius(int[] houses, int[] heaters) {
		Arrays.sort(heaters);
		int radius = 0;
		for (int i = 0; i < houses.length; i++) {
			int index = bsearch(houses[i], heaters);
			int prevh = index <= 0 ? 0 : index - 1;
			int currh = index < heaters.length ? index : index - 1;
			int currrad = Math.min(Math.abs(houses[i] - heaters[prevh]), Math.abs(houses[i] - heaters[currh]));
			radius = Math.max(radius, currrad);
		}
		return radius;
	}

	public static int bsearch(int val, int[] heaters) {
		int left = 0;
		int right = heaters.length - 1;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (heaters[mid] == val) {
				return mid;
			} else if (heaters[mid] < val) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return left;
	}

}
