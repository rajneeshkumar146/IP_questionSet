package InternQuestAS1;

import java.util.Scanner;

public class Permutation_in_String {
	   public static  boolean checkInclusion(String s1, String s2) {
		   if(s1.length()>s2.length()){
			   return false;
		   }
		   //every substring
	        int[] s1map = new int[26];
	        for (int i = 0; i < s1.length(); i++)
	        {
	            s1map[s1.charAt(i) - 'a']++;
	        }
	         for(int i=0;i<s2.length()-s1.length();i++){
	        	 int [] s2map=new int[26];
	        	 for(int j=0;j<s1.length();j++){
	        		 s2map[s2.charAt(i+j)-'a']++;
	        		 
	        	 }
	        	 if(matches(s1map, s2map)){
	        		 return true;
	        	 }
	         }
	        return false;
	    }
	    public static boolean matches(int[] s1map, int[] s2map) {
	        for (int i = 0; i < 26; i++) {
	            if (s1map[i] != s2map[i])
	                return false;
	        }
	        return true;
	    }
		   
	        
	    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn=new Scanner(System.in);
		String s1=scn.next();
		String s2=scn.next();
		System.out.println(checkInclusion(s1, s2));
		
		
		

	}

}
