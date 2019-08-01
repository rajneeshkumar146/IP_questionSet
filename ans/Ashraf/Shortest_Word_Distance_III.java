package InternshipQuestionAs1;

public class Shortest_Word_Distance_III {

	public static void main(String[] args) {
		String[] words = { "practice", "makes", "practice", "practice", "makes" };
		System.out.println(shortestWordDistance(words, "practice", "practice"));
	}

	public static int shortestWordDistance(String[] words, String word1, String word2) {
		if (words == null || words.length < 1 || word1 == null || word2 == null)
			return 0;

		int m = -1;
		int n = -1;

		int min = Integer.MAX_VALUE;
		int turn = 0;
		if (word1.equals(word2))
			turn = 1;

		for (int i = 0; i < words.length; i++) {
			String s = words[i];
			if (word1.equals(s) && (turn == 1 || turn == 0)) {
				m = i;
				if (turn == 1)
					turn = 2;
				if (n != -1)
					min = Math.min(min, m - n);
			} else if (word2.equals(s) && (turn == 2 || turn == 0)) {
				n = i;
				if (turn == 2)
					turn = 1;
				if (m != -1)
					min = Math.min(min, n - m);
			}
		}

		return min;
	}
}
