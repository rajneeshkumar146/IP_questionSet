package interview.arrays;

import java.util.HashMap;
import java.util.Scanner;

public class Pep_JavaIP_1Arrays_40LongestSubArrayDivisibleByK {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		int[] arr = new int[scn.nextInt()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}
		int k = scn.nextInt();

		solve(arr, k);
	}

	private static class Pair {
		int sp; // starting point of sequence
		int length; // length of sequence

		Pair(int sp, int length) {
			this.sp = sp;
			this.length = length;
		}
	}

	private static void solve(int[] arr, int k) {
		int[] mod = new int[arr.length];
		HashMap<Integer, Pair> map = new HashMap<>();

		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
			mod[i] = sum % k; // storing modulus of prefix sums
		}

		int osp = -1;
		int omaxl = Integer.MIN_VALUE;
		
		map.put(0, new Pair(-1, 0)); // to begin with sum is 0, assuming a seq of 0 length starts at -1
		for (int i = 0; i < mod.length; i++) {
			Pair pair;

			if (!map.containsKey(mod[i])) {
				pair = new Pair(i, 1); // if the mod is detected for first time putting in a pair of 1 length
				map.put(mod[i], pair);
			} else {
				// if an existing pair is detected, calculate how far it is from the point same mod was detected
				pair = map.get(mod[i]);
				pair.length = i - pair.sp;
			}

			// updating overall length for a longer sequence
			if (pair.length > omaxl) {
				osp = pair.sp + 1;
				omaxl = pair.length;
			}
		}
		
		for(int i = 0; i < omaxl; i++){
			System.out.print(arr[osp + i] + " ");
		}
	}

}
