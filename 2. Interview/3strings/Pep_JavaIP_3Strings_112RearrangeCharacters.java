package Strings;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Pep_JavaIP_3Strings_112RearrangeCharacters {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		int d = scn.nextInt();
		rearrange(str, d);
	}
	//rearrange the letters so that they become d distance away.

	public static void rearrange(String str, int d) {
		int[] f = new int[26];
		pq = new PriorityQueue<Pairs>();
		//stores the charcter and frequency  in pair 
		
		for (int i = 0; i < str.length(); i++)
			f[str.charAt(i) - 'a']++;
		//incrementing the frequency of characters 
		for (int i = 0; i < 26; i++) {
			if (f[i] != 0) {
				Pairs p = new Pairs((char) (i + 'a'), f[i]);
				pq.add(p);
				adding into the priority queue.
			}
		}
		int n = str.length();
		int pos = 0;
		char[] ch = new char[n];
		
	//The idea is to put the most  frequent number at the starting and move d distance in array ,
	//again put all its occurences until it becomes 0.
	 // then 1 ,1+d.1+2d... so on indices will be filled with the second most frequent number.

			while (!pq.isEmpty()) {
			Pairs temp = pq.poll();

			while (ch[pos] != '\u0000')
				pos++;
			if ((temp.freq - 1) * d + pos >= n) {
	//due to shortage of array , in other words occurences are more than
	// d-distant blocks that can be formed in an array			
				System.out.println("Not possible");
				return;
			}
			for (int i = 0; i < temp.freq; i++) {
				ch[pos + i * d] = temp.ch;
			}

		}
		for (int i = 0; i < n; i++)
			System.out.print(ch[i]);
	}
	//object of this class contains character ch, and frequency freq.
	
	static class Pairs implements Comparable<Pairs> {
		char ch;
		int freq;

		Pairs(char c, int f) {
			ch = c;
			freq = f;
		}

		Pairs() {
		}

		public int compareTo(Pairs p) {
			return this.freq <= p.freq ? 1 : -1;
		}
	}

}

/*
Test cases:
	aaabb
	2
	-------------
	ababa
	
	geeksforgeeeks
	2
	----------------------
	egegesesekrkfo
	
	
	worldisallaboutmoney
	3
	----------------------
	loaloalomwutyrednsib
	
	
	geeks
	6
	-------------------
	Not Possible
	Source: https://www.geeksforgeeks.org/rearrange-a-string-so-that-all-same-characters-become-at-least-d-distance-away/
	*/


