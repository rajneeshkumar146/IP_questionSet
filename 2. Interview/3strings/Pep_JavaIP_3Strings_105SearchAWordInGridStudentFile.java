-----------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------
                                       Question Description
-----------------------------------------------------------------------------------------
1. You are given an integer n, which represents number of strings.
2. You are given an integer l, which represents length of each string.
3. You are also given n strings, each of l length. 
   Assume a 2-D array of characters is formed(like a crossword puzzle)
   from these strings of size n*l;
4. You are also given a string, which represents the word
   that you have to search in the crossword puzzle.
5. A word can be found in all 8 directions from a given point.
6. You have to print Yes if word is found, otherwise print No.
-----------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------
package Strings;

import java.util.Scanner;

public class Pep_JavaIP_3Strings_105SearchAWordInGrid {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Scanner scn=new Scanner(System.in);

		int r=scn.nextInt();//This represents number of strings
		int c=scn.nextInt();//this represents length of each string

		char[][] grid=new char[r][c];
		String[] str=new String[r];
		for(int i=0;i<r;i++) {
				str[i]=scn.next();
		}
		
		for(int i=0; i<r; i++) {
			for(int j=0; j<c; j++) {
				grid[i][j]=str[i].charAt(j);
			}
		}
		// taken input in a 2d grid of characters 
		//take input string which has to be searched .
		
		String str1=scn.next();
		
		boolean x = getprob(grid,str1);
				if(x) {
					System.out.println("Yes");
				}
				else
				System.out.println("No");

	}

	public static boolean  getprob(char[][] grid, String str) {
		for (int row = 0; row < grid.length; row++)
		       for (int col = 0; col < grid[0].length; col++)
		          if (search2D(grid, row, col, str))
		      		return true;
			//checking at every point of 2d grid .
		//via calling the method search 2d .
		
		return false;
	}

	public static boolean search2D(char[][] grid, int row, int col, String str) {
		int x[] = { -1, -1, -1, 0, 0, 1, 1, 1 };
		int y[] = { -1, 0, 1, -1, 1, -1, 0, 1 };
		char[] word=str.toCharArray();
		
		
	}

}

/*
Test cases:
3
13
GEEKSFORGEEKS
GEEKSQUIZGEEK
IDEQAPRACTICE
GEEKS
----------------------
Yes
	
3
13
GEEKSFORGEEKS
GEEKSQUIZGEEK
IDEQAPRACTICE
GEERS
----------------------
No
	
	
3
13
GEEKSFORGEEKS
GEEKSQUIZGEEK
IDEQAPRACTICE
EEQ
----------------------
Yes
	
Source: https://www.geeksforgeeks.org/search-a-word-in-a-2d-grid-of-characters/
*/


