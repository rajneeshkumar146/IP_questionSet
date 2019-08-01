package InternQuestDP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Word_Break {
	  public static boolean wordBreak(String str, ArrayList<String> wordDict) {
		  boolean dp[][]=new boolean[str.length()][str.length()];
		 for(int gap=0;gap<str.length();gap++){
			 for(int s=0,e=gap+s;e<str.length();e++,s++){
				 if(wordDict.contains(str.substring(s, e+1))){
					 dp[s][e]=true;
				 }
				 else{
					 for(int k=s;k<e;k++){
						 if(dp[s][k] && dp[k+1][e]){
							 dp[s][e]=true;
							 break;
						 }
					 }
				 }
			 }
		 }
		 
//		 for(int i=0;i<dp.length;i++){
//			 for(int j=0;j<dp[0].length;j++){
//				 System.out.print(dp[i][j]+" ");
//			 }
//			 System.out.println();
//		 }
		return dp[0][str.length()-1];
	        
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn=new Scanner(System.in);
        String s="leetcode";
        ArrayList<String> Dict=new ArrayList<>(Arrays.asList("leet", "code"));
        System.out.println(wordBreak(s, Dict));
	}

}
