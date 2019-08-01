package InternQuestAS1;

import java.util.Scanner;

public class String_Compression {
	public static int compress(char[] chars) {
		int idx = 0;
		Character prev = null;
		for (int i = 0; i < chars.length; i++) {
			if (prev == null || chars[i] != prev) {
				prev = chars[i];
				chars[idx++] = chars[i];

			} else {
				int count = 2;
				while (i + 1 < chars.length && chars[i] == chars[i + 1]) {
					i++;
					count++;
				}
				String cnt = String.valueOf(count);   //12 should not be saved as "12" instead '1''2'; 
				for (char c : cnt.toCharArray())
					chars[idx++] = c;
			}
		}
		return idx;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		char ar[] = { 'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b' };
		System.out.println(compress(ar));

	}

}
