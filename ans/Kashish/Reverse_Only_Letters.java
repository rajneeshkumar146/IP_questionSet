package InternQuestAS1;

import java.util.Scanner;
import java.util.Stack;

public class Reverse_Only_Letters {
public static String reverseOnlyLetters(String S) {
	 Stack<Character> letters = new Stack();
     for (char c: S.toCharArray())
         if (Character.isLetter(c))
         {
             letters.push(c);
         }

     StringBuilder ans = new StringBuilder();
     for (char c: S.toCharArray()) {
         if (Character.isLetter(c))
         {
             ans.append(letters.pop());
         }
         else
         {
             ans.append(c);
         }
     }

     return ans.toString();
    }

	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		
		 String Input= "Test1ng-Leet=code-Q!";
		 System.out.println(reverseOnlyLetters(Input));
				

	}

}
