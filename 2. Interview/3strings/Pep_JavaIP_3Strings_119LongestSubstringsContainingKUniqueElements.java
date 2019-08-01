package Strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Pep_JavaIP_3Strings_119LongestSubstringsContainingKUniqueElements {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		int k=scn.nextInt();
		printsubstring(str, k);
	}

	private static void printsubstring(String str, int k) {
		int max_window_size=0;
	//storing the max window size.
		int max_window_start=0;
	//storing the index of the start of the window.
		int u=0;
	//storing frequencies  of the  characters  by inrementing the count of their occurences.
		int[] fmap=new int[26];
		for(int i=0; i<str.length(); i++) {
	//if the character appears first time. then k unique characters were
	// needed, now k-1 iunique characters are needed.
			if(fmap[str.charAt(i)-'a']==0) {
				u++;
			}
			fmap[str.charAt(i)-'a']++;
		}
		
		if(u<k) {
			return;
		}
		
		int curr_start=0,curr_end=0;
		Arrays.fill(fmap,0);
		fmap[str.charAt(0)-'a']++;
		for(int i=1; i<str.length(); i++) {
			fmap[str.charAt(i)-'a']++;
			curr_end++;
		//if k is not achieved then end would increase.
			while(!isValid(fmap,k)) {
				fmap[str.charAt(curr_start)-'a']--;
		//but it exceeds k,then start decreasing the frequency by incrementing their start.
		//additionally ,reduce their frequency  because they are no longer part of the window
		//with k uniqiue chars until the number of characters again becomes equal to k.  
				curr_start++;
			}
			
			if (curr_end-curr_start+1 > max_window_size)
	        {
	//update window if required
	            max_window_size = curr_end-curr_start+1;
	            max_window_start = curr_start;
	        }
		}
		
		System.out.println(str.substring(max_window_start, max_window_start+max_window_size));
		}
	
	private static boolean isValid(int[] fmap, int k) {
		int val=0;
		for(int i=0; i<26; i++) {
			if(fmap[i]>0) {
				val++;
			}
		}
		return k>=val;
	}

}

/*
 * Test cases:
aabbcc
1
 ---------------
 aa
 
 aabbccd
2
 ---------------
 aabb
 
 
 xaabbccdghiiiii
3
 ---------------
 ghiiiii
  
 
  Source:
 https://www.geeksforgeeks.org/find-the-longest-substring-with-k-unique-characters-in-a-given-string/
  
  
 */


