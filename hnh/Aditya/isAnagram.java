package may27;

import java.util.HashMap;

public class isAnagram {
	 public boolean isAnagram(String s, String t) {
	        HashMap<Character, Integer[]> smap=new HashMap<>();
	        
	        if(s.length()!=t.length()){
	        	return false;
	        }
	        
	        for(int i=0;i<s.length();i++){
	        	if(smap.containsKey(s.charAt(i))){
	        		Integer[] arr=smap.get(s.charAt(i));
	        		arr[0]=arr[0]+1;
	        	}
	        	else{
	        		Integer[] arr=new Integer[2];
	        		arr[0]=1;
	        		arr[1]=0;
	        		smap.put(s.charAt(i),arr);
	        	}
	        	
	        	if(smap.containsKey(t.charAt(i))){
	        		Integer[] arr=smap.get(t.charAt(i));
	        		arr[1]=arr[1]+1;
	        	}
	        	else{
	        		Integer[] arr=new Integer[2];
	        		arr[0]=0;
	        		arr[1]=1;
	        		smap.put(t.charAt(i),arr);
	        	}
	        }
	        
	        for(char c: smap.keySet()){
	        	if(smap.get(c)[0]!=smap.get(c)[1]){
	        		return false;
	        	}
	        }
	        return true;
	        
	        
	        
	    }
}
