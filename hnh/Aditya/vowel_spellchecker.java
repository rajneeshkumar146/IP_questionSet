package may28;

import java.util.HashMap;
import java.util.HashSet;

public class vowel_spellchecker {

	HashSet<String> perfectWords=new HashSet<>();
	HashMap<String ,String> lcwords=new HashMap<>();
	HashMap<String, String> vowelless=new HashMap<>();
	public String[] spellchecker(String[] wordlist, String[] queries) {

		
		
		for(String word:wordlist){
			perfectWords.add(word);
			
			String newWord=word.toLowerCase();
			lcwords.putIfAbsent(newWord, word);
			
			String newWord2=removeVowel(newWord);
			vowelless.putIfAbsent(newWord2, newWord);
		}
		
		
		String[] answers=new String[queries.length];
		
		int i=0;
		for(String query:queries){
			answers[i++]=getAnswer(query);
		}
		
		return answers;
		
	}
	
	
	
	String removeVowel(String str){
		StringBuilder temp=new StringBuilder("");
		for(char c:str.toCharArray()){
			if(c=='a'||c=='e'||c=='i'||c=='o'||c=='u'){
				temp.append('*');
			}
			else{
				temp.append(c);
			}
		}
		return temp.toString();
	}

	String getAnswer(String query){
		if(perfectWords.contains(query)){
			return query;
		}
		
		String newQuery=query.toLowerCase();
		if(lcwords.containsKey(newQuery)){
			return lcwords.get(newQuery);
		}
		
		String newQuery2=removeVowel(newQuery);
		if(vowelless.containsKey(newQuery2)){
			return vowelless.get(newQuery2);
		}
		
		return "";
	}
}
