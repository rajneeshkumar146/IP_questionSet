package recursion;

public class WordBreakProblem {

	public static void main(String[] args) {

		wordBreak("hcdarlrm", "");

	}

	public static boolean dictionaryContains(String word) {

//		String dictionary[] = { "mobile", "samsung", "sam", "sung", "man", "mango", "icecream", "and", "go", "i",
//				"love", "ice", "cream" };
		String[] dictionary = { "lr", "m", "lrm", "hcdar", "wk" };
		for (int i = 0; i < dictionary.length; i++) {
			if (dictionary[i].equals(word)) {
				return true;
			}
		}
		return false;
	}

	public static void wordBreak(String str, String asf) {

		for (int i = 1; i <= str.length(); i++) {

			String subStr = str.substring(0, i);
			if (dictionaryContains(subStr)) {
				if (i == str.length()) {
					System.out.print("(" + asf + subStr + ")");
					return;
				}
				wordBreak(str.substring(i), asf + subStr + " ");

			}

		}

	}

}
