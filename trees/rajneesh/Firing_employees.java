package Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Firing_employees {

	// array represent, rank who handle other rank employees, arr[0,1,1,2] index
	// 1,2,3,4 means rank 0 is CEO and rank 1 handle rank 2 and 3 people
	// employee.

	static boolean[] prime;
	static ArrayList<Integer> primeNo = new ArrayList<>();

	static int[] depth;  
	static ArrayList<Integer>[] arr;  //which rank people handle which rank people.
	static int count = 0;  //count of all non primme outcomes.

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		while (t-- > 0) {
			int n = scn.nextInt();

			arr = new ArrayList[n + 1];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = new ArrayList<>();
			}

			depth = new int[n + 1];
			int src = 0;
			count = 0;

			for (int i = 1; i <= n; i++) {
				int val = scn.nextInt();
				arr[val].add(i);
				if (val == 0)
					src = i;
			}
			primePopulate();

			dfs(src, 0);  //src always be CEO index having 0 depth.
			ans(src);
			System.out.println(count);
		}
	}

	public static void ans(int src) {
		for (int i = 0; i < arr[src].size(); i++) {
			if (isPrime(arr[src].get(i) + depth[arr[src].get(i)]))  //checkimg prime condition.
				count++;
			ans(arr[src].get(i)); //recursive call source
		}

	}

	public static void dfs(int src, int d) {
		depth[src] = d;
		for (int i = 0; i < arr[src].size(); i++) {
			dfs(arr[src].get(i), depth[src] + 1);
		}
	}

	public static void primePopulate() {
		prime = new boolean[1000];
		Arrays.fill(prime, true);
		prime[0] = false;
		prime[1] = false;

		for (int i = 2; i < prime.length; i++) {
			for (int j = i * i; prime[i] && j < prime.length; j += i) {
				prime[j] = false;
			}
			primeNo.add(i);
		}
	}

	public static boolean isPrime(int n) {
		if (n < prime.length) {
			return prime[n];
		}

		for (int i = 0; primeNo.get(i) * primeNo.get(i) <= n; i++) {
			if (n % primeNo.get(i) == 0) {
				return false;
			}
		}
		return true;
	}

}
