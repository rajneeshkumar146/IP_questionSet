package SearchingSorting;

import java.util.Scanner;

public class Pep_JavaIP_2SnS_62SortDates {
/* What : Given a list of dates, starting from 2000's . EFFICIENTLY sort them.
*
* How : Apply radix sort idea. Sort by day, then month, then year.
*
* Why :Least significant digit in a date is day. Then month, year is MSB.
* ex: 25/08/2001 is not greater than 3/4/2002 even though both month and
*			day are bigger
*
*/
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
		Date[] output = new Date[arr.length];
		// Now lets apply counting sort
		int[] count_array = new int[100];

		for (int i = 0; i < arr.length; i++) {
			count_array[arr[i].year % 2000]++;
		}

		for (int i = 1; i < count_array.length; i++) {
			count_array[i] += count_array[i - 1];
		}

		for (int i = arr.length - 1; i >= 0; i--) {
			// place each arr[i] at its correct position.
			output[count_array[arr[i].year % 2000] - 1] = arr[i];
			count_array[arr[i].year % 2000]--;
		}

		for (int i = 0; i < arr.length; i++) {
			arr[i] = output[i];
		}
	}

	private static void CountingSortmonth(Date[] arr) {
		Date[] output = new Date[arr.length];
		// Now lets apply counting sort
		int[] count_array = new int[13];

		for (int i = 0; i < arr.length; i++) {
			count_array[arr[i].month]++;
		}

		for (int i = 1; i < count_array.length; i++) {
			count_array[i] += count_array[i - 1];
		}

		for (int i = arr.length - 1; i >= 0; i--) {
			// place each arr[i] at its correct position.
			output[count_array[arr[i].month] - 1] = arr[i];
			count_array[arr[i].month]--;
		}

		// revert back the changes
		for (int i = 0; i < arr.length; i++) {
			arr[i] = output[i];
		}
	}

	private static void CountingSortday(Date[] arr) {
		Date[] output = new Date[arr.length];
		// Now lets apply counting sort
		int[] count_array = new int[32];

		for (int i = 0; i < arr.length; i++) {
			count_array[arr[i].day]++;
		}

		for (int i = 1; i < count_array.length; i++) {
			count_array[i] += count_array[i - 1];
		}

		for (int i = arr.length - 1; i >= 0; i--) {
			// place each arr[i] at its correct position.
			output[count_array[arr[i].day] - 1] = arr[i];
			count_array[arr[i].day]--;
		}

		for (int i = 0; i < arr.length; i++) {
			arr[i] = output[i];
		}

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
