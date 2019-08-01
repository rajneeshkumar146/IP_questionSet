package may27;

import java.util.HashMap;

public class word_pattern {

	public static void main(String[] args) {
		
		System.out.println(wordPattern("aaa", "dog dog dog dog"));
	}

	static Boolean wordPattern(String pattern, String str) {
         
        
        HashMap<Character, String>  pmap=new HashMap<>();
        HashMap<String,Boolean> smap=new HashMap<>();
        
        int idx=0;
        for(int i=0;i<pattern.length();i++){
        	char ch=pattern.charAt(i);
        	
        	StringBuilder word=new StringBuilder("");
        	char c;
        	
        	while(idx<str.length() && str.charAt(idx)!=' '){
        		word.append(str.charAt(idx));
        		
        		idx++;
        	}
        	idx++;
        	
        	
        	
        	if(pmap.containsKey(ch)){
        		String prev=pmap.get(ch);
        		if(prev.compareTo(word.toString())!=0){
        			return false;
        		}
        	}
        	else{
        		
        		if(smap.containsKey(word.toString()) && smap.get(word.toString())==true){
        			return false;
        		}
        		pmap.put(ch, word.toString());
        		smap.put(word.toString(), true);
        		
        	}
        	
        	
        }
        
        if(idx==str.length()+1){
        	return true;
        }
        
        
        return false;
	}
	
}
