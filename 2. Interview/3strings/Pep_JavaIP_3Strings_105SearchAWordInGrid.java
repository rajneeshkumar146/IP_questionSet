package Strings;

import java.util.Scanner;

public class Pep_JavaIP_3Strings_105SearchAWordInGrid {
/* What : Given a 2D character array , find if word exists in it or not
 * How :  Keep each point of crossword as starting character, move in all 8 directions.
 *        Move in one directions till characters are matching, if chars don't match choose another direction
 *        If none of the 8 directions can match word return false
 * Why : Backtracking paradigm, Explore all choices , make a valid choice, if results in dead end backtrack
 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Scanner scn=new Scanner(System.in);

		int r=scn.nextInt();//This represents number of strings
		int c=scn.nextInt();//this represents length if each string

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

		if (grid[row][col] != word[0])
		      return false;

		    int len = str.length();

		    //travelling in all 8 directions
		    //one by one
		    for (int dir = 0; dir < 8; dir++)
		    {
		    	//incrementing the rd and cd
		    	//acc to directions .
		        int k, rd = row + x[dir], cd = col + y[dir];

		       //searching each direction with length of the word to be searched.

		        for (k = 1; k < len; k++)
		        {
		            if (rd >= grid.length || rd < 0 || cd >= grid[0].length || cd < 0)
		                break;

		            if (grid[rd][cd] != word[k])
		                break;

		            rd += x[dir];
		            cd += y[dir];
		        }

		        //if k becomes equal to the length ,return true.

		        if (k == len)
		            return true;
		    }
		    return false;

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
