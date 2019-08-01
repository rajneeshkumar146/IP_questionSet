import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
 
public class PermPal {
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int T = scn.nextInt();
		for (int i = 0; i < T; i++) {
			String s = scn.next();
			getprob(s);
 
		}
 
	}
 
	private static void getprob(String s) {
		int[] count = new int[26];
		int[] placement = new int[26];
		Arrays.fill(placement, -1);
		int[] arr = new int[s.length()];
		int odd = 0;
		char od;
		// freq map
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			int index = ch - 'a';
			count[index]++;
		}
		// check validity, all chars freq must be even
		// or only char should have odd frequency
		for (int i = 0; i < 26; i++) {
			if (count[i] % 2 == 0) {
				continue;
			} else {
				odd++;
				od = (char) ('a' + i);
			}
		}
		if (odd > 1) {
			System.out.println(-1);
			return;
		}
 
		int fill = 0;
		for (int j = 0; j < s.length(); j++) {
 
			char ch = s.charAt(j);
			int index = ch - 'a';
			//even freq char , put at both extremes
			if (count[index] % 2 == 0) {
				if (placement[index] == -1) {
					arr[fill] = j;
					placement[index] = s.length() - 1 - fill;
					fill++;
				} else {
 
					arr[placement[index]] = j;
					placement[index] = -1;
					count[index] = count[index] - 2;
				}
			} else {
				arr[(s.length()/2)]=j;
				count[index]--;
			}
 
		}
		
		for(int i=0;i<arr.length;i++){
			System.out.print((arr[i]+1)+" ");
		}
		System.out.println();
	}
 
}
