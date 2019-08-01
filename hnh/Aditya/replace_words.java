package may29;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class replace_words {
	public String replaceWords(ArrayList<String> dict, String sentence) {

		HashSet<String> dictionary=new HashSet<>();
		
		for(String s:dict){
			dictionary.add(s);
		}
		
		StringBuilder word=new StringBuilder("");
		StringBuilder ans=new StringBuilder("");
		
		
		//["cat", "bat", "rat"]
		//"the cattle was rattled by the battery"
		int i=0;
		while(i<sentence.length()){
			char c=sentence.charAt(i);
			
			if(i==sentence.length() && dictionary.contains(word)==false){
				ans.append(" "+word);
			}
			
			if(c==' '){
				ans.append(' '+word.toString());
				word=new StringBuilder("");
				i++;
				continue;
			}
			
			word.append(c);
			
			if(dictionary.contains(word.toString())){
				ans.append(word.toString());
				word=new StringBuilder("");
				
				while(i<sentence.length() && sentence.charAt(i)!=' '){
					i++;
				}
				i++;	//move till net space
			}

			else{
				i++;
			}
		}
		return ans.toString();
		
		
	}
}
