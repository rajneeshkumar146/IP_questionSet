package OrderStatsHeapHash;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class Pep_JavaIP_12OrderStatsHeapHash_416GroupShiftedStrings {

	public static void main(String[] args) {
		// Given an array of strings, we have to print all those strings, which have
		// same length and are similarly shifted.
		// similarly shifted means adf and gjl. a and d are separated by 2 characters,
		// similarly g and j are separated by
		// 2 characters. d and f are similarly separated as j and l.
		Scanner scn = new Scanner(System.in);
		String[] array = new String[scn.nextInt()];
		for (int i = 0; i < array.length; i++) {
			array[i] = scn.next();
		}

		// for each string make a code and add it to the hashmap of String ,
		// ArrayList<Strings>
		HashMap<String, ArrayList<String>> map = new HashMap<>();
		for (String str : array) {
			String code = generatecode(str);
			if (map.containsKey(code)) {
				ArrayList<String> al = map.get(code);
				al.add(str);
				map.put(code, al);
			} else {
				ArrayList<String> al = new ArrayList<>();
				al.add(str);
				map.put(code, al);
			}
		}

		ArrayList<String> al = new ArrayList<>(map.keySet());
		Collections.sort(al);

		for (String str : al) {
			for (String st : map.get(str)) {
				System.out.print(st+" ");
			}
			System.out.println();
		}

	}

	private static String generatecode(String str) {
		String ans = "";
		for (int i = 1; i < str.length(); i++) {
			int diff = str.charAt(i) - str.charAt(i - 1);
			ans += (diff + 26) % 26;// this is to handle the fact that yab and acd are similarly shifted strings
		}
		return ans;
	}

}
/*
Test cases:10
a x acd dfg wyz yab mop bdfh moqs b
--------------
a x b 
acd dfg wyz yab mop 
bdfh moqs

10
a x acd dfg wyz yab mop bdfh moqs xza
-------------------
a x 
acd dfg wyz yab mop xza 
bdfh moqs

5
a b c abc xyz
---------------
a b c
abc xyz

Source: https://www.geeksforgeeks.org/group-shifted-string/


*/