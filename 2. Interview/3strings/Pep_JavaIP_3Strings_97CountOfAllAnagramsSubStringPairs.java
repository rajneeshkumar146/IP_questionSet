package Strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
/* What : Count of  all anagramic substrings
 * How :  Iterate over all substrings,generate key, identify all anagramic substrings, put their count in hashmap.
 *        Key: run length encoding of substring. Value: count of this type of anagrams
 *        Pairs of one anagramic susbtring -> (count*(count-1)) / 2  
 *        Total--> sum of count choose 2
 *
 * Why : RLE used to identify anagram in O(26).
*/
public class Pep_JavaIP_3Strings_97CountOfAllAnagramsSubStringPairs {

	/*public static void main (String[] args) {
	    Scanner sc =new Scanner(System.in);
	    String s=sc.next();
	    HashMap<String ,Integer> hash=new HashMap<>();
	    for(int i=0;i<s.length();i++)
	    {
	        String key="";
	        for(int j=i;j<s.length();j++)
	        {
	            key=s.substring(i,j+1);
	            char[] x=key.toCharArray();
	            Arrays.sort(x);
	            key=String.valueOf(x);
	            if(hash.containsKey(key))
	            {
	                Integer v=hash.get(key);
	                v=v+1;
	                hash.put(key,v);
	            }
	            else
	            {
	                hash.put(key,1);
	            }
	        }
	    }
	    int count=0;
	    ArrayList<String> al=new ArrayList(hash.keySet());
	    for(String num: al) {
	    	int res_intermediate=hash.get(num);
	    	count+=(res_intermediate*(res_intermediate-1))/2;
	    }
	    System.out.println(count);
	}*/
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		getprob(str);

	}

	public static HashMap<String, Integer> hm = new HashMap<>();

	public static void getprob(String str) {
		
		/*Iterate over all susbtrings, put them in hashmap*/
		for (int i = 0; i < str.length(); i++) {
			for (int j = i + 1; j <= str.length(); j++) {
				String sub = str.substring(i, j);
				putinmap(sub);
			}
		}

		int total = 0;
		
		for (String key : hm.keySet()) {
			int o = hm.get(key);

			total += ((o * (o - 1)) / 2);
		}
		System.out.println(total);
	}

	public static void putinmap(String sub) {
		
		int[] maker = new int[26];
		
		for (int i = 0; i < sub.length(); i++) {
			maker[sub.charAt(i) - 'a']++;
		}
		
		String ans = "";
        
        /*Creates Run-Length Encoding of string, spaces not included
         * xyy--> "a0 b0 c0... x1 y2 z0" , yyx--> ""a0 b0 c0...x1 y2 z0"
         * Two anagram strings have equivalent RLE
        */
		for (int i = 0; i < 26; i++) {
			int digit = maker[i];
			char ch = (char) (i + 'a');
			String add = String.valueOf(digit);
			ans = ans + ch + add;

		}
		
		/* If Map contains current RLE encoded string, this implies we have found anagram
		*increase count agianst it
		*/
		if (hm.containsKey(ans)) {

			int count = hm.get(ans);
			hm.put(ans, count + 1);
		} else {
			hm.put(ans, 1);

		}
	}

}

/*
Test cases:
xyyx
----------------------
4


geeg
-----------------
4

pepcoding
------------------------
2
	
	
	Source: https://www.geeksforgeeks.org/count-total-anagram-substrings/
 */
