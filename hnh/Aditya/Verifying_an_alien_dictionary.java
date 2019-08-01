package may27;

import java.util.HashMap;

public class Verifying_an_alien_dictionary {

	public static void main(String[] args) {
			String[] words={"mtkwpj","wlaees"};
			String dict="evhadxsqukcogztlnfjpiymbwr";
			
			
			/*
			 *["mtkwpj","wlaees"]
"evhadxsqukcogztlnfjpiymbwr"
			 */
			System.out.println(isAlienSorted(words, dict));
	}

	public static  boolean isAlienSorted(String[] words, String order) {

		HashMap<Character, Integer> dictionary = new HashMap<>();

		int i = 0;
		for (char c : order.toCharArray()) {
			dictionary.put(c, i);
			i++;
		}

		int prev_word = 0;
		int next_word = 1;

		while (next_word < words.length) {

			String prevWord = words[prev_word];
			String nextword = words[next_word];
			prev_word++;
			next_word++;

			if (prevWord.length() < nextword.length()) {
				for (int k = 0; k < prevWord.length(); k++) {
					if (dictionary.get(prevWord.charAt(k)) > dictionary.get(nextword.charAt(k))) {
						return false;
					} else if (dictionary.get(prevWord.charAt(k)) < dictionary.get(nextword.charAt(k))) {
						break;
					}
				}
				
				continue;
			} 
			
			else if (prevWord.length() > nextword.length()) {
				int k=0;
				for (k = 0; k < nextword.length(); k++) {
					if (dictionary.get(prevWord.charAt(k)) > dictionary.get(nextword.charAt(k))) {
						return false;
					} else if (dictionary.get(prevWord.charAt(k)) < dictionary.get(nextword.charAt(k))) {
						break;
					}
				}
				
				if(k==nextword.length()){
					return false;
				}
				
				

			} 
			
			else {
				for (int k = 0; k < prevWord.length(); k++) {
					if (dictionary.get(prevWord.charAt(k)) > dictionary.get(nextword.charAt(k))) {
						return false;
					} else if (dictionary.get(prevWord.charAt(k)) < dictionary.get(nextword.charAt(k))) {
						break;
					}
				}
			}

			
		}

		// for(String word:words){
		//
		// int prev=0;
		// int next=1;
		//
		// while(next<word.length()){
		// if(dictionary.get(prev)>dictionary.get(next)){
		// return false;
		// }
		// prev++;
		// next++;
		// }
		// }

		return true;

	}

}
