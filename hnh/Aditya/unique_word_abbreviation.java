package may31;

import java.util.HashMap;
import java.util.HashSet;

public class unique_word_abbreviation {
	// custom class problem 
	//leet premium
	
	HashMap<String, Boolean> abbrmap;
	HashSet<String> wordmap;

	public unique_word_abbreviation(String[] dictionary) {
        abbrmap=new HashMap<>();
        wordmap=new HashSet<>();
        
        for(String word:dictionary){
        	if(word.length()<=2){
        		wordmap.add(word);
        		continue;
        	}
        	else{
        		String s=""+word.charAt(0) + (word.length()-2) + word.charAt(word.length()-1);
        		if(abbrmap.containsKey(s)){
        			abbrmap.put(s, true);
        		}
        		else{
        			abbrmap.put(s, false);
        		}
        		wordmap.add(word);
        	}
            
            
        }
    }

	public boolean isUnique(String word) {
		String abbr="" + word.charAt(0) + (word.length() - 2) + word.charAt(word.length() - 1);
		
		 
		Boolean hasabbr=abbrmap.get(abbr);
		 return hasabbr == null || (hasabbr && wordmap.contains(word));
	}
}
