package InternQuestAS1;

import java.util.Scanner;
import java.util.Stack;

public class Reverse_Vowels_of_a_String {
	 public static  String reverseVowels(String s) {
		 Stack<Character> list=new Stack<>();
		 for(int i=0;i<s.length();i++){
			 if(s.charAt(i)=='a'||s.charAt(i)=='A'|| s.charAt(i)=='e'||s.charAt(i)=='E'|| s.charAt(i)=='i'||s.charAt(i)=='I'||s.charAt(i)=='o'||s.charAt(i)=='O'||s.charAt(i)=='u'||s.charAt(i)=='U'){
				 list.push(s.charAt(i));
			 }
		 }
		 StringBuilder sb=new StringBuilder();
		 for(int i=0;i<s.length();i++){
			 if(s.charAt(i)=='a'||s.charAt(i)=='A'|| s.charAt(i)=='e'||s.charAt(i)=='E'|| s.charAt(i)=='i'||s.charAt(i)=='I'||s.charAt(i)=='o'||s.charAt(i)=='O'||s.charAt(i)=='u'||s.charAt(i)=='U'){
				 sb.append(list.pop());
			 }
			 else{
				 sb.append(s.charAt(i));
			 }
		 }
		 return sb.toString();
	        
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn=new Scanner(System.in);
		String s=scn.next();
		System.out.println(reverseVowels(s));
		

	}

}
