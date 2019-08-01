package recursion;

import java.util.*;

public class SubsetSum {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		for (int i = 0; i < t; i++) {
			int n = scn.nextInt();
			int[] arr = new int[n];
			for (int j = 0; j < n; j++)
				arr[j] = scn.nextInt();
			ArrayList<String> result = getSubsets(arr, 0);
			int[] subSets = new int[(int) Math.pow(2, n)];
			int p = 0;
			for (int j = 0; j < result.size(); j++) {
				String str = result.get(j);
				int count = 0;
				for (int k = 0; k < str.length() - 1; k += 2) {
					if (str.charAt(k) != ' ' && str.charAt(k + 1) != ' ') {
						String sb = "";
						while (str.charAt(k) != ' ') {
							sb += (str.charAt(k));
							k++;
						}
						count += Integer.parseInt(sb);
						k--;
					} else if (str.charAt(k) != ' ')
						count += (int) str.charAt(k) - 48;
				}
				subSets[p] = count;
				p++;
			}
			Arrays.sort(subSets);
			for (int l = 0; l < subSets.length; l++)
				System.out.print(subSets[l] + " ");
			System.out.println();
		}
	}

	public static ArrayList<String> getSubsets(int[] arr, int si) {
		if (si == arr.length) {
			ArrayList<String> br = new ArrayList<>();
			br.add(" ");
			return br;
		}
		int fi = arr[si];
		ArrayList<String> recResult = getSubsets(arr, si + 1);
		ArrayList<String> myResult = new ArrayList<>();
		for (int i = 0; i < recResult.size(); i++) {
			String s = recResult.get(i);
			myResult.add(s);
			myResult.add(fi + " " + s);
		}
		return myResult;
	}
}