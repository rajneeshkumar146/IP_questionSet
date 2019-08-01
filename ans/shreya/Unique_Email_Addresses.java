package InternQuestAS1;

import java.util.Scanner;

public class Unique_Email_Addresses {
	 public static  int numUniqueEmails(String[] emails) {
		int count=0;
		 StringBuilder ans=new StringBuilder();
	       
	        for(String s:emails){
	        	 StringBuilder sb=new StringBuilder();
	        	String splits[]=s.split("@",2);
	        	
	        	for(int i=0;i<splits[0].length();i++){
	        		if(splits[0].charAt(i)=='+'){
	        		 break;
	        		}
	        		else if(splits[0].charAt(i)!='.'){
	        			sb.append(splits[0].charAt(i));
	        		}
	        	}
	        	sb.append("@").append(splits[1]);
	        	if(!(ans.toString().contains(sb)))
	        	{
	        		ans.append(sb+" ");
	        		count++;
	        	}
	        }
	        return count;
		 
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn=new Scanner(System.in);
		String s[] ={"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"};
		System.out.println(numUniqueEmails(s));
		

	}

}
