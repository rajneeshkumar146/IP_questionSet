package SnS;

import java.util.Scanner;

public class unusual_String_sort {

	public static void main (String[] args) {
		
    	Scanner scn=new Scanner(System.in);
		int tc=scn.nextInt();
		for(int i=0;i<tc;i++){
		    String s=scn.next();
	        System.out.println(StringAlternateSort(s));
		}
	}
	public static String StringAlternateSort(String s){
	    int[] lowerCountArr=new int[26];
	    int[] upperCountArr=new int[26];
	    int u=0,l=0;
	    
	    for(int i=0;i<s.length();i++){
	        char ch=s.charAt(i);
	        if(ch>='A'&&ch<='Z'){
	            upperCountArr[ch-'A']++;
	        }else{
	            lowerCountArr[ch-'a']++;
	        }
	    }
        String res="";	 
	    for(int k=0;k<s.length();k++ ){
	        
	        while(u<26 &&upperCountArr[u]==0){
	            u++;
	        }
	        if(u<26){
	            res+=(char)('A'+u);
	            upperCountArr[u]--;
	        }
	        
	        while(l<26 &&lowerCountArr[l]==0){
	            l++;
	        }
	        if(l<26){
	            res+=(char)('a'+l);
	            lowerCountArr[l]--;
	        }
	    }
	    
	    return res;
	}
}
