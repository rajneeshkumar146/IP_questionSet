package Strings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Pep_JavaIP_3Strings_116SortNumbersContaining123Only {

	private static ArrayList<Integer> printNumbers(int[] numbers)
    {
         
        ArrayList<Integer> array = new ArrayList<>();
        for (int number : numbers) {
             
            // check if the number contains 1, 
            // 2 & 3 in any order
            if (findContainsOneTwoThree(number))
                array.add(number);
        }
 
        // sort all the numbers
        Collections.sort(array);
         
        return array;
    }
 
    // convert the number to string and find 
    // if it contains 1, 2 & 3.
    private static boolean findContainsOneTwoThree(
                                         int number)
    {
         
        String str = Integer.toString(number);        
//using .contains() function . and return false if any of them is not present in the String.
        return (str.contains("1") && str.contains("2") && 
                                    str.contains("3"));
    }
 
    public static void main(String[] args) 
    {    
    	Scanner scn=new Scanner(System.in);  
    	int size=scn.nextInt();
    	int[] numbers=new int[size];
    	for(int i=0; i<size; i++) {
    		numbers[i]=scn.nextInt();
    	}
        System.out.println(printNumbers(numbers));
    }

}

/*
Test cases:

5
123 234 456 321 32145
---------------
[123, 321, 32145]

4
9821 627183 12 1234
----------------------------
[1234, 627183]


4
12 232 456 234
---------------------------
[]
	
	
	Source: https://www.geeksforgeeks.org/print-number-ascending-order-contains-1-2-3-digits/
 */

