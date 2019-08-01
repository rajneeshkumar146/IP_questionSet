package HnH;

import java.util.Arrays;

public class Longest_Duplicate_Substring {

	public static void main(String[] args) {
		String st = "banana";
		Longest_Duplicate_Substring obj = new Longest_Duplicate_Substring();
		String ans = obj.longestDupSubstring(st);
		System.out.println(ans);
	}

	public class Suffix implements Comparable<Suffix> {
		int index = 0;
		int[] rank = new int[2];

		@Override
		public int compareTo(Suffix other) {
			if (this.rank[0] == other.rank[0])
				return this.rank[1] - other.rank[1];
			return this.rank[0] - other.rank[0];
		}
	}

	private int[] buildSuffixArray(String s, int n) {
		// A structure to store suffixes and their indexes
		Suffix[] suffixes = new Suffix[n];
		// Store suffixes and their indexes in an array of structures.
		// The structure is needed to sort the suffixes alphabatically
		// and maintain their old indexes while sorting
		for (int i = 0; i < n; i++) {
			suffixes[i] = new Suffix();
			suffixes[i].index = i;
			suffixes[i].rank[0] = s.charAt(i) - 'a';
			suffixes[i].rank[1] = i < n - 1 ? s.charAt(i + 1) - 'a' : -1;
		}
		// Sort the suffixes using the comparison function defined in the Suffix class.
		Arrays.sort(suffixes);
		int[] ind = new int[n]; // This array is needed to get the index in suffixes[]
								// from original index. This mapping is needed to get next suffix.
		// At this point, all suffixes are sorted according to first
		// 2 characters. Let us sort suffixes according to first 4
		// characters, then first 8 and so on
		for (int k = 4; k < 2 * n; k *= 2) {
			// Assigning rank and index values to first suffix
			int rank = 0;
			int prev_rank = suffixes[0].rank[0];
			ind[suffixes[0].index] = 0;
			// Assigning rank to suffixes
			for (int i = 1; i < n; i++) {
				// If first rank and next ranks are same as that of previous
				// suffix in array, assign the same new rank to this suffix
				if (suffixes[i].rank[0] == prev_rank && suffixes[i].rank[1] == suffixes[i - 1].rank[1]) {
					prev_rank = suffixes[i].rank[0];
					suffixes[i].rank[0] = rank;
				} else // Otherwise increment rank and assign
				{
					prev_rank = suffixes[i].rank[0];
					suffixes[i].rank[0] = ++rank;
				}
				ind[suffixes[i].index] = i;
			}
			// Assign next rank to every suffix
			for (int i = 0; i < n; i++) {
				int nextindex = suffixes[i].index + k / 2;
				suffixes[i].rank[1] = (nextindex < n) ? suffixes[ind[nextindex]].rank[0] : -1;
			}
			// Sort the suffixes according to first k characters
			Arrays.sort(suffixes);
		}
		// Store indexes of all sorted suffixes in the suffix array
		int[] ret = new int[n];
		for (int i = 0; i < n; i++)
			ret[i] = suffixes[i].index;
		return ret;
	}

	int[] kasai(String s, int[] suffixArr) {
		int n = suffixArr.length;

		// To store LCP array
		int[] lcp = new int[n];
		// An auxiliary array to store inverse of suffix array
		// elements. For example if suffixArr[0] is 5, the
		// invSuff[5] would store 0. This is used to get next
		// suffix string from suffix array.
		int[] invSuff = new int[n];

		// Fill values in invSuff[]
		for (int i = 0; i < n; i++)
			invSuff[suffixArr[i]] = i;
		// Initialize length of previous LCP
		int k = 0;
		// Process all suffixes one by one starting from
		// first suffix in s
		for (int i = 0; i < n; i++) {
			/*
			 * If the current suffix is at n-1, then we don’t have next substring to
			 * consider. So lcp is not defined for this substring, we put zero.
			 */
			if (invSuff[i] == n - 1) {
				k = 0;
				continue;
			}
			/*
			 * j contains index of the next substring to be considered to compare with the
			 * present substring, i.e., next string in suffix array
			 */
			int j = suffixArr[invSuff[i] + 1];
			// Directly start matching from k'th index as
			// at-least k-1 characters will match
			while (i + k < n && j + k < n && s.charAt(i + k) == s.charAt(j + k))
				k++;

			lcp[invSuff[i]] = k;// lcp for the present suffix.

			// Deleting the starting character from the string.
			if (k > 0)
				k--;
		}
		return lcp;
	}

	public String longestDupSubstring(String S) {
		int[] suffixArr = buildSuffixArray(S, S.length());
		int n = suffixArr.length;
		int[] lcp = kasai(S, suffixArr);

		int ans = 0;
		int start = 0;

		for (int i = 0; i < n; i++) {
			if (lcp[i] > ans) {
				ans = lcp[i];
				start = suffixArr[i];
			}
		}

		if (ans == 0)
			return "";
		return S.substring(start, start + ans);
	}
}
