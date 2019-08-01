package may27;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;



public class top_K_frequent_words {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] words={"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
		System.out.println(topKFrequent(words, 4));

	}
	
	
	static class pair implements Comparable<pair>{
		public String s;
		public int occ;
		
		public pair(String s,int occ){
			this.s=s;
			this.occ=occ;
		}
		
		@Override
		public int compareTo(pair o) {
			// TODO Auto-generated method stub
			if( this.occ!=o.occ){
				return o.occ-this.occ;
			}
			else{
				return this.s.compareTo(o.s);
			}
		}
	}
	
	 public static  ArrayList<String> topKFrequent(String[] words, int k) {
	         ArrayList<String> ans=new ArrayList<String>();
	         
	         HashMap<String, Integer> wordMap=new HashMap<>();
	         for(String s:words){
	        	 if(wordMap.containsKey(s)){
	        		 wordMap.put(s, wordMap.get(s)+1);
	        	 }
	        	 else{
	        		 wordMap.put(s, 1);
	        	 }
	         }
	         
	         PriorityQueue<pair> pq=new PriorityQueue<>();
	         for(String word:wordMap.keySet()){
	        	 pq.add(new pair(word,wordMap.get(word)));
	         }
	         
	         for(int i=0;i<k;i++){
	        	 ans.add(pq.remove().s);
	         }
	         return ans;
	    }

}
