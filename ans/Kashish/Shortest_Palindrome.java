package InternQuestAS1;

import java.util.Scanner;

public class Shortest_Palindrome {
	 public static  String shortestPalindrome(String s) {
	       StringBuilder rev=new StringBuilder(s);
	       rev.reverse();
	       String str=s+"#"+rev.toString();
	       int kmp[]=new int [str.length()];
	       kmp[0]=0;
	       for (int i = 1; i <str.length(); i++) {
	           int t = kmp[i-1];
	           while (t > 0 && str.charAt(i) != str.charAt(t))
	           {
	               t = kmp[t - 1];
	           }
	           if (str.charAt(i) == str.charAt(t))
	           { ++t;}
	           kmp[i] = t;
	       }
	       StringBuilder ans=new StringBuilder();
	       ans.append(rev.substring(0,s.length()-kmp[str.length()-1])).append(s);
	       return ans.toString();
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn=new Scanner(System.in);
		String s=scn.next();
		System.out.println(shortestPalindrome(s));
	}

}
