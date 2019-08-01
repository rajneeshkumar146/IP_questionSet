package InternQuestDP;

import java.util.Scanner;

public class Sentence_Screen_Fitting {
	 public static int wordsTyping(String[] sentence, int rows, int cols) {
	        int count=0, j=0, rowsCountDown=rows;
	        int[] dp = new int[rows+1];
	        while (rowsCountDown > 0) {
	            int i = 0;
	            if (rowsCountDown!=rows && j==0)   break; // break if the first word repeats the pattern.
	            while (i <= cols && i+sentence[j].length()<=cols) {
	                i += sentence[j].length() + 1;
	                j++;
	                if (j == sentence.length) {
	                    j = 0;
	                    count++;
	                }

	            }
	            
	            rowsCountDown--;
	            dp[rows-rowsCountDown] = count;
	        }

	        if (rowsCountDown == 0) {
	            return count;
	        }
	        int remainder = (rows % (rows-rowsCountDown));
	        return (rows / (rows-rowsCountDown))*count + dp[remainder];
	    }
	
	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		int rows = 4; 
		int cols = 5;
		String[] sentence = {"I", "had", "apple", "pie"};
		System.out.println(wordsTyping(sentence, rows, cols));
		
		

	}

}
