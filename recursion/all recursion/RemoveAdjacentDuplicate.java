package recursion;
import java.util.*;
import java.lang.*;
import java.io.*;

public class RemoveAdjacentDuplicate {
	static String recur(String s, int i, int n) {
		if (i >= n)
			return s;
		int j = i;
		while (i + 1 < n && s.charAt(i) == s.charAt(i + 1)) {
			i++;

		}
		if (i > j && i + 1 < n)
			s = s.substring(0, j) + s.substring(i + 1);
		else if (i > j)
			s = s.substring(0, j);
		else
			return recur(s, j + 1, s.length());
		return recur(s, j, s.length());
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			String s = sc.next();
			s = recur(s, 0, s.length());
			s = recur(s, 0, s.length());
			System.out.println(recur(s, 0, s.length()));
		}
	}
}
