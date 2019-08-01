-----------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------
                                       Question Description
-----------------------------------------------------------------------------------------
1. You are given an array of different dates of 21st century.
2. You have to efficiently sort the given array of dates.
       For eg : for ->          20  1 2014
	                              25  3 2010
	                               3 12 2000
		the sorted array will be ->  3 12 2000
		                            25  3 2010
														    20  1 2014 								
-----------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------
package SearchingSorting;

import java.util.Scanner;

public class Pep_JavaIP_2SnS_62SortDates {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		Date[] arr = new Date[scn.nextInt()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = new Date(scn.nextInt(), scn.nextInt(), scn.nextInt());
		}
		CountingSortday(arr);
		CountingSortmonth(arr);
		CountingSortyear(arr);
		for (Date date : arr) {
			System.out.println(date.day + " " + date.month + " " + date.year);
		}
	}

	private static void CountingSortyear(Date[] arr) {

      //function to sort years

	}

	private static void CountingSortmonth(Date[] arr) {

      //function to sort months

	}

	private static void CountingSortday(Date[] arr) {

	    //function to sort days

	}

	static class Date {
		int day;
		int month;
		int year;

		public Date(int day, int month, int year) {
			this.day = day;
			this.month = month;
			this.year = year;
		}
	}

}
/*
 6
20  1 2014
25  3 2010
 3 12 2000
18 11 2005
19  4 2015
 9  7 2005
-------------------------------
3 12 2000
9 7 2005
18 11 2005
25 3 2010
20 1 2014
19 4 2015

 6
20  1 2013
25  3 2010
 3 12 2009
18 11 2009
19  4 2015
 9  7 2009
 ----------------------
 9 7 2009
18 11 2009
3 12 2009
25 3 2010
20 1 2013
19 4 2015

6
20  1 2014
9  3 2011
 9 12 2011
9 11 2005
19  4 2015
 9  7 2005
 --------------------------
 9 7 2005
9 11 2005
9 3 2011
9 12 2011
20 1 2014
19 4 2015

Source: https://www.geeksforgeeks.org/how-to-efficiently-sort-a-big-list-dates-in-20s/
 */
