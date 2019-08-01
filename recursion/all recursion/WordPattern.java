package recursion;
import java.util.HashMap;
import java.util.HashSet;

public class WordPattern {

	public static void main(String[] args) {

		System.out.println(wordPattern("redblredbl", "abab"));
	}

	public static boolean wordPattern(String word, String pattern) {
		return isMatch(word, 0, pattern, 0, new HashMap<>(), new HashSet());
	}

	public static boolean isMatch(String word, int i, String pattern, int j, HashMap<Character, String> patternMap,
			HashSet<String> patternSet) {
		if (i == word.length() && j == pattern.length()) {
			return true;
		}
		if (i == word.length() || j == pattern.length()) {
			return false;
		}

		char c = pattern.charAt(j); // staring to match character from pattern to substring from word
		if (patternMap.containsKey(c)) {
			String s = patternMap.get(c);
			if (!word.startsWith(s, i)) { // next pattern must starts with same character in before
				return false;
			}
			return isMatch(word, i + s.length(), pattern, j + 1, patternMap, patternSet);
		}

		for (int k = i; k < word.length(); k++) {
			String tmpPattern = word.substring(i, k + 1);
			if (patternSet.contains(tmpPattern)) {
				continue;
			}
			patternMap.put(c, tmpPattern);
			patternSet.add(tmpPattern);
			if (isMatch(word, k + 1, pattern, j + 1, patternMap, patternSet)) { // increment pointers if pattern matches
				return true;
			}
			patternMap.remove(c);
			patternSet.remove(tmpPattern);
		}
		return false;
	}

}
