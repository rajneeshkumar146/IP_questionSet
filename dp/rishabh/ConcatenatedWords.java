import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class ConcatenatedWords {
	 public static List<String> findAllConcatenatedWordsInADict(String[] words) {
	        ArrayList<String> result = new ArrayList<>();
	        HashSet<String> preWords = new HashSet<>();
	        Collections.sort(words, new Comparator<String>() {
	            public int compare (String s1, String s2) {
	                return s1.length() - s2.length();
	            }
	        });
	        
	        for (int i = 0; i < words.length; i++) {
	            if (canForm(words[i], preWords)) {
	                result.add(words[i]);
	            }
	            preWords.add(words[i]);
	        }
	        
	        return result;
	    }
		
	    private static boolean canForm(String word, HashSet<String> dict) {
	        if (dict.isEmpty()) return false;
		boolean[] dp = new boolean[word.length() + 1];
		dp[0] = true;
		for (int i = 1; i <= word.length(); i++) {
		    for (int j = 0; j < i; j++) {
			if (!dp[j]) continue;
			if (dict.contains(word.substring(j, i))) {
			    dp[i] = true;
			    break;
			}
		    }
		}
		return dp[word.length()];
	    }
}
