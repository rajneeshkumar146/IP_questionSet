--------------------------------------------------------------------------------
Question  Description
--------------------------------------------------------------------------------
1. You are given a number.
2. You have to print its corresponding Excel column name.
--------------------------------------------------------------------------------
Code
--------------------------------------------------------------------------------
package Strings;

import java.util.Scanner;

public class Pep_JavaIP_3Strings_118FindCorrespondingExcelColumnName {

	private static void printString(int columnNumber)
    {
        //function to print corresponding excel column name
				//to the given column number
    }

    // Driver program to test above function
    public static void main(String[] args)
    {
      Scanner scn=new Scanner(System.in);
    	int num=scn.nextInt();
    	printString(num);
    }

}

/*
 * Test cases:
 12
 ---------------
 L

 51
 ------------
 AY

 52
 -----------------
 AZ

 80
 --------------------
 CB

 676
 --------------------
 YZ

 702
 ----------------
 ZZ

 705
 ---------------
 AAC


  Source:
  https://www.geeksforgeeks.org/find-excel-column-name-given-number/


 */
