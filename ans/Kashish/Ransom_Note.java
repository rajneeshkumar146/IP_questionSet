package InternQuestAS1;

import java.util.Scanner;

public class Ransom_Note {
    public static boolean canConstruct(String rans, String magazine) {
    	int ranmap[]=new int[26];
    	int magmap[]=new int[26];
    	for(int i=0;i<rans.length();i++){
    		ranmap[rans.charAt(i)-'a']++;
    	}
    	for(int i=0;i<magazine.length();i++){
    		magmap[magazine.charAt(i)-'a']++;
    	}
    	for(int i=0;i<rans.length();i++){
    		if(ranmap[rans.charAt(i)-'a']>magmap[rans.charAt(i)-'a']){
    			return false;
    		}
    	}
    	return true;
    	
        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn=new Scanner(System.in);
		String s="aa";
		String t="aab";
		System.out.print(canConstruct(s, t));
		
		

	}

}
