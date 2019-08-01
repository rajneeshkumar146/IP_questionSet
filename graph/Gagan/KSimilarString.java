package graphs;

import java.util.HashSet;
import java.util.LinkedList;

public class KSimilarString {

	public static void main(String[] args) {

		System.out.println(kSimilarity("bccaba", "abacbc"));
	}

	public static int kSimilarity(String A, String B) {

		if (A.equals(B)) {
			return 0;
		}

		HashSet<String> used = new HashSet<String>();
		LinkedList<String> queue = new LinkedList<String>();
		queue.add(A);
		int start = 0;
		int res = 0;
		while (A.charAt(start) == B.charAt(start)) {
			start++;
		}
		while (!queue.isEmpty()) {

			int n = queue.size();
			for (int i = 0; i < n; i++) {
				String str = queue.removeLast();
				int j = start;
				while (str.charAt(j) == B.charAt(j)) {
					j++;
				}
				for (int k = j + 1; k < B.length(); k++) {
					if (str.charAt(k) == B.charAt(j)) {
						String newString = swap(str, k, j);
						if (used.contains(newString)) {
							continue;
						}
						if (newString.equals(B)) {
							return res + 1;
						}
						queue.addFirst(newString);
						used.add(newString);
					}
				}

			}
			res++;
			start++;

		}
		return res;

	}

	public static String swap(String str, int i, int j) {

		char[] temp = str.toCharArray();
		char ch = temp[i];
		temp[i] = temp[j];
		temp[j] = ch;

		return new String(temp);

	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
