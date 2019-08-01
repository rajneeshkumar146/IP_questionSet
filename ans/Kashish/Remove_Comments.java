package InternQuestAS1;

import java.util.ArrayList;
import java.util.Scanner;

public class Remove_Comments {
	public static ArrayList<String> removeComments(String[] source) {
		 boolean state = false;
	     StringBuilder newline = new StringBuilder();
	    ArrayList<String> ans = new ArrayList();
	     for (String line: source) {
	         int i = 0;
	         char[] chars = line.toCharArray();
	         if (!state)
	         { newline = new StringBuilder();}
	         while (i < line.length()) {
	             if (!state && i+1 < line.length() && chars[i] == '/' && chars[i+1] == '*') {
	                 state = true;
	                 i++;
	             } else if (state && i+1 < line.length() && chars[i] == '*' && chars[i+1] == '/') {
	                 state = false;
	                 i++;
	             } else if (!state && i+1 < line.length() && chars[i] == '/' && chars[i+1] == '/') {
	                 break;
	             } else if (!state) {
	                 newline.append(chars[i]);
	             }
	             i++;
	         }
	         if (!state && newline.length() > 0) {
	             ans.add(new String(newline));
	         }
	     }
	     return ans;
	}

	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		String[] source = { "/*Test program */", "int main()", "{ ", "  // variable declaration ", "int a, b, c;", "/* This is a test", "   multiline  ", "   comment for ", "   testing */", "a = b + c;", "}" };
		System.out.println(removeComments(source));
	}
	
}
