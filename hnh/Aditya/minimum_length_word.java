package may29;

import java.time.chrono.IsoChronology;
import java.util.HashMap;

public class minimum_length_word {
	
	public static void main(String[] args) {
		String[] words={"step","steps","stripe","stripes"};
		
		System.out.println(shortestCompletingWord("1s3 PSt", words));
	}
	
	public static String shortestCompletingWord(String licensePlate, String[] words) {
		int[] licensemap=new int[26];

		for (char c : licensePlate.toCharArray()) {
			if(c>='a' && c<='z')
			licensemap[c-'a']++;
			
			else if(c>='A' && c<='Z'){
				licensemap[c-'A']++;
			}
		}

		String ans = null;

		for (String word : words) {
			int[] wordmap=new int[26];
			for (char ch : word.toCharArray()) {
				wordmap[ch-'a']++;
			}

			Boolean bool = true;
			for (int c=0;c<26;c++) {
				if (licensemap[c]!=0 && (wordmap[c]==0 || (wordmap[c] < licensemap[c]))) {
					bool = false;
					break;
				}
			}

			if (bool == true && (ans == null || word.length() < ans.length())) {
				ans = word;
			}

		}

		return ans;
	}
}
