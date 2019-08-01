package may27;

import java.util.ArrayList;
import java.util.HashMap;

public class Uncommon_words_in_two_sentences {

	public static void main(String[] args) {
		 //Input: A = "this apple is sweet", B = "this apple is sour"
		//Output: ["sweet","sour"]
		String[] ans=uncommonFromSentences("this apple is sweet", "this apple is sour");
		 System.out.println(ans[0]+" "+ans[1]);
	}

	public static String[] uncommonFromSentences(String A, String B) {

		HashMap<String, Integer> hmap = new HashMap<>();

		StringBuilder word = new StringBuilder("");
		char c;

		int idx = 0;
		while (idx <= A.length()) {
			if (idx==A.length() || A.charAt(idx) == ' ') {
				if (hmap.containsKey(word.toString())) {
					hmap.put(word.toString(), hmap.get(word.toString()) + 1);
				} else {
					hmap.put(word.toString(), 1);
				}
				word = new StringBuilder("");
			} else {
				word.append(A.charAt(idx));
			}
			idx++;
		}
		 
		
		idx = 0;
		while (idx <= B.length()) {
			if (idx==B.length() || B.charAt(idx) == ' ' ) {
				if (hmap.containsKey(word.toString())) {
					hmap.put(word.toString(), hmap.get(word.toString()) + 1);
				} else {
					hmap.put(word.toString(), 1);
				}
				word = new StringBuilder("");
			} else {
				word.append(B.charAt(idx));
			}
			idx++;
		}
		
		ArrayList<String> ans=new ArrayList<>();
		
		for(String w:hmap.keySet()){
			if(hmap.get(w)==1){
				ans.add(w);
			}
		}
		
		String[] anss=new String[ans.size()];
		for(int i=0;i<ans.size();i++){
			anss[i]=ans.get(i);
		}
		
		return anss;
		

	}

}
