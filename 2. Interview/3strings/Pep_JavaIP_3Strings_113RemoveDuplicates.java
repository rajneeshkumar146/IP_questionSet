package Strings;

import java.util.Scanner;

public class Pep_JavaIP_3Strings_113RemoveDuplicates {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		removeduplicates(str, 0, 0);
	}

	private static void removeduplicates(String str, int vidx, int diff) {
	//diff is the index of first same occurence in a continous form
	//for example String: abbbbbbo. b continous string starts from index 1 in the string.
	//diff stores the index 1.
	//diff won't change until the character becomes unequal to the next  character.
		if (vidx == str.length() - 1) {
			if (diff == vidx) {
	//diff is same as vidx that means no repeation in the last .
	//just print.
				System.out.println(str);
			} else {
	//remove all the characters that are repeated  and print the string after removal.
	
				str = str.substring(0, diff) + str.substring(vidx + 1);
				System.out.println(str);
			}
			return;
		}

		if (str.charAt(vidx) == str.charAt(vidx + 1)) {
	//increase vidx not diff ,  if any character repeats .	
		removeduplicates(str, vidx + 1, diff);
		} else {
	//if characters do not match ,
	//then change the string to the new string by deleting the same continous characters .
			if (vidx - diff > 0) {
				if (diff != 0) {
	
					str = str.substring(0, diff) + str.substring(vidx + 1);
					removeduplicates(str, diff - 1, diff - 1);
				} else {
	//handling the case : aaaaaabnbvh.removing all a's.
					str = str.substring(vidx + 1);
					removeduplicates(str, 0, 0);
				}
			}
			if (diff - vidx == 0) {
	//increment both  diff and vidx  to the same index.i.e. vidx+1.
				removeduplicates(str, vidx + 1, vidx + 1);
			}
		}
	}

}

/*
 * Test cases:
  
  azxxzy 
  --------------
  ay
  
  geeksforgeeg
  --------------------
  gksfor
  
  caaabbbaacdddd
  -------------------
  
  acaaabbbacdddd
  ---------------------
  acac
  
  Source:
  https://www.geeksforgeeks.org/recursively-remove-adjacent-duplicates-given-string/
  
  
 */
